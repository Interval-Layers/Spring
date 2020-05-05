package net.intervallayers.extensions.html

import kotlinx.html.*

@HtmlTagMarker
fun Tag.text(s: Any?) {
    consumer.onTagContent(s.toString())
}

@HtmlTagMarker
fun FlowOrPhrasingContent.text(s: Any?, classes: String = "") {
    span(classes) { (this as Tag).text(s) }
}

@HtmlTagMarker
fun FlowOrPhrasingContent.text(s: Any?, classes: String = "", id: String = "") {
    span(classes) {
        this.id = id
        (this as Tag).text(s)
    }
}
