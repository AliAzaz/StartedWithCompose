package com.aliazaz.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aliazaz.composeapp.components.CircleButtonComponent
import com.aliazaz.composeapp.model.ArtShowCaseModel
import com.aliazaz.composeapp.ui.theme.FirstComposeAppTheme
import com.aliazaz.composeapp.viewmodel.ArtWorkShowcaseViewModel

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
            .wrapContentSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        ArtWorkShowCase()
    }
}

@Composable
fun ArtWorkShowCase(
    artWorkShowcaseViewModel: ArtWorkShowcaseViewModel = viewModel()
) {
    val currentState by artWorkShowcaseViewModel.artWorkItemIndex.collectAsState()

    val artShowCaseModel =
        arrayListOf(
            ArtShowCaseModel(
                artImage = R.drawable.pic01,
                artName = stringResource(R.string.lemon_tree),
                artistName = stringResource(R.string.app_name),
                artPublishedYear = stringResource(R.string.year_1954)
            ),
            ArtShowCaseModel(
                artImage = R.drawable.pic02,
                artName = stringResource(R.string.lemon_squeeze),
                artistName = stringResource(R.string.app_name),
                artPublishedYear = stringResource(R.string.year_1955)
            ),
            ArtShowCaseModel(
                artImage = R.drawable.pic03,
                artName = stringResource(R.string.lemon_drink),
                artistName = stringResource(R.string.app_name),
                artPublishedYear = stringResource(R.string.year_1956)
            ),
            ArtShowCaseModel(
                artImage = R.drawable.pic04,
                artName = stringResource(R.string.lemon_restart),
                artistName = stringResource(R.string.app_name),
                artPublishedYear = stringResource(R.string.year_1957)
            )
        )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ArtWorkContentPopulation(
            artShowCaseModel[currentState],
            currentState,
            artShowCaseModel.size - 1,
            {
                artWorkShowcaseViewModel.previousClick()
            },
            {
                artWorkShowcaseViewModel.nextClick()
            }
        )
    }
}

@Composable
fun ArtWorkContentPopulation(
    artShowCaseModel: ArtShowCaseModel,
    currentState: Int,
    modelSize: Int,
    previousClick: () -> Unit,
    nextClick: () -> Unit,
) {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .padding(30.dp),
        border = BorderStroke(1.dp, Color.LightGray),
        shadowElevation = 15.dp,
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(Color.White)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(30.dp),
                contentScale = ContentScale.FillHeight,
                painter = painterResource(id = artShowCaseModel.artImage),
                contentDescription = artShowCaseModel.artName
            )
        }
    }

    Spacer(Modifier.height(20.dp))

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp)
            .background(Color.LightGray)
            .padding(15.dp)
    ) {
        Text(
            text = artShowCaseModel.artName,
            style = MaterialTheme.typography.headlineSmall
        )
        Row {
            Text(
                text = artShowCaseModel.artistName,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(end = 5.dp)
            )
            Text(text = "(${artShowCaseModel.artPublishedYear})")
        }
    }

    Spacer(Modifier.height(10.dp))

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        if (currentState > 0)
            CircleButtonComponent(
                buttonText = stringResource(id = R.string.previous), previousClick
            )

        if (currentState < modelSize)
            CircleButtonComponent(
                buttonText = stringResource(id = R.string.next), nextClick
            )
    }
}

@Preview(showBackground = true)
@Composable
fun ArtWorkShowcaseAppPreview() {
    FirstComposeAppTheme {
        ArtWorkShowcaseApp()
    }
}