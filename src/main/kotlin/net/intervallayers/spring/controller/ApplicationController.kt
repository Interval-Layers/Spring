package net.intervallayers.spring.controller

import net.intervallayers.spring.view.page.*
import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import org.springframework.web.bind.annotation.*

@Controller
class ApplicationController {

    @Autowired
    private lateinit var indexPage: IndexPage

    @Autowired
    private lateinit var entityPage: EntityPage

    @ResponseBody
    @RequestMapping("/")
    fun index() = indexPage.document

    @ResponseBody
    @RequestMapping("/entity")
    fun entity() = entityPage.document

}
