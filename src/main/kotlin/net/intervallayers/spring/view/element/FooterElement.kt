package net.intervallayers.spring.view.element

import kotlinx.html.*
import net.intervallayers.extensions.html.*
import net.intervallayers.extensions.string.*
import java.text.*
import java.util.*

fun BODY.footerElement(onLoad: String = "", tags: (FOOTER.() -> Unit) = {}) {
    footer {
        section(classes = "footer-container") {
            p { text("product by: nourepide") }
            p { text(SimpleDateFormat("zzz dd/M/yyyy hh:mm:ss:SSS").format(Date())) }
        }

        tags()

        script(src = "/javascript/main.js")
        onLoad.ifNotBlank { script { unsafe { raw("window.onload = $onLoad") } } }
    }
}
