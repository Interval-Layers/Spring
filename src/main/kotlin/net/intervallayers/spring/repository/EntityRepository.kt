package net.intervallayers.spring.repository

import net.intervallayers.spring.model.*
import org.springframework.data.mongodb.repository.*
import org.springframework.stereotype.*

@Repository
interface EntityRepository : MongoRepository<Entity, String> {
    fun findAllByName(name: String): List<Entity>
}
