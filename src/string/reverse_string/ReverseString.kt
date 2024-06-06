package string.reverse_string

import java.util.*

fun reverseString(s: CharArray): Unit {
    var start = 0;
    var end = s.size - 1;

    while (start < end) {
        s[start] = s[end].also { s[end] = s[start] }

        start++
        end--
    }
}

fun main() {
    val arr = charArrayOf('a', 'b', 'c')
    println("origin = ${arr.contentToString()}")
    reverseString(arr)
    println("reversed = ${arr.contentToString()}")
}