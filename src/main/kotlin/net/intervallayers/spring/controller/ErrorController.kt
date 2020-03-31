package net.intervallayers.spring.controller

import kotlinx.html.*
import kotlinx.html.stream.*
import net.intervallayers.spring.model.html.*
import net.intervallayers.spring.model.html.element.*
import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.stereotype.*
import org.springframework.web.bind.annotation.*
import javax.servlet.http.*

@Controller
class ErrorController : ErrorController {

    override fun getErrorPath() = "/error"

    @ResponseBody
    @RequestMapping("/error")
    fun handleError(request: HttpServletRequest) = createHTML().htmlWithDoctype {
        head {
            title("Error page")
            metaHeadConstructor()
            linkHeadConstructor()
        }
        body {
            headerBodyConstructor()
            div(classes = "body-container") {
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
            footerBodyConstructor()
        }
    }
}
