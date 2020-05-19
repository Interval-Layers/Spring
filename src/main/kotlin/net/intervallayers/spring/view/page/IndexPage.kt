package net.intervallayers.spring.view.page

import kotlinx.html.*
import net.intervallayers.extensions.html.*
import net.intervallayers.spring.*
import net.intervallayers.spring.repository.*
import net.intervallayers.spring.view.element.*
import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*

@Component
class IndexPage : GenericPage() {

    @Autowired
    private lateinit var entityRepository: EntityRepository

    override fun BODY.main() {
        main {
            section(classes = "main-container") {
                h1 { text(Application::class.java.packageName.toUpperCase()) }

                div("card-container") {
                    article(classes = "card") {
                        h3 { text("Add new Entity") }

                        form(method = FormMethod.post) {
                            id = "insertEntity"
                            onSubmit = "return insertEntitySubmitEvent()"

                            button(classes = "form-button") {
                                id = "insertEntityButton"
                                disabled = true
                                text("Add Entity")
                            }

                            input(name = "name") {
                                id = "insertEntityInput"
                                maxLength = "12"
                                onInput = "insertEntityInputChange()"
                                placeholder = "Enter name"
                                autoComplete = false
                            }
                        }
                    }

                    article(classes = "card") {
                        h3 { text("Status of DataBase") }
                        p {
                            text("Status: ")
                            textln("Connected", "apply-green")
                            text("Collection size: ${entityRepository.count()}")
                        }
                        a("/entity", classes = "form-button") {
                            text("View collections")
                        }
                    }
                }
            }
        }
    }

    override fun BODY.footer() {
        footerElement("insertEntityButtonEvents()")
    }
}
