package net.intervallayers.spring.view.element

import kotlinx.html.*

fun HEAD.metaElement(charset: String = "UTF-8") {
    consumer.meta(charset)
}
