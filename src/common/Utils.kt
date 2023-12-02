package common

import java.math.BigInteger
import java.security.MessageDigest
import kotlin.io.path.Path
import kotlin.io.path.exists
import kotlin.io.path.readLines
import kotlin.system.exitProcess

fun getPath(name: String) = Path("src/inputs/$name.txt")

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String): List<String> {
    val path = getPath(name)
    if (!path.exists()) {
        println {"Input file not found".bold.red}
        exitProcess(1)
    }
    return path.readLines()
}

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println() = println(this)
