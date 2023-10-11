package com.andreisingeleytsev.quezyy.ui.screens.rules_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andreisingeleytsev.quezyy.R
import com.andreisingeleytsev.quezyy.ui.theme.MainColor
import com.andreisingeleytsev.quezyy.ui.theme.SecondaryColor2
import com.andreisingeleytsev.quezyy.ui.utils.Fonts

@Composable
fun RulesScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MainColor),
        contentAlignment = Alignment.Center
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = SecondaryColor2
            ), modifier = Modifier.padding(16.dp), shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.rules), style = TextStyle(
                    color = Color.White,
                    fontSize = 40.sp,
                    fontFamily = Fonts.font,
                    textAlign = TextAlign.Center
                ), modifier = Modifier.padding(10.dp)
            )
        }
    }

}