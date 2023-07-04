package com.aliazaz.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aliazaz.composeapp.ui.theme.FirstComposeAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

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

@Composable
fun ListApp() {
    val lemonadeMapping = arrayListOf(
        Pair(R.drawable.lemon_tree, "Tap a lemon tree to select a lemon"),
        Pair(R.drawable.lemon_squeeze, "Keep tapping the lemon to squeeze it"),
        Pair(R.drawable.lemon_drink, "Tap the lemonade to drink it"),
        Pair(R.drawable.lemon_restart, "Tap the empty glass to start again"),
        Pair(R.drawable.lemon_tree, "Tap a lemon tree to select a lemon"),
        Pair(R.drawable.lemon_squeeze, "Keep tapping the lemon to squeeze it"),
        Pair(R.drawable.lemon_drink, "Tap the lemonade to drink it"),
        Pair(R.drawable.lemon_restart, "Tap the empty glass to start again")
    )
    val lazyListState = rememberLazyListState()
    val showScrollToTopButton by remember {
        derivedStateOf {
            lazyListState.firstVisibleItemIndex > 0
        }
    }
    val coroutineScope = rememberCoroutineScope()

    ListView(lemonadeMapping, lazyListState, showScrollToTopButton, coroutineScope)

}

@Composable
fun ListView(
    lemonadeMapping: ArrayList<Pair<Int, String>>,
    lazyListState: LazyListState,
    showScrollToTopButton: Boolean,
    coroutineScope: CoroutineScope
) {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(10.dp),
            state = lazyListState,
            contentPadding = PaddingValues(15.dp)
        ) {
            items(lemonadeMapping) {
                ItemView(itemData = it)
            }
        }

        ScrollToTopButton(
            flag = showScrollToTopButton,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(5.dp)
                .size(60.dp)
                .clickable {
                    coroutineScope.launch {
                        lazyListState.animateScrollToItem(
                            0
                        )
                    }
                }
        )
    }
}

@Composable
fun ItemView(itemData: Pair<Int, String>) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .height(130.dp)
    ) {
        Row {
            Image(
                painter = painterResource(itemData.first),
                contentDescription = itemData.first.toString(),
                modifier = Modifier
                    .width(130.dp)
                    .fillMaxHeight()
                    .padding(10.dp),
                contentScale = ContentScale.Inside
            )
            Text(
                text = itemData.second,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(5.dp),
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun ScrollToTopButton(flag: Boolean, modifier: Modifier) {
    if (flag) {
        Image(
            painter = painterResource(id = R.drawable.ic_up_arrow),
            contentDescription = null,
            modifier = modifier
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ListAppPreview() {
    FirstComposeAppTheme {
        ListApp()
    }
}