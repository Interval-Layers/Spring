package net.intervallayers.spring.view.page

import kotlinx.html.*
import net.intervallayers.spring.model.*

class EntityPage : GenericPage() {

    private lateinit var entities: List<Entity>

    fun setEntities(entities: List<Entity>) = also { it.entities = entities }

    override fun BODY.main() {
        main {
            section(classes = "main-container") {
                h1 { text("Viewer of entities") }

                article("card") {
                    table {
                        tr {
                            td { text("ID") }
                            td { text("TIME") }
                            td { text("NAME") }
                        }
                        entities.forEach {
                            tr {
                                td { text(it.id) }
                                td { text(it.time) }
                                td { button(classes = "apply-underline") { text(it.name) } }
                            }
                        }
                    }

                    a(href = "/", classes = "form-button") {
                        text("Return to the main page")
                    }
                }
            }
        }
    }
}
