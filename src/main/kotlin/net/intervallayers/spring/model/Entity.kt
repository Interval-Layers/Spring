package net.intervallayers.spring.model

import org.bson.types.*
import org.springframework.data.mongodb.core.mapping.*

/**
 * Presentation layer document for MongoDB
 * @param id: ObjectId by default generates new ObjectId
 */
@Document("entity")
data class Entity(@Field val name: String, @MongoId val id: ObjectId = ObjectId())
