package net.intervallayers.spring.model

import org.springframework.http.*
import java.net.*

/**
 * POJO class for serialization to JSON
 * Designed for provide API component
 */
data class API(private val _address: URI, val method: HttpMethod, val description: String) {

    /**
     * Backing field for _address
     * @return /api + _address
     */
    @Suppress("unused")
    val address: URI
        get() = URI("/api$_address")

}
