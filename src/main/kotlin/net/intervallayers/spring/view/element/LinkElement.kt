package net.intervallayers.spring.view.element

import kotlinx.html.*

fun HEAD.linkElement(stylesheet: String = "main.css") {
    consumer.link {
        rel = "stylesheet"
        type = "text/css"
        href = "/stylesheet/$stylesheet"
    }
    consumer.link {
        rel = "stylesheet"
        type = "text/css"
        href = "https://cdnjs.cloudflare.com/ajax/libs/fancybox/3.5.7/jquery.fancybox.min.css"
    }
}
