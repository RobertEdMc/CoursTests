package com.example.courstests.model
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class DataCourse(
    @StringRes val nameCourse: Int,
    val amountCourse: Int,
    @DrawableRes val imageCourse: Int
)
