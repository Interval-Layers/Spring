const borderRadius = getComputedStyle(document.documentElement).getPropertyValue("--border-radius");
const cardFormInput = document.getElementById("insertEntityInput");
const cardFormButton = document.getElementById("insertEntityButton");
const cardForm = document.getElementById("insertEntity");

// noinspection JSUnusedGlobalSymbols
function insertEntitySubmitEvent() {
    function insertEntityHandler(request) {
        function setValue(id, value, CSSClass, withoutQuotes) {
            const element = document.getElementById(id);

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
            setValue("windowInsertEntityTime", entity.time, "apply-orange")
            setValue("windowInsertEntityName", entity.name, "apply-orange")
        }
    }

    new AjaxPostHandler(cardFormInput.value, "/api/insert/entity", insertEntityHandler)
    return false;
}

// noinspection JSUnusedGlobalSymbols
function initFormButtonEvents() {
    cardFormButton.parentNode.addEventListener("mouseenter", function () {
        cardFormButton.dataset.onmouse = "true"
        if (!cardFormButton.disabled) cardFormButtonHoverStart()
    })

    cardFormButton.parentNode.addEventListener("mouseleave", function () {
        cardFormButton.dataset.onmouse = "false"
        cardFormButtonHoverEnd()
    })
}

function cardFormButtonHoverStart() {
    cardForm.style.width = cardForm.getBoundingClientRect().width + "px"
    cardFormInput.style.borderTopRightRadius = "0"
    cardFormInput.style.borderBottomRightRadius = "0"
}

function cardFormButtonHoverEnd() {
    cardFormInput.style.borderTopRightRadius = borderRadius
    cardFormInput.style.borderBottomRightRadius = borderRadius
}

// noinspection JSUnusedGlobalSymbols
function insertEntityInputChange() {
    let length = cardFormInput.value.length;

    if (length === 0 || length >= 12) {
        cardFormButton.disabled = true
        cardFormButtonHoverEnd()
    } else {
        cardFormButton.disabled = false
        if (cardFormButton.dataset.onmouse === "true") cardFormButtonHoverStart()
    }
}

// noinspection JSUnusedGlobalSymbols
function toggleWindowLogin() {
    WindowHandler.object.toggleWindow(document.getElementById("windowLogin"))
}

// noinspection JSUnusedGlobalSymbols
function toggleWindowRegistration() {
    WindowHandler.object.toggleWindow(document.getElementById("windowRegistration"))
}

String.prototype.capitalize = function() {
    return this.charAt(0).toUpperCase() + this.slice(1);
}

Number.prototype.toPX = function () {
    return this + "px"
}
