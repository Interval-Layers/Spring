package net.intervallayers.spring.controller

import net.intervallayers.spring.model.*
import net.intervallayers.spring.repository.*
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.*
import org.springframework.boot.test.context.*
import org.springframework.http.*
import org.springframework.test.web.servlet.*
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.setup.*
import org.springframework.web.context.*

@SpringBootTest
internal class APIControllerTest {

    @Autowired
    private lateinit var context: WebApplicationContext

    @Autowired
    private lateinit var entityRepository: EntityRepository

    private lateinit var mockMvc: MockMvc

    @BeforeEach
    fun setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build()
    }

    @AfterEach
    fun tearDown() {
        entityRepository.deleteAll()
    }

    /**
     * Checks that API access is available.
     */
    @Test
    fun getAPI() {
        mockMvc
            .perform(get("/api/"))
            .andDo(print())
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    }

    /**
     * Checks that all Entity documents can be get in the database from API.
     */
    @Test
    fun getEntity() {
        entityRepository.insert(arrayListOf(Entity("Test1"), Entity("Test2")))

        mockMvc
            .perform(get("/api/entity"))
            .andDo(print())
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[0].name", `is`("Test1")))
            .andExpect(jsonPath("$[1].name", `is`("Test2")))
    }

    /**
     * Checks that Entity documents are counted correctly in the database from API.
     */
    @Test
    fun getEntityCount() {
        entityRepository.insert(arrayListOf(Entity("Test1"), Entity("Test2")))

        mockMvc
            .perform(get("/api/entity/count"))
            .andDo(print())
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$", `is`(2)))
    }

    /**
     * Checks if an Entity document can be found using name in the database from API.
     */
    @Test
    fun getEntityByName() {
        entityRepository.insert(arrayListOf(Entity("Test1"), Entity("Test2")))

        mockMvc
            .perform(get("/api/entity/name").param("name", "Test2"))
            .andDo(print())
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[0].name", `is`("Test2")))
    }

    /**
     * Checks whether an Entity document can be inserted into the database from API.
     */
    @Test
    fun putEntity() {
        mockMvc
            .perform(put("/api/entity/name").param("name", "Test"))
            .andDo(print())
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))

        val list = entityRepository.findAllByName("Test")

        Assertions.assertEquals(list.size, 1)
        Assertions.assertEquals(list[0].name, "Test")
    }

    /**
     * Checks whether an Entity document can be deleted in the database from API.
     */
    @Test
    fun deleteEntity() {
        val entity = Entity("Test").also { entityRepository.insert(it) }

        mockMvc
            .perform(delete("/api/entity/id").param("id", entity.id.toString()))
            .andDo(print())
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))

        Assertions.assertEquals(entityRepository.count(), 0)
    }

}
