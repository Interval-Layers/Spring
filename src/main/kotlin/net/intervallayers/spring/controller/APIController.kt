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
    fun getAPI(): ObjectNode {
        return ObjectMapper()
            .createObjectNode()
            .apply {
                putArray("api")
                    .add("/api")
                    .add("/api/entity")
                    .add("/api/entity/{name}")
                    .add("/api/insert/entity")
                    .add("/api/delete/entity")
            }
    }

    @RequestMapping("/api/entity")
    fun getEntity(): List<Entity> = entityRepository.findAll()

    @RequestMapping("/api/entity/{name}", method = [RequestMethod.GET])
    fun getEntityByName(@PathVariable name: String) = entityRepository.findAllByName(name)

    @PostMapping("/api/insert/entity")
    fun insertEntity(@RequestBody entityName: String): ObjectNode {
        val entity = EntityBuilder()
            .setId(entityRepository.count().toString())
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

    @PostMapping("/api/delete/entity")
    fun deleteEntity(@RequestBody entityId: String): ObjectNode {
        return when (entityRepository.findById(entityId).isPresent) {
            true -> ObjectMapper()
                .createObjectNode()
                .put("status", "success")
                .also { entityRepository.deleteById(entityId) }
            false -> ObjectMapper()
                .createObjectNode()
                .put("status", "error")
                .put("description", "id not found")
        }
    }
}
