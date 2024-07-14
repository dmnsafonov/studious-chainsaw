package net.domisafonov.compasstestproject.domain.usecase

/**
 * Count words and output a string with a count for each unique word.
 *
 * "a hamster is a squirrel" would get
 * ```
 * "a": 2
 * "hamster": 1
 * "is": 1
 * "squirrel": 1
 * ```
 */
fun interface MakeWordCountTextUc {

    suspend fun execute(src: String): String
}

class MakeWordCountTextUcImpl : MakeWordCountTextUc {

    override suspend fun execute(src: String): String {
        val words = mutableMapOf<String, Int>()
        src.split("\\s++".toPattern()).forEach { words[it] = (words[it] ?: 0) + 1 }
        return words.toSortedMap().entries.joinToString(separator = "\n") { (word, count) ->
            "\"$word\": $count"
        }
    }
}
