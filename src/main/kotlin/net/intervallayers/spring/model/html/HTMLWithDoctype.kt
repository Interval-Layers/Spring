package net.intervallayers.spring.model.html

import kotlinx.html.*
import kotlinx.html.TagConsumer as createHTML

fun createHTML<*>.htmlWithDoctype(namespace: String? = null, block: HTML.() -> Unit = {}): String {
    val doctype = "<!DOCTYPE HTML>\n"
    val body = HTML(emptyMap, this, namespace).visitAndFinalize(this, block)
    return doctype + body
}
