package net.intervallayers.spring.view.page

import kotlinx.html.*
import net.intervallayers.extensions.html.*
import org.springframework.beans.factory.annotation.*
import org.springframework.http.*
import org.springframework.stereotype.*
import javax.servlet.http.*

@Component
class ErrorPage : GenericPage() {

    @Autowired
    private lateinit var request: HttpServletRequest

    private val status by lazy {
        HttpStatus
            .valueOf(request.getAttribute("javax.servlet.error.status_code") as? Int ?: 400)
    }

    override fun BODY.main() {
        main {
            section(classes = "main-container") {
                when (status.isError) {
                    true -> h1 { text("An error has occurred") }
                    false -> h1 { text("Something happened") }
                }

                article("card") {
                    h3 { text("Information") }
                    p {
                        textln("Code: " + status.value())
                        textln("Message: " + status.reasonPhrase)
                        text("Status: ")
                        when (status.isError) {
                            true -> textln("Error", "apply-red")
                            false -> textln("Success", "apply-green")
                        }
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
