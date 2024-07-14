package net.domisafonov.compasstestproject.ui.tenthcharacterscreen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import net.domisafonov.compasstestproject.BuildConfig
import net.domisafonov.compasstestproject.domain.repository.PageRepository
import javax.inject.Inject

// FIXME: remove scaffolding
@HiltViewModel
class TenthCharacterScreenViewModel @Inject constructor(
    repo: PageRepository,
) : ViewModel() {

    val text = repo.observePage("${BuildConfig.PAGE_API_URL}/about/")
}
