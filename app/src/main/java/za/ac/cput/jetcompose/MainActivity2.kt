package za.ac.cput.jetcompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {shoIntro()

        }
    }
}
@Composable
@Preview
fun shoIntro(){

    val mainContext =LocalContext.current
   Column(
       modifier = Modifier.fillMaxSize(),
       horizontalAlignment = Alignment.Start,
       verticalArrangement = Arrangement.Top
   )
   {
       Button(onClick = { mainContext.startActivity(Intent(mainContext,
           MainActivity::class.java)) },
           colors =ButtonDefaults.buttonColors(backgroundColor = Color.Black),
            border = BorderStroke(2.dp,Color.Magenta),
            modifier = Modifier.padding(7.dp)) {
           Text(text="Back",color = Color.White)
       }
   }
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
            ){
        Button(onClick ={},
            colors = ButtonDefaults.buttonColors(backgroundColor =Color.Black),
             border = BorderStroke(2.dp,Color.Magenta),
              modifier = Modifier.padding(7.dp)) {
            Text(text = "Current Modules",color = Color.White)
        }
        Text(text="")
        Text(text = " NAME  NONDUMISO GAGA",color = Color.Black)
        Text(text="COURSE Diploma in ICT in Applications Development",color = Color.Black)
        Text(text= "STUDENT NUMBER  22043053",color = Color.Black)
    }
}
