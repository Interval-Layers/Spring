let borderRadius = getComputedStyle(document.documentElement).getPropertyValue("--border-radius");

// noinspection JSUnusedGlobalSymbols
function cardFormButtonHoverStart() {
    let cardFormInput = document.getElementById("cardFormInput")

    cardFormInput.style.borderTopRightRadius = "0"
    cardFormInput.style.borderBottomRightRadius = "0"

    let cardForm = document.getElementById("cardForm")
    cardForm.style.maxWidth = cardForm.getBoundingClientRect().width + "px"
}

// noinspection JSUnusedGlobalSymbols
function cardFormButtonHoverEnd() {
    let cardFormInput = document.getElementById("cardFormInput")

    cardFormInput.style.borderTopRightRadius = borderRadius
    cardFormInput.style.borderBottomRightRadius = borderRadius
}
