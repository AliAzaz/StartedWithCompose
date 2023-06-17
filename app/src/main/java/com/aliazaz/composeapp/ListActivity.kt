package com.aliazaz.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aliazaz.composeapp.ui.theme.FirstComposeAppTheme

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ListApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListApp() {
    val lemonadeMapping = arrayListOf(
        Pair(R.drawable.lemon_tree, "Tap a lemon tree to select a lemon"),
        Pair(R.drawable.lemon_squeeze, "Keep tapping the lemon to squeeze it"),
        Pair(R.drawable.lemon_drink, "Tap the lemonade to drink it"),
        Pair(R.drawable.lemon_restart, "Tap the empty glass to start again")
    )

    LazyColumn {
        items(lemonadeMapping) {
            ItemView(itemData = it)
        }
    }
}

@Composable
fun ItemView(itemData: Pair<Int, String>) {
    Card(modifier = Modifier.padding(10.dp)) {
        Column {
            Image(
                painter = painterResource(itemData.first),
                contentDescription = itemData.first.toString(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(190.dp),
                contentScale = ContentScale.Inside
            )
            Text(
                text = itemData.second,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(5.dp),
                style = MaterialTheme.typography.body1
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview6() {
    FirstComposeAppTheme {
        ListApp()
    }
}