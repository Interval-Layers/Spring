package net.intervallayers.spring.view.page

import kotlinx.html.*
import net.intervallayers.spring.repository.*
import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*

@Component
class EntityPage : GenericPage() {

    @Autowired
    private lateinit var entityRepository: EntityRepository

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
                        entityRepository.findAll().forEach {
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
