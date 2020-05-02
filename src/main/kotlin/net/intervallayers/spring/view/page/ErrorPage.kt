package net.intervallayers.spring.view.page

import kotlinx.html.*
import net.intervallayers.extensions.html.*
import org.springframework.http.*
import org.springframework.stereotype.*
import javax.servlet.http.*

@Component
class ErrorPage : GenericPage() {

    private lateinit var request: HttpServletRequest
    private val status by lazy {
        HttpStatus
            .valueOf(request.getAttribute("javax.servlet.error.status_code") as? Int ?: 400)
    }

    fun setRequest(request: HttpServletRequest) = also { it.request = request }

    override fun BODY.main() {
        main {
            section(classes = "main-container") {
                h1 { text("An error has occurred") }

                article("card") {
                    h3 { text("Information") }
                    p {
                        textln("Code: " + status.value())
                        textln("Message: " + status.reasonPhrase)
                        text("Status: ")
                        textln("Error", "apply-red")
                        text("Method: " + request.method)
                    }
                    a(href = "/", classes = "form-button") {
                        text("Return to the main page")
                    }
                }
            }
        }
    }
}
