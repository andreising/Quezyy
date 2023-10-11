package com.andreisingeleytsev.quezyy.ui.screens.main_screen

import android.media.MediaPlayer
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.andreisingeleytsev.quezyy.ui.navigation.QuezzyNavigation
import com.andreisingeleytsev.quezyy.ui.theme.MainColor
import com.andreisingeleytsev.quezyy.ui.utils.Fonts
import com.andreisingeleytsev.quezyy.ui.utils.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(mediaPlayer: MediaPlayer?) {
    val title = remember {
        mutableStateOf("")
    }
    val isMainScreen = remember {
        mutableStateOf(true)
    }
    val navHostController = rememberNavController()
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        TopAppBar(title = {
            if (!isMainScreen.value) Text(
                text = title.value, style = TextStyle(
                    color = Color.Black, fontSize = 24.sp, fontFamily = Fonts.font
                )
            )
        }, navigationIcon = {
            if (!isMainScreen.value) IconButton(onClick = {
                navHostController.popBackStack()
            }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        }, actions = {
            if (isMainScreen.value) {
                IconButton(onClick = {
                    navHostController.navigate(Routes.RULES_SCREEN)
                }) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
                IconButton(onClick = {
                    navHostController.navigate(Routes.SETTINGS_SCREEN)
                }) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        }, colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MainColor
        ))
    }) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            QuezzyNavigation(
                isMain = isMainScreen,
                title = title,
                navHostController = navHostController,
                mediaPlayer = mediaPlayer
            )
        }
    }
}