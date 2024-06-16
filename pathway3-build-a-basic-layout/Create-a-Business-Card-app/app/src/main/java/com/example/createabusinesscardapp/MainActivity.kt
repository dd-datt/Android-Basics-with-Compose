package com.example.createabusinesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.createabusinesscardapp.ui.theme.CreateABusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CreateABusinessCardAppTheme {
                CardApp()
            }
        }
    }
}

@Composable
fun CardApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .weight(3f)
                .padding(15.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo_2019),
                
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
            Text(
                text = "Nguyen Van Dat",
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Android Developer",
                fontSize = 20.sp,
                color = Color(0xFF3ddc84)
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(15.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Row {
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = null,
                    tint = Color(0xFF00796B)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "(+84) 397 450 329")
            }

            Row {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null,
                    tint = Color(0xFF00796B)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "vdat319@gmail.com")
            }

            Row {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = null,
                    tint = Color(0xFF00796B)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "@dd_datt")
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CreateABusinessCardAppTheme {
        CardApp()
    }
}