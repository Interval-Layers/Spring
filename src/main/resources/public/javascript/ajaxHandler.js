class AjaxPostHandler {
    constructor(data, url, f) {
        this.request = new XMLHttpRequest()
        this.request.addEventListener("readystatechange", () => {
            f(this.request)
        })
        this.request.open("POST", url)
        this.request.setRequestHeader("Content-Type", "application/json")
        this.request.responseType = "json"
        this.request.send(data)
    }
}
