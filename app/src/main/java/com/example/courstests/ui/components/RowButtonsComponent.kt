package com.example.courstests.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RowButtons(
    acceptOnclick: () -> Unit ,
    acceptLabel: String,
    cancelOnclick: () -> Unit ,
    cancelLabel:String,
    modifier: Modifier = Modifier
){

    Row(modifier.fillMaxWidth().padding(15.dp)) {


        Button(
            onClick = cancelOnclick,
            modifier.weight(2f),
            colors =
                ButtonColors(Color.Gray,
                    Color.White,
                    Color.Black,
                    Color.LightGray)) {
            Text(cancelLabel)
        }

        Spacer(modifier.weight(1f))

        Button(onClick = acceptOnclick, modifier.weight(2f)) {
            Text(acceptLabel)
        }

    }

}

//@Preview
//@Composable
//private fun Preview(){
//    RowButtons({},"Accept",{},"Cancel")
//}