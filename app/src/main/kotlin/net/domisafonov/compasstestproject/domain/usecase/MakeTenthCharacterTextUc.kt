package net.domisafonov.compasstestproject.domain.usecase

fun interface MakeTenthCharacterTextUc {
    suspend fun execute(src: String): String
}

class MakeTenthCharacterTextUcImpl : MakeTenthCharacterTextUc {

    override suspend fun execute(src: String): String {
        val codePointList = ArrayList<Int>(src.length)
        var n = 1
        src.codePoints().forEach { cp ->
            if (n % 10 == 0) codePointList += cp
            ++n
        }
        return codePointList.joinToString { String(Character.toChars(it)) }
    }
}
