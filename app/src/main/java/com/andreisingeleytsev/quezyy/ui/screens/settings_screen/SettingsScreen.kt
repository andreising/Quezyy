package com.andreisingeleytsev.quezyy.ui.screens.settings_screen

import android.media.MediaPlayer
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andreisingeleytsev.quezyy.ui.theme.MainColor
import com.andreisingeleytsev.quezyy.ui.theme.SecondaryColor
import com.andreisingeleytsev.quezyy.ui.theme.SecondaryColor2
import com.andreisingeleytsev.quezyy.ui.utils.Fonts

@Composable
fun SettingsScreen(mediaPlayer: MediaPlayer?) {
    Box(modifier = Modifier.fillMaxSize().background(MainColor), contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val sound = remember {
                mutableStateOf(true)
            }
            Text(
                text = "SOUND",
                style = TextStyle(fontFamily = Fonts.font, color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "off",
                    style = TextStyle(fontFamily = Fonts.font, color = Color.White, fontSize = 20.sp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Switch(
                    checked = sound.value, onCheckedChange = {
                        sound.value = !sound.value
                        if (sound.value) {
                            mediaPlayer!!.start()
                        } else {
                            mediaPlayer!!.pause()
                        }
                    }, colors = SwitchDefaults.colors(
                        uncheckedTrackColor = SecondaryColor2,
                        checkedTrackColor = SecondaryColor2,
                        uncheckedThumbColor = MainColor,
                        checkedThumbColor = SecondaryColor
                    )
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "on",
                    style = TextStyle(fontFamily = Fonts.font, color = Color.White, fontSize = 20.sp)
                )
            }
        }
    }
}