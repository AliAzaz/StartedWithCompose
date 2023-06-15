package com.aliazaz.composeapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aliazaz.composeapp.ui.theme.FirstComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android") {
                        Toast.makeText(this, "hello", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, content: () -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    /*Surface(color = Color.Cyan) {
        Text(text = "Hello $name!", color = Color.Blue)
    }*/
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Image here",
            modifier = Modifier.apply {
                width(10.dp)
                height(10.dp)
            }
        )
        Text(
            text = "Hello $name!", color = Color.Blue,
            modifier = Modifier.padding(5.dp)
        )
        Button(onClick = { expanded = !expanded }) {
            Text(text = if (expanded) "Show Less" else "Show More")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FirstComposeAppTheme {
        Greeting("Android") {
            Log.e("click", "clicking")
        }
    }
}