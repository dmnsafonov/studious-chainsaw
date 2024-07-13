package net.domisafonov.compasstestproject.ui.tenthcharacterscreen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import net.domisafonov.compasstestproject.ui.theme.CompassTestProjectTheme
import net.domisafonov.compasstestproject.ui.wordcountscreen.WordCountScreenViewModel

@Composable
fun TenthCharacterScreenUi(
    modifier: Modifier = Modifier,
) {

    val viewModel: WordCountScreenViewModel = hiltViewModel()

    Text(
        text = viewModel.toString(),
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun TenthCharacterScreenPreview() {
    CompassTestProjectTheme {
        TenthCharacterScreenUi()
    }
}
