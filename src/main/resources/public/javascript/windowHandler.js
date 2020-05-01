class WindowHandler {

    static object = new WindowHandler()

    constructor() {
        this.currentWindow = "";
        this.blocked = false;

        this.header = document.getElementsByClassName("header-container")[0]
        this.footer = document.getElementsByClassName("footer-container")[0]
        this.windowBackground = document.getElementById("windowBackground")

        this.footer.addEventListener("transitionstart", this.setBlockedOnTransitionStart)
        this.footer.addEventListener("transitionend", this.unsetBlockedOnTransitionStart)
    }

    toggleWindow(HTMLElement) {
        if (!this.blocked)
            switch (this.currentWindow) {
                case "":
                    this.setWindowBackground()
                    this.setWindow(HTMLElement)
                    this.fixedFooter()
                    if (!this.isPageFullyVisible()) {
                        this.enableDimmingElements()
                    }
                    break
                case HTMLElement:
                    this.unsetWindowBackground()
                    this.unsetWindow()
                    this.unfixedFooter()
                    if (!this.isPageFullyVisible()) {
                        this.disableDimmingElements()
                    }
                    break
                default:
                    this.unsetWindow()
                    this.setWindow(HTMLElement)
            }
    }

    setWindowBackground() {
        const style = this.windowBackground.style

        style.visibility = "visible"
        style.opacity = "1"
    }

    unsetWindowBackground() {
        const style = this.windowBackground.style

        style.visibility = "hidden"
        style.opacity = "0"
    }

    setWindow(HTMLElement) {
        const style = HTMLElement.style;
        this.currentWindow = HTMLElement

        style.visibility = "visible"
        style.opacity = "1"
    }

    unsetWindow() {
        const style = this.currentWindow.style
        this.currentWindow = ""

        style.visibility = "hidden"
        style.opacity = "0"
    }

    fixedFooter() {
        const style = this.footer.style

        switch (this.getPositionFooter()) {
            case 2:
                style.position = "fixed"
                break

            case 1:
                style.opacity = "0"

                // this.footer.addEventListener("transitionstart", this.setBlockedOnTransitionStart())

                this.footer.addEventListener("transitionend", function handler() {
                    style.position = "fixed"
                    style.opacity = "1"

                    document
                        .getElementsByClassName("footer-container")[0]
                        .removeEventListener("transitionend", handler, false)
                })
                break
            case 0:
                style.transition = "all 0s ease-out 0s"
                style.opacity = "0"
                style.position = "fixed"

                setTimeout(function () {
                    style.transition = ""
                    style.opacity = "1"
                })
                break
        }
    }

    unfixedFooter() {
        const style = this.footer.style

        switch (this.isBottomOfPage()) {
            case true:
                style.position = "static"
                break
            case false:
                style.opacity = "0"

                this.footer.addEventListener("transitionend", function handler() {
                    style.position = "static"
                    style.opacity = "1"

                    document
                        .getElementsByClassName("footer-container")[0]
                        .removeEventListener("transitionend", handler, false)
                });
                break
        }
    }

    getPositionFooter() {
        const different = Math.max(0, (this.footer.getBoundingClientRect().top - window.innerHeight) * -1);

        // 0 - Footer is not visible
        // 1 - Footer is partially visible
        // 2 - Footer is fully visible
        switch (different) {
            case this.footer.getBoundingClientRect().height:
                return 2
            case 0:
                return 0
            default:
                return 1
        }
    }

    isTopOfPage() {
        return !window.pageYOffset
    }

    isBottomOfPage() {
        return window.innerHeight + window.pageYOffset >= document.body.offsetHeight
    }

    isPageFullyVisible() {
        return this.isTopOfPage() && this.isBottomOfPage()
    }

    enableDimmingElements() {
        this.header.style.background = "#212124"
        this.footer.style.background = "#212124"
        this.windowBackground.style.background = `linear-gradient(
            0deg,
            rgba(33, 33, 36, 1) 1%,
            rgba(44, 44, 46, 0.3) 20%,
            rgba(44, 44, 46, 0.3) 80%,
            rgba(33, 33, 36, 1) 99%
        )`
    }

    disableDimmingElements() {
        this.header.style.background = ""
        this.footer.style.background = ""
        this.windowBackground.style.background = ""
    }

    setBlockedOnTransitionStart() {
        WindowHandler.object.blocked = true
    }

    unsetBlockedOnTransitionStart() {
        WindowHandler.object.blocked = false
    }
}
