package com.aliazaz.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aliazaz.composeapp.model.ArtShowCaseModel
import com.aliazaz.composeapp.ui.theme.FirstComposeAppTheme

class ArtWorkShowcaseActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeAppTheme {
                ArtWorkShowcaseApp()
            }
        }
    }
}

@Composable
fun ArtWorkShowcaseApp() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
        ,
        color = MaterialTheme.colorScheme.background
    ) {
        ArtWorkShowCase()
    }
}

@Composable
fun ArtWorkShowCase() {

    var currentState by remember { mutableStateOf(1) }

    var artShowCaseModel = ArtShowCaseModel(
        artImage = R.drawable.lemon_tree,
        artName = R.string.lemon_tree,
        artistName = R.string.app_name,
        artPublishedYear = R.string.roll
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ArtWorkContentPopulation(artShowCaseModel)
    }
}

@Composable
fun ArtWorkContentPopulation(artShowCaseModel: ArtShowCaseModel) {

    Surface(
        modifier = Modifier.padding(10.dp),
        border = BorderStroke(3.dp, Color.Gray),
        shadowElevation = 3.dp
    ) {
        Box(
            modifier = Modifier
                .background(Color.White)
                .padding(20.dp)
        ) {
            Image(
                painter = painterResource(id = artShowCaseModel.artImage),
                contentDescription = stringResource(id = artShowCaseModel.artName)
            )
        }



    }

}

@Preview(showBackground = true)
@Composable
fun ArtWorkShowcaseAppPreview() {
    FirstComposeAppTheme {
        ArtWorkShowcaseApp()
    }
}