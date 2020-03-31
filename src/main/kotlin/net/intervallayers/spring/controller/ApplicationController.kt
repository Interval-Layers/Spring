package net.intervallayers.spring.controller

import kotlinx.html.*
import kotlinx.html.stream.*
import net.intervallayers.spring.*
import net.intervallayers.spring.model.*
import net.intervallayers.spring.model.html.*
import net.intervallayers.spring.model.html.element.*
import org.springframework.beans.factory.annotation.*
import org.springframework.http.*
import org.springframework.stereotype.*
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.*
import java.text.*
import java.util.*

@Controller
class ApplicationController {

    @Autowired
    private lateinit var entityRepository: EntityRepository

    @ExperimentalStdlibApi
    @ResponseBody
    @RequestMapping("/")
    fun index() = createHTML().htmlWithDoctype {
        head {
            title("Index page")
            metaHeadConstructor()
            linkHeadConstructor()
        }
        body {
            headerBodyConstructor()
            div(classes = "body-container") {
                h1("title") { text(Application::class.java.packageName.toUpperCase()) }
                div(classes = "button-wrap") {
                    a(href = "javascript:;", classes = "button-container") {
                        attributes["data-fancybox"] = ""
                        attributes["data-src"] = "#insertWindow"
                        attributes["data-touch"] = "#false"
                        attributes["data-smallBtn"] = "#false"

                        text("Insert new Entity ->>")
                    }
                    a(href = "/entity", classes = "button-container") { text("View all Entities ->>") }
                }
            }

            footerBodyConstructor("hidden") {
                id = "insertWindow"
                h2 { text("Enter name of Entity") }
                form(action = "insert", method = FormMethod.get, classes = "apply-flex") {
                    input(type = InputType.text, name = "name", classes = "input-form") {
                        autoFocus = true
                        minLength = "3"
                    }
                    button(classes = "button-container input-button") { text("Enter Entity") }
                }
//                button(classes = "btn-cls") {
//                    attributes["data-fancybox-close"] = ""
//                    text("+")
//                }
//                button(classes = "btn") { text("change") }
            }
        }
    }

    @ResponseBody
    @RequestMapping("/insert")
    fun insert(@RequestParam name: String): String {
        if (name.isBlank())
            throw ResponseStatusException(HttpStatus.BAD_REQUEST)

        val entity = Entity(
            id = entityRepository.size.toString(),
            time = SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(Date()),
            name = name
        ).also { entityRepository.insert(it) }

        return createHTML().htmlWithDoctype {
            head {
                title("Insert page")
                metaHeadConstructor()
                linkHeadConstructor()
            }
            body {
                headerBodyConstructor()
                div(classes = "body-container") {
                    h1("title") { text("Inserted \"${Entity::class.java.simpleName}\": ") }
                    h2 { pre { text(entity) } }
                    a(href = "/", classes = "button-container") { text("Return to the main page ->>") }
                }
                footerBodyConstructor()
            }
        }
    }

    @ResponseBody
    @RequestMapping("/entity")
    fun entity() = createHTML().htmlWithDoctype {
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
                    h2 { text("Size of Entity == ${entityRepository.size}") }
                    a(href = "/", classes = "button-container") {  text("Return to the main page ->>") }
                }
                table {
                    with(entityRepository.list) {
                        forEach {
                            tr {
                                td {
                                    text("ID -> ${it.id}")
                                }
                                td {
                                    text("TIME -> ${it.time}")
                                }
                                td {
                                    a(href = "javascript:;", classes = "name_link") {
                                        attributes["data-fancybox"] = ""
                                        attributes["data-src"] = "#trueModal"
                                        attributes["data-modal"] = "#true"
                                        attributes["data-name"] = it.name
                                        text("NAME -> ${it.name.let { if (it == "") "NULL" else it }}")
                                    }
                                }
                            }
                        }
                    }
                }
            }
            footerBodyConstructor() {

            }
        }
    }

    @ResponseBody
    @RequestMapping("/update")
    fun update() = createHTML().htmlWithDoctype {

    }
}
