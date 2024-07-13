package net.domisafonov.compasstestproject.ui.mainscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import net.domisafonov.compasstestproject.ui.tenthcharacterscreen.TenthCharacterScreenUi
import net.domisafonov.compasstestproject.ui.theme.CompassTestProjectTheme
import net.domisafonov.compasstestproject.ui.wordcountscreen.WordCountScreenUi

@Composable
fun MainScreenUi(
    modifier: Modifier = Modifier,
    onTenthClick: () -> Unit = {},
    onWordCountClick: () -> Unit = {},
) {

    val viewModel: MainScreenViewModel = hiltViewModel()

    Column(
        modifier = modifier.fillMaxSize()
            .padding(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth()
                .weight(1f)
                .clickable() { onTenthClick() }
        ) {
            TenthCharacterScreenUi(
                modifier = Modifier.fillMaxSize()
                    .padding(4.dp)
            )
        }

        Card(
            modifier = Modifier.fillMaxWidth()
                .weight(1f)
                .clickable { onWordCountClick() }
        ) {
            WordCountScreenUi(
                modifier = Modifier.fillMaxSize()
                    .padding(4.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    CompassTestProjectTheme {
        MainScreenUi()
    }
}
