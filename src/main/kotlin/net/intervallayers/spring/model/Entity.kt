package net.intervallayers.spring.model

import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.module.kotlin.*
import net.intervallayers.spring.*
import org.springframework.data.mongodb.core.mapping.*

@Document("entity")
data class Entity(@MongoId val id: String, @Field val time: String, @Field val name: String) {

    fun insert(repository: EntityRepository) = also { repository.insert(it) }

    override fun toString() = ObjectMapper()
        .registerModule(KotlinModule())
        .writerWithDefaultPrettyPrinter()
        .writeValueAsString(this)!!
        .replace("id", "_id")
}
