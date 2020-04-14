package net.intervallayers.spring.model.html.element

import kotlinx.html.*
import net.intervallayers.spring.model.html.*
import java.text.*
import java.util.*

@HtmlTagMarker
fun BODY.headerBodyConstructor() {
    header {
        div(classes = "header-container d-flex") {
            a(href = "/") {
                h2 { text("Interval Layers") }
            }
            div(classes = "login") {
                p {
                    a(href = "#") { text("Вход") }
                    text(" | ")
                    a(href = "#") { text("Регистрация") }
                }
            }
        }
    }
}

@HtmlTagMarker
fun BODY.footerBodyConstructor(classes: String? = null, body: (DIV.() -> Unit)? = null) {
    footer {
        div(classes = "footer-container d-flex") {
            p { text("product by: nourepide") }
            p { text(SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(Date())) }
        }

        if (body != null)
            DIV(attributesMapOf("class", classes), consumer).visit(body)

        script(src = "https://code.jquery.com/jquery-3.4.1.min.js")
        script(src = "https://cdnjs.cloudflare.com/ajax/libs/fancybox/3.5.7/jquery.fancybox.min.js")
        script(src = "javascript/main.js")
    }
}
