package net.intervallayers.spring

import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.*
import org.springframework.boot.test.context.*
import org.springframework.test.web.servlet.*
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.setup.*
import org.springframework.web.context.*


@SpringBootTest
internal class ApplicationTest {

    @Autowired
    private lateinit var context: WebApplicationContext

    private lateinit var mockMvc: MockMvc

    @BeforeEach
    fun setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build()
    }

    /**
     * Checks that the application starts correctly and there is an opportunity to access it.
     */
    @Test
    fun applicationIsRunnable() {
        mockMvc
            .perform(get("/"))
            .andDo(print())
            .andExpect(status().isOk)
    }

}
