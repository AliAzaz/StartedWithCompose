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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aliazaz.composeapp.components.EditableTextView
import com.aliazaz.composeapp.components.ScaffoldComponent
import com.aliazaz.composeapp.components.SwitchComponent
import com.aliazaz.composeapp.ui.theme.FirstComposeAppTheme
import kotlin.math.ceil

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
                    TipCalculatorWithScaffold()
                }
            }
        }
    }
}

@Composable
fun TipCalculatorWithScaffold() {
    ScaffoldComponent(R.string.tip_calculator, modifier = Modifier) {
        CalculateTip()
    }
}

@Composable
fun CalculateTip() {
    var amount by remember { mutableStateOf("") }
    var tip by remember { mutableStateOf("") }
    var tipSwitchChecked by remember { mutableStateOf(false) }

    val resultAmount = amount.toDoubleOrNull() ?: 0.0
    val resultTip = tip.toDoubleOrNull() ?: 0.0

    val resultantTip = tipCalculator(resultAmount, resultTip, tipSwitchChecked)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
            .verticalScroll(rememberScrollState())
    ) {
        EditableTextView(
            text = R.string.total_amount,
            value = amount,
            onValueChange = { amount = it },
            KeyboardOptions(keyboardType = KeyboardType.Number).copy(
                imeAction = ImeAction.Next
            ),
            R.drawable.ic_money
        )

        Spacer(modifier = Modifier.height(5.dp))

        EditableTextView(
            text = R.string.tip_percentage,
            value = tip,
            onValueChange = { tip = it },
            KeyboardOptions(keyboardType = KeyboardType.Number),
            null
        )

        Spacer(modifier = Modifier.height(5.dp))

        SwitchComponent(
            text = R.string.round_trip_check,
            value = tipSwitchChecked,
            onChange = { tipSwitchChecked = it },
            modifier = Modifier
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = stringResource(id = R.string.tip_amount, resultantTip),
            style = MaterialTheme.typography.h6
        )
    }

}

@Preview(showBackground = true)
@Composable
fun TipCalculatorWithScaffoldPreview() {
    FirstComposeAppTheme {
        TipCalculatorWithScaffold()
    }
}

/*
* Calculate Tip
* */
private fun tipCalculator(no1: Double, no2: Double, tipSwitchChecked: Boolean): Double {
    val resTip = no1 / 100 * no2
    return if (tipSwitchChecked) ceil(resTip) else resTip
}