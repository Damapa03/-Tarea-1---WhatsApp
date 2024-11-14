package com.example.whatsapp2

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapp2.ui.theme.WhatsApp2Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WhatsApp2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                    contacts(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column(
        Modifier
            .fillMaxSize()){
            menu(modifier)
            for (i in 1..10){
                contacts(modifier)
            }
        }
}
@Preview
@Composable
fun menu(modifier: Modifier = Modifier){
        Box(
            Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(color = colorResource(id = R.color.green_whatsapp))
        ) {
            Column (Modifier
                    .fillMaxWidth()
                .fillMaxHeight(), Arrangement.Center){
                Row(){
                    Box(Modifier.padding(start = 20.dp).weight(3F)) {
                        Text(stringResource(R.string.app_name), color = Color.White, fontWeight = FontWeight.Bold)
                    }
                    Row(Modifier.weight(1f), Arrangement.SpaceAround){
                        Image(
                            painter = painterResource(id = R.drawable.photo_camera),
                            contentDescription = null)
                        Icon(
                            Icons.Rounded.Search,
                            contentDescription = stringResource(id = R.string.app_name),
                            tint = Color.White
                        )
                        Image(
                            painter = painterResource(id = R.drawable.more_vert),
                            contentDescription = stringResource(id = R.string.app_name)
                        )
                    }
                }
            }
        }
}

@Preview
@Composable
fun contacts(modifier: Modifier = Modifier){
    Box(
        Modifier
            .height(100.dp)
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.chat))) {
        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(), Arrangement.Center) {
            Row(Modifier.padding(start = 20.dp)) {
                Box(Modifier){
                    Icon(Icons.Rounded.AccountCircle, contentDescription = null, Modifier.size(50.dp))
                }
                Box(Modifier.padding(start = 20.dp)){
                    Text(stringResource(id = R.string.nombre), fontWeight = FontWeight.Bold, fontSize = 20.sp)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WhatsApp2Theme {
        Greeting()
    }
}
