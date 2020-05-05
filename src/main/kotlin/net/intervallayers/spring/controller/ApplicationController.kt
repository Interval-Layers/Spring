package net.intervallayers.spring.controller

import net.intervallayers.spring.*
import net.intervallayers.spring.view.page.*
import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import org.springframework.web.bind.annotation.*

@Controller
class ApplicationController {

    @Autowired
    private lateinit var entityRepository: EntityRepository

    @ResponseBody
    @RequestMapping("/")
    fun index(page: IndexPage) = page.setSizeOfEntities(entityRepository.size).document

    @ResponseBody
    @RequestMapping("/entity")
    fun entity(page: EntityPage) = page.setEntities(entityRepository.list).document
}
