package com.andreisingeleytsev.quezyy.ui.screens.question_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.andreisingeleytsev.quezyy.R
import com.andreisingeleytsev.quezyy.ui.theme.MainColor
import com.andreisingeleytsev.quezyy.ui.theme.SecondaryColor2
import com.andreisingeleytsev.quezyy.ui.utils.Fonts
import com.andreisingeleytsev.quezyy.ui.utils.UIEvents

@Composable
fun QuestionScreen(navHostController: NavHostController, viewModel: QuestionScreenViewModel = hiltViewModel()) {
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect() {
            when (it) {
                is UIEvents.OnBack -> {
                    navHostController.popBackStack()
                }
                else -> {

                }
            }
        }
    }
    Box(modifier = Modifier.fillMaxSize().background(MainColor)){
        Card(
            colors = CardDefaults.cardColors(
                containerColor = SecondaryColor2
            ), modifier = Modifier.padding(16.dp), shape = RoundedCornerShape(16.dp)
        ) {
            Column(modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
            ) {
                if (viewModel.isGameOn.value) Text(
                    text = stringResource(id = R.string.duration) + " "
                            + viewModel.time.value.toString()
                            + " " + stringResource(
                        id = R.string.seconds
                    ),
                    style = TextStyle(
                        color = Color.White, fontSize = 14.sp, fontFamily = Fonts.font
                    )
                ) else Text(
                    text = stringResource(id = viewModel.title.value), style = TextStyle(
                        color = Color.White,
                        fontSize = 24.sp,
                        fontFamily = Fonts.font,
                        textAlign = TextAlign.Center
                    ), modifier = Modifier.fillMaxWidth()
                )

                Text(text = stringResource(id = viewModel.question.value), style = TextStyle(
                    color = Color.White, fontSize = 28.sp, fontFamily = Fonts.font
                ))
                Spacer(modifier = Modifier.height(24.dp))
                BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
                    val width = (maxWidth-8.dp)/2
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier.width(width)) {
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        viewModel.onEvent(QuestionScreenEvent.OnAnswer(0))
                                    },
                                shape = RoundedCornerShape(16.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = viewModel.colorList[0].value
                                )
                            ) {
                                Text(
                                    text = stringResource(id = viewModel.shuffledList.value[0]),
                                    style = TextStyle(
                                        color = Color.White, fontSize = 20.sp, fontFamily = Fonts.font,
                                        textAlign = TextAlign.Center
                                    ),
                                    modifier = Modifier
                                        .padding(
                                            top = 16.dp,
                                            bottom = 16.dp,
                                            start = 5.dp,
                                            end = 5.dp
                                        )
                                        .fillMaxWidth()
                                )
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        viewModel.onEvent(QuestionScreenEvent.OnAnswer(2))
                                    },
                                shape = RoundedCornerShape(16.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = viewModel.colorList[2].value
                                )
                            ) {
                                Text(text = stringResource(id = viewModel.shuffledList.value[2]), style = TextStyle(
                                    color = Color.White, fontSize = 20.sp, fontFamily = Fonts.font,
                                    textAlign = TextAlign.Center
                                ),
                                    modifier = Modifier
                                        .padding(
                                            top = 16.dp,
                                            bottom = 16.dp,
                                            start = 5.dp,
                                            end = 5.dp
                                        )
                                        .fillMaxWidth())
                            }
                        }
                        Column(modifier = Modifier.width(width)) {
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        viewModel.onEvent(QuestionScreenEvent.OnAnswer(1))
                                    },
                                shape = RoundedCornerShape(16.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = viewModel.colorList[1].value
                                )
                            ) {
                                Text(text = stringResource(id = viewModel.shuffledList.value[1]), style = TextStyle(
                                    color = Color.White, fontSize = 20.sp, fontFamily = Fonts.font,
                                    textAlign = TextAlign.Center
                                ),
                                    modifier = Modifier
                                        .padding(
                                            top = 16.dp,
                                            bottom = 16.dp,
                                            start = 5.dp,
                                            end = 5.dp
                                        )
                                        .fillMaxWidth())
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        viewModel.onEvent(QuestionScreenEvent.OnAnswer(3))
                                    },
                                shape = RoundedCornerShape(16.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = viewModel.colorList[3].value
                                )
                            ) {
                                Text(text = stringResource(id = viewModel.shuffledList.value[3]), style = TextStyle(
                                    color = Color.White, fontSize = 20.sp, fontFamily = Fonts.font,
                                    textAlign = TextAlign.Center
                                ),
                                    modifier = Modifier
                                        .padding(
                                            top = 16.dp,
                                            bottom = 16.dp,
                                            start = 5.dp,
                                            end = 5.dp
                                        )
                                        .fillMaxWidth())
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(44.dp))
                OutlinedButton(onClick = {
                    viewModel.onEvent(QuestionScreenEvent.OnButtonPressed)
                },
                    shape = RoundedCornerShape(40.dp),
                    border = BorderStroke(1.dp, Color.White.copy(0.1F)),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row {
                        Icon(
                            painter = painterResource(id = R.drawable.lightbull),
                            contentDescription = null,
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = if (viewModel.isGameOn.value) stringResource(id = R.string.find_answer)
                            else stringResource(id = R.string.to_categories)
                        )
                    }
                }
            }
        }
    }
}