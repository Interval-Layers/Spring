package net.intervallayers.spring.view.page

import kotlinx.html.*
import kotlinx.html.stream.*
import net.intervallayers.spring.model.*
import net.intervallayers.spring.model.html.*
import net.intervallayers.spring.model.html.element.*

fun entityPage(entities: List<Entity>) = createHTML().htmlWithDoctype {
    head {
        title("Entity page")
        metaHeadConstructor()
        linkHeadConstructor()
    }
    body {
        headerBodyConstructor()
        div(classes = "body-container") {
            h1(classes = "title") { text("Viewer of entities") }
            div(classes = "d-flex") {
                h2 { text("Size of Entity == ${entities.size}") }
                a(href = "/", classes = "button-container") { text("Return to the main page ->>") }
            }
            table {
                entities.forEach {
                    tr {
                        td { text("ID -> ${it.id}") }
                        td { text("TIME -> ${it.time}") }
                        td {
                            a(href = "javascript:;", classes = "name_link") {
                                attributes["data-fancybox"] = ""
                                attributes["data-src"] = "#trueModal"
                                attributes["data-name"] = it.name
                                text("NAME -> ${it.name.let { if (it == "") "NULL" else it }}")
                            }
                        }
                    }
                }
            }
        }
        footerBodyConstructor()
    }
}
