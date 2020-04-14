package net.intervallayers.spring.view.page

import kotlinx.html.*
import kotlinx.html.stream.*
import net.intervallayers.spring.model.html.*
import net.intervallayers.spring.model.html.element.*

abstract class AbstractPage : Page {

    override val title = this.javaClass
        .simpleName
        .replace("Page", "")
        .plus(" page")

    protected open fun HTML.head() {
        head {
            title(this@AbstractPage.title)
            metaHeadConstructor()
            linkHeadConstructor()
        }
    }

    protected open fun HTML.body() {}

    override val document
        get() = render()

    private fun render() = createHTML()
        .htmlWithDoctype {
            head()
            body()
        }
}
