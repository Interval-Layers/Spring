package net.intervallayers.spring.view.page

import kotlinx.html.*
import kotlinx.html.stream.*
import net.intervallayers.extensions.generic.*
import net.intervallayers.extensions.html.*
import net.intervallayers.extensions.string.*
import net.intervallayers.spring.view.element.*

abstract class GenericPage : AbstractPage() {

    /**
     * Automatic title generation.
     * By default Name of class with word "page".
     * @sample "Generic page"
     */
    override val title = this.javaClass
        .simpleName
        .remove("Page")
        .add(" page")

    /**
     * Allow re create document each call of variable.
     */
    final override val document
        get() = render()

    /**
     * Generate HTML document as String with Doctype as HTML 5.
     * @see AbstractPage.head
     * @see AbstractPage.body
     */
    private fun render() = createHTML()
        .htmlWithDoctype {
            head()
            body()
        }

    /**
     * Generic HEAD DOM of HTML document.
     * @see kotlinx.html.HEAD
     */
    override fun HTML.head() = HeadBuilder(consumer)
        .addTitle(this@GenericPage.title)
        .setCharset()
        .addMainStylesheet()
        .addAnotherStylesheet("https://cdnjs.cloudflare.com/ajax/libs/fancybox/3.5.7/jquery.fancybox.min.css")
        .toUnit()

    /**
     * Generic BODY DOM of HTML document.
     * @see kotlinx.html.BODY
     * @see GenericPage.header
     * @see GenericPage.main
     * @see GenericPage.footer
     */
    override fun HTML.body() {
        body {
            header()
            main()
            footer()
        }
    }

    /**
     * Apply element in structure of document.
     * @see net.intervallayers.spring.view.element
     */
    protected open fun BODY.header() = headerElement()
    protected open fun BODY.footer() = footerElement()

    /**
     * General unique element of page.
     * By default this is what the user sees.
     */
    protected abstract fun BODY.main()
}
