package net.intervallayers.spring.controller

import net.intervallayers.spring.*
import org.springframework.beans.factory.annotation.*
import org.springframework.web.bind.annotation.*


@RestController
class APIController {

    @Autowired
    private lateinit var entityRepository: EntityRepository

    @ResponseBody
    @RequestMapping("/api")
    fun getAPI() = ""

    @RequestMapping("/api/entity")
    fun getEntity() = entityRepository.list

    @RequestMapping("/api/entity/{name}", method = [RequestMethod.GET])
    fun getEntityByName(@PathVariable name: String) =
        entityRepository.list.filter { it.name == name }
}
