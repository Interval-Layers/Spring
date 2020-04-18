package net.intervallayers.spring.view.element

import kotlinx.html.*
import net.intervallayers.extensions.html.*
import java.text.*
import java.util.*

fun BODY.footerElement(tags: (FOOTER.() -> Unit) = {}) {
    footer {
        section(classes = "footer-container") {
            p { text("product by: nourepide") }
            p { text(SimpleDateFormat("zzz dd/M/yyyy hh:mm:ss:SSS").format(Date())) }
        }

        tags()

        script(src = "https://code.jquery.com/jquery-3.4.1.min.js")
        script(src = "https://cdnjs.cloudflare.com/ajax/libs/fancybox/3.5.7/jquery.fancybox.min.js")
        script(src = "/javascript/main.js")
    }
}
