package net.domisafonov.compasstestproject.ui.wordcountscreen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import net.domisafonov.compasstestproject.domain.usecase.ObserveWordCountTextUc
import javax.inject.Inject

@HiltViewModel
class WordCountScreenViewModel @Inject constructor(
    observeWordCountTextUc: ObserveWordCountTextUc,
) : ViewModel() {

    val wordCountText: Flow<String?> = observeWordCountTextUc.execute()
}
