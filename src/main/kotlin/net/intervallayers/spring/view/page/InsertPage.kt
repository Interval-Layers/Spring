package net.intervallayers.spring.view.page

import kotlinx.html.*
import net.intervallayers.extensions.html.*
import net.intervallayers.spring.model.*
import org.springframework.stereotype.*

@Component
class InsertPage : GenericPage() {

    private lateinit var entity: Entity

    fun setEntity(block: (Unit) -> Entity) = also { entity = block(Unit) }

    override fun BODY.main() {
        main {
            section(classes = "main-container") {
                h1("title") { text("Inserted \"${Entity::class.java.simpleName}\": ") }
                h2 { pre { text(entity) } }
                a(href = "/", classes = "form-button apply-margin-top-8px") { text("Return to the main page") }
            }
        }
    }
}
