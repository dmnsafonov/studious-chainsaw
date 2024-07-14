package net.domisafonov.compasstestproject.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import net.domisafonov.compasstestproject.BuildConfig
import net.domisafonov.compasstestproject.domain.repository.PageRepository
import javax.inject.Inject

fun interface ObserveTenthCharacterTextUc {
    fun execute(): Flow<String?>
}

class ObserveTenthCharacterTextUcImpl @Inject constructor(
    private val pageRepository: PageRepository,
    private val makeTenthCharacterTextUc: MakeTenthCharacterTextUc,
) : ObserveTenthCharacterTextUc {

    override fun execute(): Flow<String?> = pageRepository.observePage("${BuildConfig.PAGE_API_URL}/about/")
        .map { page -> page?.let { makeTenthCharacterTextUc.execute(page.contents) } }
}
