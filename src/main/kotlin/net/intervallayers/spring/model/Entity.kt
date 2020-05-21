package net.intervallayers.spring.model

import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.module.kotlin.*
import org.bson.types.*
import org.springframework.data.mongodb.core.mapping.*

@Document("entity")
data class Entity(@Field val name: String) {

    @MongoId
    lateinit var id: ObjectId

    override fun toString() = ObjectMapper()
        .registerModule(KotlinModule())
        .writerWithDefaultPrettyPrinter()
        .writeValueAsString(this)!!
        .replace("id", "_id")
}
