package net.intervallayers.spring

import org.springframework.boot.builder.*
import org.springframework.boot.web.servlet.support.*

class ServletInitializer : SpringBootServletInitializer() {
    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        return application.sources(Application::class.java)
    }
}
