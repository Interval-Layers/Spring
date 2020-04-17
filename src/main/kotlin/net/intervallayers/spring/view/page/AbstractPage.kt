package net.intervallayers.spring.view.page

import kotlinx.html.*

/**
 * Structure of HTML document
 */
abstract class AbstractPage : Page {
    protected abstract fun HTML.head()
    protected abstract fun HTML.body()
}
