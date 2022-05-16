package za.ac.cput.jetcompose

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.font.FontWeight
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import za.ac.cput.jetcompose.ui.theme.JetcomposeTheme
import kotlin.system.exitProcess

class MainActivity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            showModules()


        }
    }
}

@Composable
@Preview
 fun showModules() {
    val visible: MutableState<Boolean> = remember {mutableStateOf(false)}
   showDialog(visible = visible)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally

     ){
        Text(text="2022 CURRENT MODULES\n",color = Color.Magenta,fontWeight = FontWeight.Bold)
         Text(text="Applications Development Practise 3")
         Text(text="Type:Practical  Duration: All year round\n")
        Text(text="ICT Electives Mobile Programming2")
        Text(text="Type:Practical  Duration:Semester\n")
        Text(text="Project Management 3")
        Text(text="Type:Theory  Duration: All year round\n")
        Text(text="Project 3")
        Text(text="Type:Practical  Duration: All year round\n")
        Text(text="Professional Practise 3")
        Text(text="Type:Theory  Duration: All year round\n")
        Text(text="Information Systems 3")
        Text(text="Type:Practical  Duration: All year round\n")
        Text(text="ICT Electives Mobile Programming2")
        Text(text="Type:Practical  Duration:Semester\n")
        Text(text="Applications Development Theory 3")
        Text(text="Type:Theory  Duration: All year round")

         }


    val mainContext = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Bottom
    ){
        Button(onClick ={mainContext.startActivity(
            Intent(mainContext,
            MainActivity2::class.java)
        )},
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
            border = BorderStroke(2.dp, Color.Magenta),
            modifier = Modifier.padding(7.dp)) {
            Text(text = "Back",color = Color.White)
        }
    }
    
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Bottom
    ){
        Button(onClick ={visible.value = true},
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
            border = BorderStroke(2.dp, Color.Magenta),
            modifier = Modifier.padding(7.dp)) {
            Text(text = "Goodbye!",color = Color.White)
        }
    }

}
@Composable
fun showDialog(visible: MutableState<Boolean>) {
    if(visible.value){
        AlertDialog(
            onDismissRequest = { visible.value= false },dismissButton = {
                TextButton(onClick = { visible.value=false }) {
                    Text(text= "No")

                }}, confirmButton = {TextButton(onClick = {  exitProcess(0)}) {
                Text(text= "Yes")

            }},
            title= { Text(text = "Warning")},
            text={Text (text="Leaving now?")})
}}

