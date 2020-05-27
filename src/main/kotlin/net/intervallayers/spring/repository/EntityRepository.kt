package net.intervallayers.spring.repository

import net.intervallayers.spring.model.*
import org.bson.types.*
import org.springframework.data.mongodb.repository.*
import org.springframework.data.repository.*
import org.springframework.stereotype.Repository

/**
 * Interface of MongoRepository for basic interaction with MongoDB
 * @see CrudRepository for basic available methods
 */
@Repository
interface EntityRepository : MongoRepository<Entity, ObjectId> {

    /**
     * Finds all Entity documents in Mongo database by name
     * If nothing is found, returns an empty list
     */
    fun findAllByName(name: String): List<Entity>
}
