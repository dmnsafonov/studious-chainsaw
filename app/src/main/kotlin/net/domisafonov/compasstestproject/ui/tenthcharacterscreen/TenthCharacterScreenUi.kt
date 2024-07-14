package net.domisafonov.compasstestproject.ui.tenthcharacterscreen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import net.domisafonov.compasstestproject.ui.theme.CompassTestProjectTheme

// FIXME: remove scaffolding
@Composable
fun TenthCharacterScreenUi(
    modifier: Modifier = Modifier,
) {

    val viewModel: TenthCharacterScreenViewModel = hiltViewModel()

    val t by viewModel.text.collectAsState(initial = null)

    Text(
        text = t?.contents?.take(1000) ?: "empty",
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
