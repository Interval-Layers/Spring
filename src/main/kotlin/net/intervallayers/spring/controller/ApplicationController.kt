package net.intervallayers.spring.controller

import net.intervallayers.spring.*
import net.intervallayers.spring.model.*
import net.intervallayers.spring.view.page.*
import org.springframework.beans.factory.annotation.*
import org.springframework.http.*
import org.springframework.stereotype.*
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.*
import java.text.*
import java.util.*

@Controller
class ApplicationController {

    @Autowired
    private lateinit var entityRepository: EntityRepository

    @ResponseBody
    @RequestMapping("/")
    fun index(page: IndexPage) = page.setSizeOfEntities(entityRepository.size).document

    @ResponseBody
    @RequestMapping("/insert")
    fun insert(@RequestParam name: String, page: InsertPage): String {
        if (name.isBlank())
            throw ResponseStatusException(HttpStatus.BAD_REQUEST)

        return page.setEntity {
            EntityBuilder()
                .setId(entityRepository.size.toString())
                .setTime(SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(Date()))
                .setName(name)
                .build()
                .insert(entityRepository)
        }.document
    }

    @ResponseBody
    @RequestMapping("/entity")
    fun entity(page: EntityPage) = page.setEntities(entityRepository.list).document
}
