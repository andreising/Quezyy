package com.andreisingeleytsev.quezyy.ui.navigation

import android.media.MediaPlayer
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.andreisingeleytsev.quezyy.R
import com.andreisingeleytsev.quezyy.ui.screens.category_screen.CategoryScreen
import com.andreisingeleytsev.quezyy.ui.screens.question_screen.QuestionScreen
import com.andreisingeleytsev.quezyy.ui.screens.rules_screen.RulesScreen
import com.andreisingeleytsev.quezyy.ui.screens.settings_screen.SettingsScreen
import com.andreisingeleytsev.quezyy.ui.screens.start_screen.StartScreen
import com.andreisingeleytsev.quezyy.ui.utils.Routes

@Composable
fun QuezzyNavigation(
    isMain: MutableState<Boolean>,
    title: MutableState<String>,
    navHostController: NavHostController,
    mediaPlayer: MediaPlayer?
) {
    NavHost(navController = navHostController, startDestination = Routes.MAIN_SCREEN) {
        composable(Routes.MAIN_SCREEN) {
            StartScreen(navHostController)
            isMain.value = true
            title.value = ""
        }
        composable(Routes.SETTINGS_SCREEN) {
            SettingsScreen(mediaPlayer = mediaPlayer)
            isMain.value = false
            title.value = stringResource(id = R.string.settings)
        }
        composable(Routes.RULES_SCREEN) {
            RulesScreen()
            isMain.value = false
            title.value = stringResource(id = R.string.rules_title)
        }
        composable(Routes.GAME_SCREEN + "/{category_id}") {
            QuestionScreen(navHostController)
            isMain.value = false
            title.value = stringResource(id = R.string.question)
        }
        composable(Routes.CATEGORY_SCREEN) {
            CategoryScreen(navHostController)
            isMain.value = false
            title.value = stringResource(id = R.string.category)
        }
    }
}