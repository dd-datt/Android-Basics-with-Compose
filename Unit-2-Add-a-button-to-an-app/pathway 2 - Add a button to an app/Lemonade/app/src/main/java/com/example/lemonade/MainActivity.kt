package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeTheme() {
    LemonApp()
}

@Composable
fun LemonApp() {
    var currentStep by remember { mutableIntStateOf(1) }
    var squeezeCount by remember { mutableIntStateOf(0) }

    when (currentStep) {
        1 -> {
            LemonTextAndImage(textID = R.string.Lemon_tree,
                imageID = R.drawable.lemon_tree,
                contentDescriptionID = R.string.Lemon_tree,
                onStartClicked = {
                    currentStep = 2
                    squeezeCount = (2..4).random()
                })
        }

        2 -> {
            LemonTextAndImage(textID = R.string.Lemon,
                imageID = R.drawable.lemon_squeeze,
                contentDescriptionID = R.string.Lemon,
                onStartClicked = {
                    squeezeCount--
                    if (squeezeCount == 0) {
                        currentStep = 3
                    }
                })
        }

        3 -> {
            LemonTextAndImage(textID = R.string.Glass_of_lemonade,
                imageID = R.drawable.lemon_drink,
                contentDescriptionID = R.string.Glass_of_lemonade,
                onStartClicked = {
                    currentStep = 4
                }
            )
        }

        4 -> {
            LemonTextAndImage(
                textID = R.string.Empty_glass,
                imageID = R.drawable.lemon_restart,
                contentDescriptionID = R.string.Empty_glass,
                onStartClicked = { currentStep = 1 }
            )


        }

    }


}


@Composable
fun LemonTextAndImage(
    textID: Int,
    imageID: Int,
    contentDescriptionID: Int,
    onStartClicked: () -> Unit,
//    modifier: Modifier = Modifier
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            onClick = onStartClicked,
//            border = ButtonDefaults.outlinedButtonBorder,
//            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
        ) {
            Image(
                painter = painterResource(id = imageID),
                contentDescription = contentDescriptionID.toString()
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = stringResource(id = textID), fontSize = 18.sp)

    }


}