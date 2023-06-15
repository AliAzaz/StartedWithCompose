package com.aliazaz.composeapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * @author AliAzazAlam on 6/15/2023.
 */

@Composable
fun InfoRow(content: String, imageRes: Int) {
    Row {
        Image(
            painter = painterResource(id = imageRes),
            modifier = Modifier.size(25.dp),
            contentDescription = content
        )
        Text(text = content, fontSize = 20.sp, color = Color.Green)
    }
}