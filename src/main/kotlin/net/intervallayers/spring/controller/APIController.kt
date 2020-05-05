package net.intervallayers.spring.controller

import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.databind.node.*
import net.intervallayers.spring.*
import net.intervallayers.spring.model.*
import org.springframework.beans.factory.annotation.*
import org.springframework.web.bind.annotation.*
import java.text.*
import java.util.*

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

    @PostMapping("/api/insert/entity")
    fun insertEntity(@RequestBody entityName: String): ObjectNode {
        val entity = EntityBuilder()
            .setId(entityRepository.size.toString())
            .setTime(SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(Date()))
            .setName(entityName)
            .build()
            // Temporally disabled
            //.insert(entityRepository)

        return ObjectMapper()
            .createObjectNode()
            .put("status", "success")
            .putPOJO("entity", entity)
    }
}
