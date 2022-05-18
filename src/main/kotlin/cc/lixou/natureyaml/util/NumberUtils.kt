package cc.lixou.natureyaml.util

fun String.toNumberOrNull(): Number? {
    if(toByteOrNull() != null) return toByte()
    if(toShortOrNull() != null) return toShort()
    if(toIntOrNull() != null) return toInt()
    if(toLongOrNull() != null) return toLong()
    if(toFloatOrNull() != null) return toFloat()
    if(toDoubleOrNull() != null) return toDouble()
    return null
}