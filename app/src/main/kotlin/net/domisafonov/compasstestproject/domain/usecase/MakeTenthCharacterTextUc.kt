package net.domisafonov.compasstestproject.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

fun interface MakeTenthCharacterTextUc {
    suspend fun execute(src: String): String
}

class MakeTenthCharacterTextUcImpl(
    private val ioDispatcher: CoroutineDispatcher,
) : MakeTenthCharacterTextUc {

    override suspend fun execute(src: String): String = withContext(ioDispatcher) {
        val codePointList = ArrayList<Int>(src.length)
        var n = 1
        src.codePoints().forEach { cp ->
            if (n % 10 == 0) codePointList += cp
            ++n
        }
        codePointList.joinToString(separator = "") { String(Character.toChars(it)) }
    }
}
