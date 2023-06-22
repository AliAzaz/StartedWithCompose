package com.aliazaz.composeapp.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

@Composable
fun EditableTextView(
    @StringRes text: Int,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions,
    @DrawableRes leadingIcon: Int?
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(text = stringResource(id = text))
        },
        keyboardOptions = keyboardOptions,
        singleLine = true,
        leadingIcon = {
            if (leadingIcon != null)
                Icon(
                    painter = painterResource(id = leadingIcon),
                    contentDescription = leadingIcon.toString()
                )
        }
    )
}