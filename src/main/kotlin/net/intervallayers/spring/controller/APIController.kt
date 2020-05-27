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

    /**
     * Provides JSON array of all API
     * @mapping "/api/"
     * @method "GET"
     */
    @GetMapping("/")
    fun getAPI(): ArrayNode {
        return ObjectMapper()
            .createArrayNode()
            .apply {
                addPOJO(API(URI("/"), HttpMethod.GET, "Return array of all API"))
                addPOJO(API(URI("/entity/"), HttpMethod.GET, "Provides all entity"))
                addPOJO(API(URI("/entity/count"), HttpMethod.GET, "Provides entity counter"))
                addPOJO(API(URI("/entity/name/"), HttpMethod.GET, "Find all entity by name"))
                addPOJO(API(URI("/entity/name/"), HttpMethod.PUT, "Create entity by name"))
                addPOJO(API(URI("/entity/id/"), HttpMethod.DELETE, "Delete entity by id"))
            }
    }

    /**
     * Provides JSON array of all Entity documents in database
     * @mapping "/api/entity"
     * @method "GET"
     */
    @GetMapping("/entity")
    fun getEntity(): List<Entity> = entityRepository.findAll()

    /**
     * Provides counter of all Entity documents in database
     * @mapping "/api/entity/count"
     * @method "GET"
     */
    @GetMapping("/entity/count")
    fun getEntityCount() = entityRepository.count()

    /**
     * Find all Entity documents in database by name
     * @mapping "/api/entity/name"
     * @method "GET"
     * @param name: String
     */
    @GetMapping("/entity/name")
    fun getEntityByName(@RequestParam name: String) = entityRepository.findAllByName(name)

    /**
     * Create Entity document in database by name
     * @mapping "/api/entity/name"
     * @method "PUT"
     * @param name: String
     */
    @PutMapping("/entity/name")
    fun putEntity(@RequestParam name: String): ObjectNode {
        val entity = Entity(name)
            .also { entityRepository.insert(it) }

        return ObjectMapper()
            .createObjectNode()
            .put("status", "success")
            .putPOJO("entity", entity)
    }

    /**
     * Delete Entity document in database by id
     * @mapping "/api/entity/id
     * @method "DELETE"
     * @param id: ObjectId
     */
    @DeleteMapping("/entity/id")
    fun deleteEntity(@RequestParam id: ObjectId): ObjectNode {
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
