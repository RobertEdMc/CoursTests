package com.example.courstests.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.courstests.model.CardClass
import com.example.courstests.model.LaunchDataState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LunchViewModel: ViewModel() {


    private val _uiState =  MutableStateFlow(LaunchDataState())
    val uiState : StateFlow<LaunchDataState> = _uiState.asStateFlow()

    private var selectComponent: MutableList<CardClass> = mutableListOf()


    fun addChoseLaunch( chose: CardClass ){
        selectComponent.add(chose)
    }

    fun deselectLaunch(chose: CardClass ){
        selectComponent.remove(chose)
    }

    fun getAllSelectedLaunch(): List<CardClass>{
        return selectComponent
    }

    fun summaryOfSelectedLaunch(): Array<Double>  {

        var summarySubTotal = 0.00
        val tax = 0.84

        for(launch in getAllSelectedLaunch()){

            summarySubTotal = summarySubTotal + launch.price

        }

        val total = summarySubTotal + tax

        return arrayOf(summarySubTotal,tax,total)





    }


}