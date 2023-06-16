package com.aliazaz.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aliazaz.composeapp.components.EditableTextView
import com.aliazaz.composeapp.ui.theme.FirstComposeAppTheme

class CalculateTipActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CalculateTip()
                }
            }
        }
    }
}

@Composable
fun CalculateTip() {
    var amount by remember { mutableStateOf("") }
    var tip by remember { mutableStateOf("") }

    val resultAmount = amount.toDoubleOrNull() ?: 0.0
    val resultTip = tip.toDoubleOrNull() ?: 0.0

    val resultantTip = tipCalculator(resultAmount, resultTip)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
            .verticalScroll(rememberScrollState())
    ) {
        EditableTextView(
            text = "Total Amount",
            value = amount,
            onValueChange = { amount = it },
            KeyboardOptions(keyboardType = KeyboardType.Number).copy(
                imeAction = ImeAction.Next
            )
        )

        Spacer(modifier = Modifier.height(5.dp))

        EditableTextView(
            text = "Tip Percentage",
            value = tip,
            onValueChange = { tip = it },
            KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Tip Amount: $${String.format("%.02f", resultantTip)}",
            style = MaterialTheme.typography.h6
        )
    }

}

fun tipCalculator(no1: Double, no2: Double): Double {
    return no1 / 100 * no2
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    FirstComposeAppTheme {
        CalculateTip()
    }
}