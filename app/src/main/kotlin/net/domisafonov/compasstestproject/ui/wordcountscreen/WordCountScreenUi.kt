package net.domisafonov.compasstestproject.ui.wordcountscreen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import net.domisafonov.compasstestproject.ui.tenthcharacterscreen.TenthCharacterScreenUi
import net.domisafonov.compasstestproject.ui.theme.CompassTestProjectTheme

@Composable
fun WordCountScreenUi(
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
fun WordCountScreenPreview() {
    CompassTestProjectTheme {
        TenthCharacterScreenUi()
    }
}
