package com.andreisingeleytsev.quezyy.ui.screens.category_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.andreisingeleytsev.quezyy.R
import com.andreisingeleytsev.quezyy.ui.theme.MainColor
import com.andreisingeleytsev.quezyy.ui.utils.Fonts
import com.andreisingeleytsev.quezyy.ui.utils.Routes
import java.util.Locale.Category

@Composable
fun CategoryScreen(navHostController: NavHostController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MainColor)) {
        Column(modifier = Modifier
            .padding(15.dp)
            .fillMaxSize()
        ) {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart){
                Image(
                    painter = painterResource(id = R.drawable.animals),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(id = R.string.animals), style = TextStyle(
                            color = Color.White, fontSize = 20.sp, fontFamily = Fonts.font
                        ))
                    Spacer(modifier = Modifier.height(50.dp))
                    OutlinedButton(
                        onClick = {
                            navHostController.navigate(Routes.GAME_SCREEN + "/0")
                        },
                        border = BorderStroke(1.dp, Color.White),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        )
                    ) {
                        Text(text = stringResource(id = R.string.play_now), style = TextStyle(
                            color = Color.White, fontSize = 14.sp, fontFamily = Fonts.font
                        ))
                    }
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart){
                Image(
                    painter = painterResource(id = R.drawable.plants),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(id = R.string.plants), style = TextStyle(
                            color = Color.White, fontSize = 20.sp, fontFamily = Fonts.font
                        )
                    )
                    Spacer(modifier = Modifier.height(50.dp))
                    OutlinedButton(
                        onClick = {
                            navHostController.navigate(Routes.GAME_SCREEN + "/1")
                        },
                        border = BorderStroke(1.dp, Color.White),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        )
                    ) {
                        Text(
                            text = stringResource(id = R.string.play_now), style = TextStyle(
                                color = Color.White, fontSize = 14.sp, fontFamily = Fonts.font
                            )
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart){
                Image(
                    painter = painterResource(id = R.drawable.weather),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(id = R.string.weather), style = TextStyle(
                            color = Color.White, fontSize = 20.sp, fontFamily = Fonts.font
                        ))
                    Spacer(modifier = Modifier.height(50.dp))
                    OutlinedButton(
                        onClick = {
                            navHostController.navigate(Routes.GAME_SCREEN + "/2")
                        },
                        border = BorderStroke(1.dp, Color.White),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        )
                    ) {
                        Text(
                            text = stringResource(id = R.string.play_now), style = TextStyle(
                                color = Color.White, fontSize = 14.sp, fontFamily = Fonts.font
                            )
                        )
                    }
                }
            }
        }
    }

}