package net.intervallayers.spring

import net.intervallayers.spring.model.*
import org.springframework.beans.factory.annotation.*
import org.springframework.data.mongodb.core.*
import org.springframework.stereotype.*

@Repository
class EntityRepository {

    @Autowired
    private lateinit var mongoTemplate: MongoTemplate

    val size: Int
        get() = mongoTemplate.findAll(Entity::class.java).size

    val list: List<Entity>
        get() = mongoTemplate.findAll(Entity::class.java).toList()

    fun insert(entity: Entity) {
        mongoTemplate.insert(entity)
    }
}
