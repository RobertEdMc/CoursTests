package com.example.courstests.model

import androidx.annotation.DrawableRes

data class DataCourse(
    val nameCourse: String,
    @DrawableRes val imageCourse: Int,
    val amountCourse: Int
)
