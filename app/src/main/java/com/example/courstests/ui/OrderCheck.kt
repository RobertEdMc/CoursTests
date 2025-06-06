package com.example.courstests.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.courstests.model.CardClass
import com.example.courstests.ui.components.RowButtons

@Composable
fun OrderCheckScreen(
    dataOrder: List<CardClass>,
    nextNav: ()->Unit,
    previousNav:()->Unit,
    nextLabel: String,
    previousLabel:String,
    dataTotal: Array<Double>,
    modifier: Modifier = Modifier
) {
    Column(modifier.padding(12.dp)) {
        Text(
            "Order Summary",
            fontFamily = FontFamily.Serif,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        LazyColumn {
            items(dataOrder) {
                SummaryOrder(it.title, it.price, Modifier.padding(8.dp))
            }
        }

        HorizontalDivider(thickness = 4.dp, modifier = Modifier.padding(bottom = 8.dp) )

        // Todo esto podria ser una Funcion de Componibilidad Aparte //
        Column(modifier = Modifier.fillMaxWidth().padding(6.dp), horizontalAlignment = Alignment.End) {

            Text("SubTotal: $${dataTotal[0]}",
                fontFamily = FontFamily.Serif,
                fontSize = 14.sp,
                modifier = Modifier.padding(3.dp)
            )

            Text("Tax: $${dataTotal[1]}",
                fontFamily = FontFamily.Serif,
                fontSize = 14.sp,
                modifier = Modifier.padding(3.dp)
                )

            Text("Total: $${dataTotal[2]}",
                fontFamily = FontFamily.Serif,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(3.dp)
            )

        }


        RowButtons(nextNav, nextLabel, previousNav, previousLabel, modifier.weight(1f))
    }
}

@Composable
fun SummaryOrder(@StringRes title:Int, price: Double, modifier: Modifier = Modifier){
    Row(modifier.fillMaxWidth()) {
        Text(
            stringResource(title),
            fontFamily = FontFamily.Serif,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            "$${ price.toString() }",
            fontFamily = FontFamily.Serif,
            fontSize = 14.sp
        )
    }
}


//@Preview(showSystemUi = true)
//@Composable
//private fun Preview(){
//    OrderCheck(Data.choseEntree, arrayOf(100.00, 03.00, 103.00))
//}