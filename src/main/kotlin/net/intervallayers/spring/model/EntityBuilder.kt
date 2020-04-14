package net.intervallayers.spring.model

class EntityBuilder {
    private var id: String = ""
    private var time: String = ""
    private var name: String = ""

    fun setId(id: String) = also { it.id = id }
    fun setTime(time: String) = also { it.time = time }
    fun setName(name: String) = also { it.name = name }

    fun build() = Entity(id, time, name)
}
