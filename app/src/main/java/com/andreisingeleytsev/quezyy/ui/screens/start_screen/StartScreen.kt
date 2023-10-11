package com.andreisingeleytsev.quezyy.ui.screens.start_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.andreisingeleytsev.quezyy.R
import com.andreisingeleytsev.quezyy.ui.theme.MainColor
import com.andreisingeleytsev.quezyy.ui.theme.SecondaryColor
import com.andreisingeleytsev.quezyy.ui.utils.Fonts
import com.andreisingeleytsev.quezyy.ui.utils.Routes

@Composable
fun StartScreen(navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MainColor),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.title),
            contentDescription = null,
            modifier = Modifier.width(270.dp),
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = stringResource(id = R.string.start_screen_txt), style = TextStyle(
                fontSize = 24.sp, fontFamily = Fonts.font, textAlign = TextAlign.Center
            )
        )
        OutlinedButton(
            onClick = {
                navHostController.navigate(Routes.CATEGORY_SCREEN)
            }, border = BorderStroke(
                width = 3.dp, color = Color.White
            ), colors = ButtonDefaults.buttonColors(
                containerColor = SecondaryColor
            )
        ) {
            Text(
                text = stringResource(id = R.string.play_now), style = TextStyle(
                    color = Color.White, fontSize = 28.sp, fontFamily = Fonts.font
                )
            )
        }
        Image(
            painter = painterResource(id = R.drawable.start_img),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
    }
}