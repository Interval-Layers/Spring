package net.intervallayers.spring.model

import org.bson.types.*
import org.springframework.data.mongodb.core.mapping.*

@Document("entity")
data class Entity(@Field val name: String) {

    @MongoId
    lateinit var id: ObjectId
}
