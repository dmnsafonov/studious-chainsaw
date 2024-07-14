package net.domisafonov.compasstestproject.ui.wordcountscreen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.flow.map
import net.domisafonov.compasstestproject.ui.theme.CompassTestProjectTheme

@Composable
fun WordCountScreenUi(
    modifier: Modifier = Modifier,
) {

    val viewModel: WordCountScreenViewModel = hiltViewModel()

    val text by viewModel.wordCountText.map { it ?: "TODO" }.collectAsState(initial = "TODO")

    Text(
        text = text,
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun WordCountScreenPreview() {
    CompassTestProjectTheme {
        WordCountScreenUi()
    }
}
