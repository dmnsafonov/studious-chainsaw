package net.domisafonov.compasstestproject.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import net.domisafonov.compasstestproject.BuildConfig
import net.domisafonov.compasstestproject.domain.repository.PageRepository

fun interface ObserveWordCountTextUc {
    fun execute(): Flow<String?>
}

class ObserveWordCountTextUcImpl(
    private val pageRepository: PageRepository,
    private val makeWordCountTextUc: MakeWordCountTextUc,
) : ObserveWordCountTextUc {

    override fun execute(): Flow<String?> = pageRepository.observePage("${BuildConfig.PAGE_API_URL}/about/")
        .map { page -> page?.let { makeWordCountTextUc.execute(page.contents) } }
}
