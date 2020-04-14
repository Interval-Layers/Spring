package net.intervallayers.spring.configuration

import net.intervallayers.spring.model.*
import org.springframework.context.annotation.*
import org.springframework.stereotype.*

@Component
class ApplicationConfiguration {
    @Bean
    private fun entity() = Entity("", "", "")
}
