package net.intervallayers.spring.view.element

import kotlinx.html.*

class HeadBuilder(consumer: TagConsumer<*>) : HEAD(emptyMap, consumer) {

    fun addTitle(content: String) = also {
        title(content)
    }

    fun setCharset(charset: String = "utf-8") = also {
        meta(charset = charset)
    }

    fun addStylesheet(href: String) = also {
        link {
            rel = "stylesheet"
            type = "text/css"
            this.href = "/stylesheet/$href"
        }
    }

}
