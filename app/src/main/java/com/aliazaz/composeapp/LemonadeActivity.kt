package com.aliazaz.composeapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aliazaz.composeapp.R
import com.aliazaz.composeapp.ui.theme.FirstComposeAppTheme

class LemonadeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeAppTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun LemonadeApp() {

    var steps by remember { mutableStateOf(1) }
    var squeeze by remember { mutableStateOf((2..4).random()) }
    var squeezeMsgShow by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        LemonadeSteps(
            modifier = Modifier.wrapContentSize(Alignment.Center),
            steps,
            squeezeMsgShow
        ) {
            if (steps in 1..3) {
                if (steps == 2) {
                    squeeze--
                    squeezeMsgShow =
                        if (squeeze <= 0) {
                            steps++
                            false
                        } else true
                } else steps++
            } else {
                steps = 1
                squeeze = (2..4).random()
            }
        }
    }
}

@Composable
fun LemonadeSteps(modifier: Modifier, steps: Int, squeeze: Boolean, onClick: () -> Unit) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        if (squeeze)
            Text(
                text = "More Squeeze is required",
                modifier = Modifier.align(Alignment.End)
            )
        Spacer(modifier = Modifier.height(16.dp))
        val specificLemonade = lemonadeMapping(steps)
        Image(
            painter = painterResource(id = specificLemonade.first),
            contentDescription = "${specificLemonade.first}",
            Modifier.clickable {
                onClick()
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = specificLemonade.second)
    }
}

private val lemonadeMapping: (Int) -> Pair<Int, String> = {
    when (it) {
        1 -> Pair(R.drawable.lemon_tree, "Tap a lemon tree to select a lemon")
        2 -> Pair(R.drawable.lemon_squeeze, "Keep tapping the lemon to squeeze it")
        3 -> Pair(R.drawable.lemon_drink, "Tap the lemonade to drink it")
        else -> Pair(R.drawable.lemon_restart, "Tap the empty glass to start again")
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeAppPreview() {
    FirstComposeAppTheme {
        LemonadeApp()
    }
}