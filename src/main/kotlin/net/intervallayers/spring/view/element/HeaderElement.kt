package net.intervallayers.spring.view.element

import kotlinx.html.*

fun BODY.headerElement() {
    header {
        div(classes = "header-container d-flex") {
            a(href = "/") {
                h2 { text("Interval Layers") }
            }
            div(classes = "login") {
                p {
                    a(href = "#") { text("Вход") }
                    text(" | ")
                    a(href = "#") { text("Регистрация") }
                }
            }
        }
    }
}
