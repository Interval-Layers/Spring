package net.intervallayers.spring.view.page

import kotlinx.html.*
import kotlinx.html.stream.*
import net.intervallayers.spring.model.html.*
import net.intervallayers.spring.model.html.element.*

abstract class AbstractPage : Page {

    override val title = "${this.javaClass.simpleName} page"

    protected open fun HTML.head() {
        head {
            title(this@AbstractPage.title)
            metaHeadConstructor()
            linkHeadConstructor()
        }
    }

    protected open fun HTML.body() {}

    override val document = createHTML()
        .htmlWithDoctype {
            head()
            body()
        }
}
