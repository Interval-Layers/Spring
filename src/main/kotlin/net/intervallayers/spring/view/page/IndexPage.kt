package net.intervallayers.spring.view.page

import kotlinx.html.*
import net.intervallayers.extensions.html.*
import net.intervallayers.spring.*
import net.intervallayers.spring.view.element.*
import org.springframework.stereotype.*
import kotlin.properties.*

@Component
class IndexPage : GenericPage() {

    private var sizeOfEntities by Delegates.notNull<Int>()

    fun setSizeOfEntities(size: Int) = also { sizeOfEntities = size }

    override fun BODY.main() {
        main {
            section(classes = "main-container") {
                h1 { text(Application::class.java.packageName.toUpperCase()) }

                div("card-container") {
                    article(classes = "card") {
                        h3 { text("Add new Entity") }
                        form("/insert", classes = "apply-flex") {
                            id = "cardForm"
                            input(classes = "apply-width-100", name = "name") {
                                id = "cardFormInput"
                                maxLength = "12"
                                onInput = "cardFormInputChange()"
                                placeholder = "Enter name"
                            }
                            div {
                                button(classes = "form-button") {
                                    id = "cardFormButton"
                                    disabled = true
                                    attributes["data-onmouse"] = "false"
                                    text("Add Entity")
                                }
                            }
                        }
                    }

                    article(classes = "card") {
                        h3 { text("Status of DataBase") }
                        p {
                            text("Status: ")
                            textln("Connected", "apply-green")
                            text("Collection size: $sizeOfEntities")
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
        footerElement("initFormButtonEvents()")
    }
}
