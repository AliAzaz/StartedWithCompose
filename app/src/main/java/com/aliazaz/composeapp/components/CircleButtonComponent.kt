package com.aliazaz.composeapp.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CircleButtonComponent(buttonText: String, click: () -> Unit) {
    Button(
        onClick = click,
        shape = CircleShape,
        contentPadding = PaddingValues(5.dp),
        modifier = Modifier.width(130.dp),
    ) {
        Text(text = buttonText)
    }
}