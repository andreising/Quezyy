package com.andreisingeleytsev.quezyy.ui.screens.question_screen

import android.os.CountDownTimer
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreisingeleytsev.quezyy.ui.utils.UIEvents
import com.andreisingeleytsev.quezyy.R
import com.andreisingeleytsev.quezyy.ui.theme.MainColor
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class QuestionScreenViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private val _uiEvent = Channel<UIEvents>()
    val uiEvent = _uiEvent.receiveAsFlow()
    private fun sendUIEvent(event: UIEvents){
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }

    fun onEvent(event: QuestionScreenEvent){
        when(event) {
            is QuestionScreenEvent.OnButtonPressed -> {
                if (isGameOn.value) {
                    val index = shuffledList.value.indexOf(questionItem!!.currentAnswer)
                    colorList[index].value = Color.Yellow
                    object : CountDownTimer(300, 300) {
                        override fun onTick(p0: Long) {

                        }

                        override fun onFinish() {
                            colorList[index].value = MainColor.copy(alpha = 0.5F)
                        }

                    }.start()
                } else sendUIEvent(UIEvents.OnBack)
            }
            is QuestionScreenEvent.OnAnswer -> {
                if (isGameOn.value) {
                    timer.cancel()
                    isGameOn.value = false
                    val currentIndex = shuffledList.value.indexOf(questionItem!!.currentAnswer)
                    if (event.index != currentIndex) {
                        title.value = R.string.incorrect
                        colorList[event.index].value = Color.Red
                        colorList[currentIndex].value = Color.Green
                    } else colorList[event.index].value = Color.Green
                }
            }
        }
    }

    private val timer = object : CountDownTimer(
        10000, 1000
    ) {
        override fun onTick(p0: Long) {
            time.value-=1
        }

        override fun onFinish() {
            isGameOn.value = false
            title.value = R.string.time_is_out
            val index = shuffledList.value.indexOf(questionItem!!.currentAnswer)
            colorList[index].value = Color.Green
        }

    }

    val time = mutableStateOf(
        10
    )
    val isGameOn = mutableStateOf(
        true
    )
    val title = mutableStateOf(
        R.string.right
    )

    private var questionItem: QuestionItem? = null
    val question = mutableStateOf(R.string.play_now)
    val shuffledList = mutableStateOf(
        listOf<Int>()
    )

    val colorList = listOf(
        mutableStateOf(
            MainColor.copy(alpha = 0.5F),
        ),
        mutableStateOf(
            MainColor.copy(alpha = 0.5F),
        ),
        mutableStateOf(
            MainColor.copy(alpha = 0.5F),
        ),
        mutableStateOf(
            MainColor.copy(alpha = 0.5F),
        ),
    )

    private var categoryIndex = -1
    init {
        categoryIndex = savedStateHandle.get<String>("category_id")?.toInt()!!
        questionItem = listOfCategories[categoryIndex].random()
        question.value = questionItem!!.question
        mutableListOf<Int>().also {
            it.add(questionItem!!.currentAnswer)
            it.add(questionItem!!.answer2)
            it.add(questionItem!!.answer3)
            it.add(questionItem!!.answer4)
            it.shuffle()
            shuffledList.value = it
        }
        timer.start()
    }
}

val listOfCategories = listOf(
    listOf(
        QuestionItem(
            question = R.string.what_is_the_largest_species_of_big_cat, currentAnswer =
            R.string.tiger, answer2 = R.string.lion, answer3 = R.string.leopard, answer4 =
            R.string.jaguar
        ),
        QuestionItem(
            question = R.string.what_s_the_fastest_land_animal,
            currentAnswer =
            R.string.cheetah,
            answer2 = R.string.lion,
            answer3 = R.string.gazelle,
            answer4 = R.string.leopard
        ),
        QuestionItem(
            question = R.string.what_animal_barks,
            currentAnswer = R.string.dog,
            answer2 = R.string.cat,
            answer3 = R.string.horse,
            answer4 = R.string.cow
        ),
        QuestionItem(
            question = R.string.what_s_a_baby_sheep_called,
            currentAnswer =
            R.string.lamb, answer2 = R.string.kid, answer3 = R.string.piglet, answer4 =
            R.string.calf
        ),
        QuestionItem(
            question = R.string.what_animal_has_stripes, currentAnswer =
            R.string.zebra, answer2 = R.string.elephant, answer3 = R.string.giraffe, answer4 =
            R.string.hippopotamus
        ),
        QuestionItem(
            question = R.string.what_animal_hops, currentAnswer =
            R.string.kangaroo, answer2 = R.string.bear, answer3 = R.string.elephant, answer4 =
            R.string.gorilla
        ),
        QuestionItem(
            question = R.string.what_s_a_nocturnal_bird, currentAnswer =
            R.string.owl, answer2 =
            R.string.eagle, answer3 = R.string.penguin, answer4 = R.string.parrot
        ),
        QuestionItem(
            question = R.string.what_animal_can_fly_without_wings, currentAnswer =
            R.string.snake, answer2 = R.string.fish, answer3 = R.string.turtle, answer4 =
            R.string.lizard
        ),
        QuestionItem(
            question = R.string.what_s_a_large_marine_mammal, currentAnswer =
            R.string.whale, answer2 = R.string.dolphin, answer3 = R.string.seal, answer4 =
            R.string.shark
        ),
        QuestionItem(
            question = R.string.what_animal_has_a_mane,
            currentAnswer = R.string.lion,
            answer2 = R.string.horse,
            answer3 = R.string.gorilla,
            answer4 = R.string.mouse
        ),
        QuestionItem(
            question = R.string.what_s_a_small_rodent, currentAnswer =
            R.string.mouse, answer2 = R.string.rat, answer3 = R.string.squirrel, answer4 =
            R.string.hamster
        )
    ),
    listOf(
        QuestionItem(
            question = R.string.which_process_do_plants_use_to_convert_light_energy_into_chemical_energy,
            currentAnswer = R.string.photosynthesis,
            answer2 = R.string.respiration,
            answer3 = R.string.transpiration,
            answer4 = R.string.fermentation
        ),
        QuestionItem(
            question = R.string.what_s_photosynthesis,
            currentAnswer = R.string.conversion,
            answer2 = R.string.energy_prod,
            answer3 = R.string.sun_process,
            answer4 = R.string.food_making
        ),
        QuestionItem(
            question = R.string.plants_breathe_through,
            currentAnswer = R.string.stomata,
            answer2 = R.string.leaves,
            answer3 = R.string.flowers,
            answer4 = R.string.roots
        ),
        QuestionItem(
            question = R.string.roots_absorb,
            currentAnswer = R.string.nutrients,
            answer2 = R.string.sunlight,
            answer3 = R.string.water,
            answer4 = R.string.oxygen
        ),
        QuestionItem(
            question = R.string.leaves_release,
            currentAnswer = R.string.oxygen,
            answer2 = R.string.carbon_diox,
            answer3 = R.string.water_vapor,
            answer4 = R.string.energy
        ),
        QuestionItem(
            question = R.string.plant_support,
            currentAnswer = R.string.stem,
            answer2 = R.string.root,
            answer3 = R.string.leaf,
            answer4 = R.string.flower
        ),
        QuestionItem(
            question = R.string.reproductive_cell,
            currentAnswer = R.string.pollen,
            answer2 = R.string.leaf,
            answer3 = R.string.stem,
            answer4 = R.string.root
        ),
        QuestionItem(
            question = R.string.tree_layers,
            currentAnswer = R.string.bark,
            answer2 = R.string.wood,
            answer3 = R.string.leaves,
            answer4 = R.string.flowers
        ),
        QuestionItem(
            question = R.string.photosynthesis_location,
            currentAnswer = R.string.chloroplasts,
            answer2 = R.string.stomata,
            answer3 = R.string.cell_walls,
            answer4 = R.string.roots
        ),
        QuestionItem(
            question = R.string.annual_rings_count,
            currentAnswer = R.string.age,
            answer2 = R.string.weather,
            answer3 = R.string.height,
            answer4 = R.string.color
        ),
        QuestionItem(
            question = R.string.plant_reproduction,
            currentAnswer = R.string.seeds,
            answer2 = R.string.leaves,
            answer3 = R.string.stem,
            answer4 = R.string.roots
        )
    ),
    listOf(
        QuestionItem(
            question = R.string.what_is_the_term_for_a_large_rotating_storm_system_characterized_by_low_pressure_at_its_center_and_strong_winds_circulating_around_it,
            currentAnswer = R.string.hurricane,
            answer2 = R.string.tornado,
            answer3 = R.string.typhoon,
            answer4 = R.string.earthquake
        ),
        QuestionItem(
            question = R.string.what_s_a_tempest,
            currentAnswer = R.string.storm,
            answer2 = R.string.breeze,
            answer3 = R.string.blizzard,
            answer4 = R.string.quake
        ),
        QuestionItem(
            question = R.string.what_s_a_twister,
            currentAnswer = R.string.tornado,
            answer2 = R.string.hail,
            answer3 = R.string.rain,
            answer4 = R.string.fog
        ),
        QuestionItem(
            question = R.string.what_s_a_short_burst_of_heavy_rain,
            currentAnswer = R.string.cloudburst,
            answer2 = R.string.drizzle,
            answer3 = R.string.sleet,
            answer4 = R.string.sunshine
        ),
        QuestionItem(
            question = R.string.what_s_a_weather_prediction,
            currentAnswer = R.string.forecast,
            answer2 = R.string.lightning,
            answer3 = R.string.gale,
            answer4 = R.string.mist
        ),
        QuestionItem(
            question = R.string.what_s_a_moving_air_mass,
            currentAnswer = R.string.wind,
            answer2 = R.string.heat,
            answer3 = R.string.drought,
            answer4 = R.string.tsunami
        ),
        QuestionItem(
            question = R.string.what_s_a_frozen_rain,
            currentAnswer = R.string.sleet,
            answer2 = R.string.rainbow,
            answer3 = R.string.cloud,
            answer4 = R.string.frost
        ),
        QuestionItem(
            question = R.string.what_s_a_light_shower,
            currentAnswer = R.string.drizzle,
            answer2 = R.string.fog,
            answer3 = R.string.tornado,
            answer4 = R.string.heatwave
        ),
        QuestionItem(
            question = R.string.what_s_a_watery_vapor_in_air,
            currentAnswer = R.string.humidity,
            answer2 = R.string.snow,
            answer3 = R.string.avalanche,
            answer4 = R.string.tidal_wave
        ),
        QuestionItem(
            question = R.string.what_s_a_huge_snowstorm,
            currentAnswer = R.string.blizzard,
            answer2 = R.string.breeze,
            answer3 = R.string.quake,
            answer4 = R.string.tornado
        ),
        QuestionItem(
            question = R.string.what_s_a_circular_wind,
            currentAnswer = R.string.cyclone,
            answer2 = R.string.rain,
            answer3 = R.string.sleet,
            answer4 = R.string.fog
        )
    )
)