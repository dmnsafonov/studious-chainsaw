package net.domisafonov.compasstestproject.ui.tenthcharacterscreen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import net.domisafonov.compasstestproject.domain.usecase.ObserveTenthCharacterTextUc
import javax.inject.Inject

@HiltViewModel
class TenthCharacterScreenViewModel @Inject constructor(
    observeTenthCharacterTextUc: ObserveTenthCharacterTextUc,
) : ViewModel() {

    val text: Flow<String?> = observeTenthCharacterTextUc.execute()
}
