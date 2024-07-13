package net.domisafonov.compasstestproject.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import net.domisafonov.compasstestproject.AppState
import net.domisafonov.compasstestproject.ui.tenthcharacterscreen.TenthCharacterScreenUi
import net.domisafonov.compasstestproject.ui.mainscreen.MainScreenUi
import net.domisafonov.compasstestproject.ui.wordcountscreen.WordCountScreenUi

@Composable
fun NavHost(
    appState: AppState,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = appState.navController,
        startDestination = "main",
        modifier = modifier,
    ) {
        composable(route = "main") {
            MainScreenUi(
                onTenthClick = { appState.navController.navigate("details/tenchcharacter") },
                onWordCountClick = { appState.navController.navigate("details/wordcount") },
            )
        }

        composable(route = "details/tenchcharacter") { TenthCharacterScreenUi() }
        composable(route = "details/wordcount") { WordCountScreenUi() }
    }
}
