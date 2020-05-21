const insertEntityInput = document.getElementById("insertEntityInput")
const insertEntityButton = document.getElementById("insertEntityButton")
const insertEntity = document.getElementById("insertEntity")

// noinspection JSUnusedGlobalSymbols
function insertEntitySubmitEvent() {
    function insertEntityHandler(request) {
        function setValue(id, value, CSSClass, withoutQuotes) {
            const element = document.getElementById(id)

            if (withoutQuotes === true)
                element.innerText = value
            else
                element.innerText = "\"" + value + "\""
            element.className = CSSClass
        }

        if (request.readyState === 4 && request.status === 200) {
            const status = request.response.status.capitalize()
            const entity = request.response.entity
            WindowHandler.object.toggleWindow(document.getElementById("windowInsertEntity"))

            setValue("windowInsertEntityStatus", status, "apply-green", true)
            setValue("windowInsertEntityId", entity.id, "apply-orange")
            setValue("windowInsertEntityDate", entity.id.date, "apply-orange")
            setValue("windowInsertEntityName", entity.name, "apply-orange")
        }
    }

    new AjaxJsonHandler(insertEntityInput.value, "PUT","/api/entity/name", insertEntityHandler)
    return false
}

// noinspection JSUnusedGlobalSymbols
function insertEntityButtonEvents() {
    let onMouse = false

    insertEntityButton.addEventListener("mouseenter", function () {
        insertEntity.style.width = insertEntity.getBoundingClientRect().width.toPX()
        onMouse = true
    })

    insertEntityButton.addEventListener("mouseleave", function () {
        onMouse = false
    })

    insertEntityButton.addEventListener("transitionend", function () {
        if (onMouse === false) insertEntity.style.width = ""
    })
}

// noinspection JSUnusedGlobalSymbols
function insertEntityInputChange() {
    let length = insertEntityInput.value.length

    insertEntityButton.disabled = length === 0 || length > insertEntityInput.maxLength
}

// noinspection JSUnusedGlobalSymbols
function toggleWindowLogin() {
    WindowHandler.object.toggleWindow(document.getElementById("windowLogin"))
}

// noinspection JSUnusedGlobalSymbols
function toggleWindowRegistration() {
    WindowHandler.object.toggleWindow(document.getElementById("windowRegistration"))
}

String.prototype.capitalize = function () {
    return this.charAt(0).toUpperCase() + this.slice(1)
}

Number.prototype.toPX = function () {
    return this + "px"
}
