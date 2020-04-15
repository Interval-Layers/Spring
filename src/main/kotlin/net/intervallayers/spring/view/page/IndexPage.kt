package net.intervallayers.spring.view.page

import kotlinx.html.*
import net.intervallayers.spring.*
import net.intervallayers.spring.model.html.element.*
import org.springframework.stereotype.*

@Component
class IndexPage : AbstractPage() {
    override fun BODY.main() {
        main(classes = "body-container") {
            h1("title") { text(Application::class.java.packageName.toUpperCase()) }
            div(classes = "button-wrap") {
                a(href = "javascript:;", classes = "button-container") {
                    attributes["data-fancybox"] = ""
                    attributes["data-src"] = "#insertWindow"
                    attributes["data-touch"] = "#false"
                    attributes["data-smallBtn"] = "#false"

                    text("Insert new Entity ->>")
                }
            }
            a(href = "/entity", classes = "button-container") { text("View all Entities ->>") }
        }
    }

    override fun BODY.footer() {
        footerElement("hidden") {
            id = "insertWindow"
            h2 { text("Enter name of Entity") }
            form(action = "insert", method = FormMethod.get, classes = "apply-flex") {
                input(type = InputType.text, name = "name", classes = "input-form") {
                    autoFocus = true
                    minLength = "3"
                }
                button(classes = "button-container input-button") { text("Enter Entity") }
            }
        }
    }
}
