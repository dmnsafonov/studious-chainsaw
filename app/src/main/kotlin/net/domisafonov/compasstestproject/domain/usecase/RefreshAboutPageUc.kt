package net.domisafonov.compasstestproject.domain.usecase

import net.domisafonov.compasstestproject.domain.repository.PageRepository
import net.domisafonov.compasstestproject.ui.ABOUT_PAGE_URL

fun interface RefreshAboutPageUc {
    suspend fun execute()
}

class RefreshAboutPageUcImpl(
    private val pageRepository: PageRepository,
) : RefreshAboutPageUc {
    override suspend fun execute() {
        pageRepository.forceUpdatePage(ABOUT_PAGE_URL)
    }
}
