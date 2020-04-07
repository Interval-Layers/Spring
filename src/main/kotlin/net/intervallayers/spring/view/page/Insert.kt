package net.intervallayers.spring.view.page

import kotlinx.html.*
import kotlinx.html.stream.*
import net.intervallayers.spring.model.*
import net.intervallayers.spring.model.html.*
import net.intervallayers.spring.model.html.element.*

fun insertPage(entity: Entity) = createHTML().htmlWithDoctype {
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