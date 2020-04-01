package net.intervallayers.spring.controller

import net.intervallayers.spring.view.page.*
import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.stereotype.*
import org.springframework.web.bind.annotation.*
import javax.servlet.http.*

@Controller
class ErrorController : ErrorController {

    override fun getErrorPath() = "/error"

    @ResponseBody
    @RequestMapping("/error")
    fun handleError(request: HttpServletRequest) = errorPage(request)
}
