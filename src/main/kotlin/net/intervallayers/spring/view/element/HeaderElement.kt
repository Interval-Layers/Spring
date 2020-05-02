package net.intervallayers.spring.view.element

import kotlinx.html.*

fun BODY.headerElement() {
    header {
        section(classes = "header-container") {
            a(href = "/") {
                h2 { text("Interval Layers") }
            }
            div(classes = "login") {
                p {
                    button(classes = "apply-underline") {
                        onClick = "toggleWindowLogin()"
                        text("Login")
                    }
                    text(" | ")
                    button(classes = "apply-underline") {
                        onClick = "toggleWindowRegistration()"
                        text("Registration")
                    }
                }
            }
        }

        section("window-background") {
            id = "windowBackground"
            onClick = "WindowHandler.object.toggleWindow(WindowHandler.object.currentWindow)"
        }

        article("window-card") {
            id = "windowLogin"
            h3 { text("Login") }
            form(classes = "window-form") {
                input(classes = "form-input apply-margin-bottom-8px") {
                    placeholder = "Enter login"
                }
                input(classes = "form-input apply-margin-bottom-8px", type = InputType.password) {
                    placeholder = "Enter password"
                }
                button(classes = "form-button apply-margin-bottom-8px") { text("Sign-in") }
                button(classes = "form-button") { text("Sign-in as Guest") }
            }
        }

        article("window-card") {
            id = "windowRegistration"
            h3 { text("Registration") }
            form(classes = "window-form") {
                input(classes = "form-input apply-margin-bottom-8px") {
                    placeholder = "Enter login"
                }
                input(classes = "form-input apply-margin-bottom-8px") {
                    placeholder = "Enter email"
                }
                input(classes = "form-input apply-margin-bottom-8px", type = InputType.password) {
                    placeholder = "Enter password"
                }
                input(classes = "form-input apply-margin-bottom-8px", type = InputType.password) {
                    placeholder = "Retype password"
                }
                button(classes = "form-button") { text("Sign-up") }
            }
        }
    }
}
