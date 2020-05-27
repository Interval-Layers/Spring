package net.intervallayers.spring.model

import org.junit.jupiter.api.*
import org.springframework.boot.test.context.*

@SpringBootTest
internal class EntityTest {

    /**
     * Verifies that the Entity document is correctly initialized, lateinit variable id is not null, and the name applied correctly
     */
    @Test
    fun entityIsCreatable() {
        val entity = Entity("Test")

        Assertions.assertEquals(entity.name, "Test")
        Assertions.assertNotNull(entity.id)
    }

    /**
     * Checks that id of different Entity documents are not identical.
     */
    @Test
    fun entityId() {
        val entity = Entity("Test")
        val entityWrong = Entity("TestWrong")
        val entitySimilar = Entity("Test")

        Assertions.assertEquals(entity.id, entity.id)
        Assertions.assertNotEquals(entity.id, entityWrong.id)
        Assertions.assertNotEquals(entity.id, entitySimilar.id)
    }

}
