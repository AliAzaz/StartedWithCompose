package com.aliazaz.composeapp.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable

@Composable
fun EditableTextView(
    text: String,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(text = text)
        },
        keyboardOptions = keyboardOptions,
        singleLine = true
    )
}