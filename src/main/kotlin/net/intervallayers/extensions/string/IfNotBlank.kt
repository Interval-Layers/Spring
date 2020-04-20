package net.intervallayers.extensions.string

inline fun <C: CharSequence> C.ifNotBlank(defaultValue: () -> Unit) = also {
    if (isNotBlank()) defaultValue()
}
