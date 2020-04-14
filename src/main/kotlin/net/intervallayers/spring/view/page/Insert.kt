package net.intervallayers.spring.view.page

import kotlinx.html.*
import net.intervallayers.spring.model.*
import net.intervallayers.spring.model.html.*
import net.intervallayers.spring.model.html.element.*
import org.springframework.stereotype.*

@Component
class Insert : AbstractPage() {

    private var entity: Entity? = null

    fun setEntity(block: (Unit) -> Entity) = also { entity = block(Unit) }

    override fun HTML.body() {
        body {
            headerBodyConstructor()
            div(classes = "body-container") {
                h1("title") { text("Inserted \"${Entity::class.java.simpleName}\": ") }
                h2 { pre { text(entity) } }
                a(href = "/", classes = "button-container") { text("Return to the main page ->>") }
            }
            footerBodyConstructor()
        }
    }
}
