package com.aliazaz.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aliazaz.composeapp.components.InfoRow
import com.aliazaz.composeapp.model.VCardModel
import com.aliazaz.composeapp.ui.theme.FirstComposeAppTheme

class VCardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val vcard = VCardModel(
                        "Ali Azaz Alam",
                        "Android Engineer",
                        "+92-(345)3320212",
                        "@AliAzazAlam1",
                        "ali.azaz.alam@hotmail.com"
                    )
                    VCardApp(vcard)
                }
            }
        }
    }
}

@Composable
fun VCardApp(vCardModel: VCardModel) {
    Column(
        modifier = Modifier.padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(modifier = Modifier.background(Color.Black)) {
            Image(
                painter = painterResource(id = R.drawable.ic_cake),
                modifier = Modifier.size(25.dp),
                contentDescription = "Picture"
            )
        }
        Text(
            text = vCardModel.name,
            style = MaterialTheme.typography.h6,
            color = Color.DarkGray
        )
        Text(text = vCardModel.tagLine, fontSize = 20.sp, color = Color.Green)


        Spacer(modifier = Modifier.padding(30.dp))

        InfoRow(content = vCardModel.phone, imageRes = R.drawable.ic_phone)
        InfoRow(content = vCardModel.social, imageRes = R.drawable.ic_share)
        InfoRow(content = vCardModel.email, imageRes = R.drawable.ic_email)

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    FirstComposeAppTheme {
        val vcard = VCardModel(
            "Ali Azaz Alam",
            "Android Engineer",
            "+92-(345)3320212",
            "@AliAzazAlam1",
            "ali.azaz.alam@hotmail.com"
        )
        VCardApp(vcard)
    }
}