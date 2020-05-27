package net.intervallayers.spring.security

import org.springframework.security.config.annotation.web.builders.*
import org.springframework.security.config.annotation.web.configuration.*

/**
 * Configurer adapter of Spring Security for Spring MVC
 * By default activated for all Application
 */
@EnableWebSecurity
class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    /**
     * Basic Spring Security configuration for all HTTP/HTTPS requests
     * Disable HTTP/HTTPS authentication for all requests
     * Disable CSRF for Application
     */
    override fun configure(security: HttpSecurity) {
        security.httpBasic().disable()
        security.csrf().disable()
    }

}
