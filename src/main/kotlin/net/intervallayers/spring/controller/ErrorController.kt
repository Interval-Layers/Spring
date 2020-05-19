package net.intervallayers.spring.controller

import net.intervallayers.spring.view.page.*
import org.springframework.beans.factory.annotation.*
import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.stereotype.*
import org.springframework.web.bind.annotation.*

@Controller
class ErrorController : ErrorController {

    override fun getErrorPath() = "/error"

    @Autowired
    private lateinit var errorPage: ErrorPage

    @ResponseBody
    @RequestMapping("/error")
    fun handleError() = errorPage.document

}
