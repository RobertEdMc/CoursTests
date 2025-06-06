package com.example.courstests

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.courstests.core.navigation.ChoseAccompaniment
import com.example.courstests.core.navigation.ChoseEntree
import com.example.courstests.core.navigation.ChoseSide
import com.example.courstests.core.navigation.LaunchTray
import com.example.courstests.core.navigation.OrderCheck
import com.example.courstests.data.Data
import com.example.courstests.ui.ChoseAccompanimentScreen
import com.example.courstests.ui.ChoseEntreeScreen
import com.example.courstests.ui.ChoseSideScreen
import com.example.courstests.ui.LaunchTrayScreen
import com.example.courstests.ui.OrderCheckScreen
import com.example.courstests.ui.viewmodel.LunchViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LaunchAppTopBar(title:String , modifier: Modifier = Modifier){

    TopAppBar(
        title = { Text(title) },
        modifier = modifier
    )

}

@Composable
fun LaunchApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel: LunchViewModel = viewModel()
){
   // val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = { LaunchAppTopBar(title = "Launch App") }
    ){ innerPadding ->

        NavHost(
            navController = navController,
            startDestination = LaunchTray,
            modifier = modifier.padding(innerPadding)
        ){

            composable<LaunchTray> {
                LaunchTrayScreen({navController.navigate(ChoseEntree)})
            }

            composable<ChoseEntree> {
                ChoseEntreeScreen(
                    Data.choseEntree,
                    {navController.navigate(ChoseSide)} ,
                    {navController.popBackStack()},
                    stringResource(R.string.next),
                    stringResource(R.string.cancel),
                    viewModel
                )
            }

            composable<ChoseSide> {
                ChoseSideScreen(
                    Data.choseSide,
                    {navController.navigate(ChoseAccompaniment)} ,
                    {navController.popBackStack()},
                    stringResource(R.string.next),
                    stringResource(R.string.cancel),
                    viewModel
                )
            }

            composable<ChoseAccompaniment> {
                ChoseAccompanimentScreen(
                    Data.choseAccompaniment,
                    {navController.navigate(OrderCheck)} ,
                    {navController.popBackStack()},
                    stringResource(R.string.next),
                    stringResource(R.string.cancel),
                    viewModel
                )
            }

            composable<OrderCheck> {
                OrderCheckScreen(viewModel.getAllSelectedLaunch(),
                    { navController.popBackStack(LaunchTray,false) } ,
                    {navController.popBackStack()},
                    stringResource(R.string.submit),
                    stringResource(R.string.cancel),
                    viewModel.summaryOfSelectedLaunch()
                )
            }

        }


    }
}

//@Preview
//@Composable
//private fun Preview(){
//    LaunchApp()
//
//}