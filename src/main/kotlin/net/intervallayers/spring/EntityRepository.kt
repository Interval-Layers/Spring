package net.intervallayers.spring

import net.intervallayers.spring.model.*
import org.springframework.data.mongodb.repository.*
import org.springframework.stereotype.*

@Repository
interface EntityRepository : MongoRepository<Entity, String>
