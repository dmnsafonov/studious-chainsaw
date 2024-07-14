package net.domisafonov.compasstestproject.ui.tenthcharacterscreen

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.flow.map
import net.domisafonov.compasstestproject.ui.COMPACT_VIEW_CHAR_LIMIT
import net.domisafonov.compasstestproject.ui.theme.CompassTestProjectTheme

@Composable
fun TenthCharacterScreenUi(
    modifier: Modifier = Modifier,
    doCompactView: Boolean = false,
) {

    val viewModel: TenthCharacterScreenViewModel = hiltViewModel()

    val text by viewModel.text.map { it ?: "TODO" }.collectAsState(initial = "TODO")

    if (doCompactView) {
        Text(
            text = text.take(COMPACT_VIEW_CHAR_LIMIT),
            modifier = modifier,
            overflow = TextOverflow.Ellipsis,
        )
    } else {
        Text(
            text = text,
            modifier = modifier.verticalScroll(rememberScrollState()),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TenthCharacterScreenPreview() {
    CompassTestProjectTheme {
        TenthCharacterScreenUi()
    }
}
