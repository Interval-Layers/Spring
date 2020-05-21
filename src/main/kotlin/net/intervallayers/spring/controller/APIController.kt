package net.intervallayers.spring.controller

import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.databind.node.*
import net.intervallayers.spring.model.*
import net.intervallayers.spring.repository.*
import org.bson.types.*
import org.springframework.beans.factory.annotation.*
import org.springframework.http.*
import org.springframework.web.bind.annotation.*
import java.net.*

@RestController
@RequestMapping("/api")
class APIController {

    @Autowired
    private lateinit var entityRepository: EntityRepository

    @GetMapping("/")
    fun getAPI(): ArrayNode {
        return ObjectMapper()
            .createArrayNode()
            .apply {
                addPOJO(API(URI("/"), HttpMethod.GET, "Return array of all API"))
                addPOJO(API(URI("/entity/"), HttpMethod.GET, "Provides all entity"))
                addPOJO(API(URI("/entity/size"), HttpMethod.GET, "Provides entity size"))
                addPOJO(API(URI("/entity/name/"), HttpMethod.GET, "Find all entity by name"))
                addPOJO(API(URI("/entity/name/"), HttpMethod.PUT, "Create entity by name"))
                addPOJO(API(URI("/entity/id/"), HttpMethod.DELETE, "Delete entity by id"))
            }
    }

    @GetMapping("/entity")
    fun getEntity(): List<Entity> = entityRepository.findAll()

    @GetMapping("/entity/size")
    fun getEntitySize() = entityRepository.count()

    @GetMapping("/entity/name")
    fun getEntityByName(@RequestBody name: String) = entityRepository.findAllByName(name)

    @PutMapping("/entity/name")
    fun putEntity(@RequestBody name: String): ObjectNode {
        val entity = Entity(name)
            .also { entityRepository.insert(it) }

        return ObjectMapper()
            .createObjectNode()
            .put("status", "success")
            .putPOJO("entity", entity)
    }

    @DeleteMapping("/entity/id")
    fun deleteEntity(@RequestBody id: ObjectId): ObjectNode {
        return when (entityRepository.findById(id).isPresent) {
            true -> ObjectMapper()
                .createObjectNode()
                .put("status", "success")
                .also { entityRepository.deleteById(id) }
            false -> ObjectMapper()
                .createObjectNode()
                .put("status", "error")
                .put("description", "id not found")
        }
    }

}
