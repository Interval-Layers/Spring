# Spring

An application on SpringBoot, MongoDB, Kotlin and Heroku

## Build

Requires
  * JDK 11 or higher
  * Git version control

For start build use ```./gradlew build``` or ```<yourGradlePath> build```

For start application use ```./gradlew bootRun``` or ```<yourGradlePath> bootRun``` and visit [http://localhost:8080](http://localhost:8080) in your API platform explorer

## Settings MongoDB connection

MongoDB URL connection address sends as application argument

```--spring.data.mongodb.uri=mongodb+srv://$MONGODB_USER:$MONGODB_PASSWORD@$MONGODB_CLUSTER-gplxw.gcp.mongodb.net/$MONGODB_DATABASE?retryWrites=true&w=majority```

## Start Heroku container

Create a container and set environment variables
  * MONGODB_CLUSTER
  * MONGODB_DATABASE
  * MONGODB_USER
  * MONGODB_PASSWORD

## Application routing

**Warning!** Web frontend for browsers provides in Branch "browser_support" as experimental with Kotlin HTML DSL

Pages:

 Address | Description 
 --- | ---
 / | Index page
 /entity | Show all Entity
 /error | Error controller

Rest API:
 
 Address | Description | Method | Params
 --- | --- | --- | ---
 /api/ | Provides JSON array of all API | GET | None
 /api/entity | Provides JSON array of all Entity documents in database | GET | None
 /api/entity/count | Provides counter of all Entity documents in database | GET | None
 /api/entity/name | Find all Entity documents in database by name | GET | name: String
 /api/entity/name | Create Entity document in database by name | PUT | name: String
 /api/entity/id | Delete Entity document in database by id | DELETE | id: ObjectId

## License

**Spring** application is under the [MIT License](LICENSE)
