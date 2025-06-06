package com.example.courstests.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.courstests.data.Data
import com.example.courstests.model.CardClass
import com.example.courstests.ui.components.CardChose
import com.example.courstests.ui.components.RowButtons
import com.example.courstests.ui.viewmodel.LunchViewModel


@Composable
fun ChoseEntreeScreen(
    entreeCardList: List<CardClass>,
    nextNav: ()->Unit,
    previousNav:()->Unit,
    nextLabel: String,
    previousLabel:String,
    viewModel: LunchViewModel,
    modifier: Modifier = Modifier
){

    Column {
        LazyColumn(modifier.padding(10.dp).weight(5f)) {
            items(entreeCardList) {

                CardChose(it, viewModel ,modifier.padding(5.dp))

            }



        }

        RowButtons(nextNav, nextLabel, previousNav, previousLabel, modifier.weight(1f))
    }

}

//@Preview(showSystemUi = true)
//@Composable
//private fun ChoseEntreeScreenPreview(){
//
//    ChoseEntreeScreen(
//        Data.choseEntree,
//        {},{},
//        "",""
//    )
//}