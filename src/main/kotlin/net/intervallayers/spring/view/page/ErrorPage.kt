package net.intervallayers.spring.view.page

import kotlinx.html.*
import org.springframework.stereotype.*
import javax.servlet.http.*

@Component
class ErrorPage : GenericPage() {

    private lateinit var request: HttpServletRequest

    fun setRequest(request: HttpServletRequest) = also { it.request = request }

    override fun BODY.main() {
        main(classes = "body-container") {
            h1("title") {
                text("An error has occurred")
            }
            h1("title") {
                when (val type = request.getAttribute("javax.servlet.error.status_code") as? Int) {
                    null -> text("Type: Undefined")
                    else -> text("Type: $type")
                }
            }
            h3 {
                text("Method: " + request.method)
            }
            a(href = "/", classes = "button-container") { text("Return to the main page ->>") }
        }
    }
}

