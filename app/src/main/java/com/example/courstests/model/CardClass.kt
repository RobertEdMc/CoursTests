package com.example.courstests.model

import androidx.annotation.StringRes

enum class Type{
    Entree,
    SideDish,
    Accompaniment
}

data class CardClass(
    @StringRes val title: Int,
    @StringRes val description: Int,
    val price: Double,
    val isSelected: Boolean,
    val type:Type
)

