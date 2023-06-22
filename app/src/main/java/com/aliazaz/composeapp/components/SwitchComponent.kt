package com.aliazaz.composeapp.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun SwitchComponent(
    @StringRes text: Int,
    value: Boolean,
    onChange: (Boolean) -> Unit,
    modifier: Modifier
) {
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = stringResource(id = text), modifier = Modifier.padding(end = 5.dp))
        Switch(
            checked = value,
            onCheckedChange = onChange,
            modifier = modifier
        )
    }
}