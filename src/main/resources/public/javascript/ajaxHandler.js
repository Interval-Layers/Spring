class AjaxJsonHandler {
    constructor(data, method, url, f) {
        this.request = new XMLHttpRequest()
        this.request.addEventListener("readystatechange", () => {
            f(this.request)
        })
        this.request.open(method, url)
        this.request.setRequestHeader("Content-Type", "application/json")
        this.request.responseType = "json"
        this.request.send(data)
    }
}
