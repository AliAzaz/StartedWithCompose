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
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aliazaz.composeapp.model.BirthdayCardModel
import com.aliazaz.composeapp.ui.theme.FirstComposeAppTheme

class BirthdayCardActivity : ComponentActivity() {

    private val birthdayModel = BirthdayCardModel(
        "Happy Birthday", "John", "Ali"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    BirthdayCard(birthdayModel)
                }
            }
        }
    }
}

@Composable
fun BirthdayCard(birthdayCardModel: BirthdayCardModel) {
    Box(
        modifier = Modifier
            .padding(0.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "${birthdayCardModel.message} ${birthdayCardModel.birthdayPersonName}!",
                color = Color.Magenta,
                modifier = Modifier
                    .padding(top = 10.dp, start = 20.dp, end = 20.dp, bottom = 0.dp),
                style = MaterialTheme.typography.h4
            )
            Text(
                text = "-from ${birthdayCardModel.fromName}!",
                color = Color.Black,
                modifier = Modifier
                    .padding(top = 10.dp, start = 20.dp, end = 20.dp, bottom = 0.dp),
                style = MaterialTheme.typography.body1
            )
            Spacer(modifier = Modifier.padding(30.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_cake),
                contentDescription = stringResource(
                    id = R.string.happy_birthday_image
                ),
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .size(100.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    FirstComposeAppTheme {
        BirthdayCard(
            BirthdayCardModel(
                "Happy Birthday", "John", "Ali"
            )
        )
    }
}