package com.example.courstests.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.courstests.model.CardClass
import com.example.courstests.ui.viewmodel.LunchViewModel


@Composable
fun CardChose(cardInfo: CardClass, viewModel: LunchViewModel ,modifier: Modifier = Modifier){

    var isPressed by remember { mutableStateOf(cardInfo.isSelected) }

    if(isPressed) viewModel.addChoseLaunch(cardInfo) else viewModel.deselectLaunch(cardInfo)

    Card(
        modifier
            .fillMaxWidth()
            .clickable(onClick = { isPressed = !isPressed })
            .fillMaxHeight()
    ) {
        Row(modifier, verticalAlignment = Alignment.CenterVertically) {

            RadioButton(
                selected = isPressed,
                onClick = { isPressed =  !isPressed}
            )

            Column(modifier, horizontalAlignment = Alignment.Start) {
                Text(stringResource(cardInfo.title), fontFamily = FontFamily.Serif, fontSize = 30.sp)
                Text(stringResource(cardInfo.description), fontFamily = FontFamily.Serif, fontSize = 12.sp)
                Text("$ ${cardInfo.price.toString()}", fontFamily = FontFamily.Serif, fontSize = 10.sp)
            }
        }
    }

}