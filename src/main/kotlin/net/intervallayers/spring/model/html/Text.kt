package net.intervallayers.spring.model.html

import kotlinx.html.*

@HtmlTagMarker
fun Tag.text(s: Any) {
    consumer.onTagContent(s.toString())
}
