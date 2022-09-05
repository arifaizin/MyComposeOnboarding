package com.dicoding.mycomposeonboarding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dicoding.mycomposeonboarding.ui.theme.MyComposeOnboardingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeOnboardingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    OnboardingScreen()
                }
            }
        }
    }
}

@Composable
fun OnboardingScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .clip(
                    shape = RoundedCornerShape(
                        bottomStart = 25.dp,
                        bottomEnd = 25.dp
                    )
                )
                .background(MaterialTheme.colors.primary)

        ) {
            Image(
                painter = painterResource(R.drawable.background_coffee_shop),
                contentScale = ContentScale.Crop,
                alpha = 0.5f,
                contentDescription = null,
                modifier = Modifier.matchParentSize()
            )
        }

        Card(
            modifier = Modifier
                .height(350.dp)
                .offset(y = -40.dp)
                .width(300.dp),
            shape = RoundedCornerShape(25.dp),
            elevation = 15.dp
        ) {
            Column(
                modifier = Modifier.padding(16.dp).fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(R.drawable.avatar1),
                    contentDescription = "Avatar",
                    modifier = Modifier
                        .padding(6.dp)
                        .border(3.dp, MaterialTheme.colors.primary, CircleShape)
                        .clip(CircleShape)
                        .size(120.dp)

                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Hello!",
                    style = MaterialTheme.typography.h6,
                )
                Text(
                    text = "A good day starts with a good Coffee. Find the best high quality coffee today!",
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {},
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colors.primary)
                ) {
                    Text("Get started now")
                }
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_3)
@Composable
fun OnboardingScreenPreview() {
    MyComposeOnboardingTheme {
        OnboardingScreen()
    }
}