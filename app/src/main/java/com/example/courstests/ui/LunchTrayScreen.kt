package com.example.courstests.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.courstests.R


@Composable
fun LaunchTrayScreen(oneClick: ()-> Unit ,modifier: Modifier = Modifier){

    Column(modifier.fillMaxSize(), Arrangement.Center, Alignment.CenterHorizontally) {

        Button(onClick = oneClick){
            Text(stringResource(R.string.start_order), modifier = Modifier.padding(start = 30.dp, end = 30.dp))
        }

    }

}