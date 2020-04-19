package net.intervallayers.spring.view.page

import kotlinx.html.*
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
                h1("title") { text(Application::class.java.packageName.toUpperCase()) }

                div("card-container") {
                    article(classes = "card") {
                        h3 { text("Add new Entity") }
                        form("/insert", classes = "apply-flex") {
                            id = "cardForm"
                            input(classes = "form-input", name = "name") {
                                id = "cardFormInput"
                                placeholder = "Enter name"
                            }
                            button(classes = "form-button") {
                                onTouchMove = "cardFormButtonHoverStart()"
                                onTouchCancel = "cardFormButtonHoverEnd()"
                                onMouseMove = "cardFormButtonHoverStart()"
                                onMouseOut = "cardFormButtonHoverEnd()"
                                text("Add Entity")
                            }
                        }
                    }

                    article(classes = "card") {
                        h3 { text("Status of DataBase") }
                        p("apply-green") { text("Status: Connected") }
                        p { text("Collection size: $sizeOfEntities") }
                        br("apply-margin-8px")
                        a("/entity", classes = "form-button") { text("View collections") }
                    }
                }
            }
        }
    }

    override fun BODY.footer() {
        footerElement()
    }
}
