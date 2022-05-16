/*
Nondumiso Gaga (220430853)

 */
package za.ac.cput.jetcompose


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily.Companion.Cursive
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import za.ac.cput.jetcompose.ui.theme.JetcomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     setContent{ ScreenText()}
    }}


@Composable
@Preview
fun ScreenText() {
    val visible: MutableState<Boolean> = remember { mutableStateOf(false) }
    ShowDialog(visible = visible)
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            "Welcome to my jetpack compose journey",
            color = Color.Magenta, fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { visible.value = true })
        {
            Icon(
                imageVector = Icons.Filled.Info,
                contentDescription = null,
                Modifier.padding(end = 9.dp)
            )
            Text(text = " Info")
        }
    }
    val mainContext = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(
            onClick = { mainContext.startActivity(Intent(mainContext, MainActivity2::class.java)) },
            colors =
            ButtonDefaults.buttonColors(backgroundColor = Color.Black),
            border = BorderStroke(2.dp, Color.Magenta)
        ) {
            Text(text = "Start Journey", color = Color.White)
        }
    }
}


@Composable
fun ShowDialog(visible:MutableState<Boolean>){
    if(visible.value){
        AlertDialog(
            onDismissRequest = { visible.value= false },dismissButton = {
            TextButton(onClick = { visible.value=false }) {
                Text(text= "Cancel")

        }},confirmButton={TextButton(onClick = { visible.value=false }) {
                Text(text= "OK")

            }},
            title= { Text(text = "My jetpack Journey")},
            text={Text (text="This is my first jetpack compose application, I am hoping that with more practice i will buil a much better application and will improve :)")}
        )
        }
    }


