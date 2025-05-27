package com.example.courstests

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.courstests.data.DataSource
import com.example.courstests.model.DataCourse
import com.example.courstests.ui.theme.CoursTestsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursTestsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CourseApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CourseApp(modifier: Modifier = Modifier) {

    val layoutDirection = LocalLayoutDirection.current
    Surface(
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(
                start = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateStartPadding(layoutDirection),
                end = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateEndPadding(layoutDirection),
            ),
    ) {
        CourseColum(
            dataCourse = DataSource.courses
        )
    }

}

@Composable
fun CourseCard(courseInformation: DataCourse, modifier: Modifier = Modifier){

    Card(modifier) {
        Row(verticalAlignment = Alignment.Bottom) {
            Image(
                painter = painterResource(courseInformation.imageCourse),
                contentDescription = stringResource(courseInformation.nameCourse),
                modifier = modifier.width(68.dp).height(68.dp)
            )

            Column(
                modifier = modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
                horizontalAlignment = Alignment.Start
                ) {
                Text(
                    text = stringResource(courseInformation.nameCourse),
                    fontSize = 15.sp
                )
                Row(
                    modifier = modifier.padding(top = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                    ){

                    Image(painterResource(R.drawable.ic_grain), contentDescription = null)

                    Text(
                        text = courseInformation.amountCourse.toString(),
                        modifier.padding(start = 8.dp),
                        fontSize = 13.sp
                    )
                }

            }

        }
    }

}


@Composable
fun CourseColum(dataCourse: List<DataCourse>, modifier: Modifier = Modifier) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = modifier.fillMaxSize().padding(8.dp),
        verticalItemSpacing = 4.dp,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        content = {
            items(dataCourse) { item ->
                CourseCard(item)
            }
        }
    )
}


