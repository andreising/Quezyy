package com.andreisingeleytsev.quezyy.ui.screens.question_screen

sealed class QuestionScreenEvent{
    data class OnAnswer(val index: Int): QuestionScreenEvent()
    object OnButtonPressed: QuestionScreenEvent()
}
