# Spring

An apllication on SpringBoot, MongoDB, Kotlin and Heroku

## Build

Requires
  * JDK 11 or higer

For start build use "./gradlew build"

For start application use "./gradlew bootRun"

## Settings MongoDB connection

MongoDB url connection address sends as application argument

## Start Heroku container

Create container and set envirvoment variables
  * MONGODB_CLUSTER
  * MONGODB_DATABASE
  * MONGODB_USER
  * MONGODB_PASSWORD

## Application routing

Pages
  * /error - error handling
  * / - index page
  * /entity - show all entity
  * /insert - insert entity to database

Rest
  * /api/ - API info
  * /api/entity - get all entity