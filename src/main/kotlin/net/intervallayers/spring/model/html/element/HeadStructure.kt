package net.intervallayers.spring.model.html.element

import kotlinx.html.*

@HtmlTagMarker
fun HEAD.metaHeadConstructor(charset: String = "UTF-8") {
    consumer.meta(charset)
}

@HtmlTagMarker
fun HEAD.linkHeadConstructor(stylesheet: String = "index.css") {
    consumer.link {
        rel = "stylesheet"
        type = "text/css"
        href = "stylesheet/$stylesheet"
    }
    consumer.link {
        rel = "stylesheet"
        type = "text/css"
        href = "https://cdnjs.cloudflare.com/ajax/libs/fancybox/3.5.7/jquery.fancybox.min.css"
    }
}
