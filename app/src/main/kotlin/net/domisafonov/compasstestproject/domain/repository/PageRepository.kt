package net.domisafonov.compasstestproject.domain.repository

import kotlinx.coroutines.flow.Flow
import net.domisafonov.compasstestproject.domain.model.Page

interface PageRepository {

    fun observePage(url: String): Flow<Page?>

    suspend fun forceUpdatePage(url: String)
}
