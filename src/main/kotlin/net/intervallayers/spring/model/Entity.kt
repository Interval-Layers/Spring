package net.intervallayers.spring.model

import org.springframework.data.mongodb.core.mapping.*

@Document("entity")
data class Entity(
    @MongoId var id: String,
    @Field("_time") var time: String,
    @Field("_name") var name: String
) {
    override fun toString() =
        """
            {
                "_id":"$id",
                "_time":"$time",
                "_name":"$name",
                "_class":"${Entity::class.java.name}"
            }
        """.trimIndent()
}
