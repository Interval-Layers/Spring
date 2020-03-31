package net.intervallayers.spring.model.html

import kotlinx.html.*

/**
 * Overloaded function @see kotlinx.html.FlowOrPhrasingOrMetaDataContent.script
 *
 * Add support for @param src in constructor
 * Convert in <pre>"<script src=""></script>>"</pre>
 */

@HtmlTagMarker
fun FlowOrPhrasingOrMetaDataContent.script(src: String, integrity: String = "") {
    script {
        this.src = src
        if (integrity.isNotBlank())
            this.integrity = integrity
    }
}
