package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
            }
        }
    }
}

@Composable
fun App() {
    Column (modifier = Modifier.fillMaxWidth()){
        Row(
            modifier = Modifier.weight(1f)
        ) {
            CardInformation(
                title = stringResource(id = R.string.text_composable),
                descrip = stringResource(id = R.string.sub_txt1),
                backgr = Color(0xFFEADDFF), modifier = Modifier.weight(1f)

            )
            CardInformation(
                title = stringResource(id = R.string.image_composable),
                descrip = stringResource(id = R.string.sub_image),
                backgr = Color(0xFFD0BCFF), modifier = Modifier.weight(1f)
            )
        }

        Row(
            modifier = Modifier.weight(1f)
        ) {
            CardInformation(
                title = stringResource(id = R.string.column_composable),
                descrip = stringResource(id = R.string.sub_column),
                backgr = Color(0xFFD0BCFF), modifier = Modifier.weight(1f)

            )
            CardInformation(
                title = stringResource(id = R.string.row_composable),
                descrip = stringResource(id = R.string.sub_row),
                backgr = Color(0xFFEADDFF), modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun CardInformation(
    title: String,
    descrip: String,
    backgr: Color,
    modifier: Modifier= Modifier
) {
    Column(
        modifier = modifier            .fillMaxSize()
            .background(backgr)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(text = descrip)
    }


}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        App()
    }
}