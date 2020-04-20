const borderRadius = getComputedStyle(document.documentElement).getPropertyValue("--border-radius");
const cardFormInput = document.getElementById("cardFormInput");
const cardFormButton = document.getElementById("cardFormButton");
const cardForm = document.getElementById("cardForm");

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
    cardForm.style.maxWidth = cardForm.getBoundingClientRect().width + "px"
    cardFormInput.style.borderTopRightRadius = "0"
    cardFormInput.style.borderBottomRightRadius = "0"
}

function cardFormButtonHoverEnd() {
    cardFormInput.style.borderTopRightRadius = borderRadius
    cardFormInput.style.borderBottomRightRadius = borderRadius
}

// noinspection JSUnusedGlobalSymbols
function cardFormInputChange() {
    let length = cardFormInput.value.length;

    if (length === 0 || length >= 12) {
        cardFormButton.disabled = true
        cardFormButtonHoverEnd()
    } else {
        cardFormButton.disabled = false
        if (cardFormButton.dataset.onmouse === "true") cardFormButtonHoverStart()
    }
}
