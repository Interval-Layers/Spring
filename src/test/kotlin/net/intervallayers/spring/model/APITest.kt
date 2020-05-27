package net.intervallayers.spring.model

import org.junit.jupiter.api.*
import org.springframework.boot.test.context.*
import org.springframework.http.*
import java.net.*

@SpringBootTest
internal class APITest {

    /**
     * Checks that backing field address correct combine value.
     */
    @Test
    fun addressCorrect() {
        val api = API(URI("/test"), HttpMethod.GET, "Test API")

        Assertions.assertEquals(api.address, URI("/api/test"))
    }

}
