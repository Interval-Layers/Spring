package net.intervallayers.spring.repository

import net.intervallayers.spring.model.*
import org.bson.types.*
import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.*
import org.springframework.boot.test.context.*

@SpringBootTest
internal class EntityRepositoryTest {

    @Autowired
    private lateinit var entityRepository: EntityRepository

    private lateinit var entityOne: Entity
    private lateinit var entityTwo: Entity
    private lateinit var entityThree: Entity

    @BeforeEach
    fun setUp() {
        entityOne = Entity("Test")
        entityTwo = Entity("Test")
        entityThree = Entity("Test")
    }

    /**
     * Checks whether an Entity document can be inserted into the database.
     */
    @Test
    fun insertEntity() {
        val entity = Entity("Test")
        val entityWrong = Entity("Wrong")

        entityRepository.insert(entity)

        Assertions.assertEquals(entityRepository.findAllByName("Test")[0], entity)
        Assertions.assertNotEquals(entityRepository.findAllByName("Test")[0], entityWrong)
    }

    /**
     * Checks if an Entity document can be found using id in the database.
     */
    @Test
    fun findById() {
        val entity = Entity("Test")

        entityRepository.insert(entity)

        Assertions.assertEquals(entityRepository.findById(entity.id).get(), entity)
        Assertions.assertNotEquals(entityRepository.findById(entity.id).get().id, ObjectId())
    }

    /**
     * Checks whether all Entity documents can be deleted from the database.
     */
    @Test
    fun deleteAll() {
        entityRepository.insert(arrayListOf(entityOne, entityTwo, entityThree))
        entityRepository.deleteAll()

        Assertions.assertArrayEquals(emptyArray<Entity>(), entityRepository.findAll().toTypedArray())
    }

    /**
     * Checks if an Entity document can be found using name in the database.
     */
    @Test
    fun findByName() {
        entityRepository.insert(arrayListOf(entityOne, entityTwo, entityThree))

        Assertions.assertArrayEquals(arrayOf(entityOne, entityTwo, entityThree), entityRepository.findAllByName("Test").toTypedArray())
    }

    /**
     * Checks whether all Entity documents can be found from the database.
     */
    @Test
    fun findAll() {
        entityRepository.insert(arrayListOf(entityOne, entityTwo, entityThree))

        Assertions.assertArrayEquals(arrayOf(entityOne, entityTwo, entityThree), entityRepository.findAll().toTypedArray())
    }

    /**
     * Checks whether an Entity document can be deleted in the database.
     */
    @Test
    fun deleteById() {
        val entity = Entity("Test")
        val entityWrong = Entity("Wrong")

        entityRepository.insert(entity)
        entityRepository.insert(entityWrong)
        entityRepository.delete(entityWrong)

        Assertions.assertArrayEquals(arrayOf(entity), entityRepository.findAll().toTypedArray())
    }

    /**
     * Checks that Entity documents are counted correctly in the database.
     */
    @Test
    fun count() {
        entityRepository.insert(arrayListOf(entityOne, entityTwo, entityThree))

        Assertions.assertEquals(arrayOf(entityOne, entityTwo, entityThree).size.toLong(), entityRepository.count())
    }

    @AfterEach
    fun tearDown() {
        entityRepository.deleteAll()
    }

}
