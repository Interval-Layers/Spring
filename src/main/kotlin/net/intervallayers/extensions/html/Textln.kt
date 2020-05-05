package net.intervallayers.extensions.html

import kotlinx.html.*

@HtmlTagMarker
fun FlowOrPhrasingContent.textln(s: Any?) {
    text(s)
    br()
}

@HtmlTagMarker
fun FlowOrPhrasingContent.textln(s: Any?, classes: String = "") {
    span(classes) { (this as Tag).text(s) }
    br()
}

@HtmlTagMarker
fun FlowOrPhrasingContent.textln(s: Any?, classes: String = "", id: String = "") {
    span(classes) {
        this.id = id
        (this as Tag).text(s)
    }
    br()
}
