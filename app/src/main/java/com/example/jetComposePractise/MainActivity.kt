@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.jetComposePractise


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.example.jetComposePractise.custom.MyCustomCard
import com.example.jetComposePractise.custom.Publisher
import com.example.myapplication.R

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)

    val viewModel by lazy { ViewModelProvider(this)[MainViewModel::class.java] }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            Greeting1(name = "new func")
//            Icon(painterResource(id =R.drawable.baseline_1k_plus_24 ),contentDescription = null, tint = Color.Yellow)
//            Image(painterResource(id = R.drawable.baseline_1k_plus_24),contentDescription = null)
//            TextField(value = "", onValueChange ={},label={} )
//            FloatingActionButton(onClick = { /*TODO*/ }) {
//                Icon(painter = painterResource(id = R.drawable.baseline_1k_plus_24), contentDescription = null, tint= Color.Blue)
//
//            }
//            ExtendedFloatingActionButton(onClick = { /*TODO*/ }) {
//                Text(text = "Extented Floating action button")
//                Icon(painter = painterResource(id = R.drawable.baseline_1k_plus_24), contentDescription = null, tint = Color.Green)
//            }


            Column(modifier = Modifier.fillMaxSize()) {
//                MyTextFiledSFall()
//                var textState by remember {
//                    mutableStateOf("")
//                }
//                can substain rotation
//                var textState by rememberSavable {
//                    mutableStateOf("")
//                }
//                val nameListState= remember {
//                    mutableListOf<String>()
//                }
                val state=viewModel.state.value
                LazyColumn(modifier = Modifier
                    .fillMaxWidth()
                    .weight(3f)){
                 items(state.nameList.size) { Text(text = state.nameList[it]) }
                }
//                Spacer(modifier = Modifier.weight(1f))

                MyTextFiledSLess(state.text, onValueChanged = {
                    viewModel.updateText(it)
                }, onAddClick = {
                    viewModel.updateText(state.text)
                    viewModel.updateText("")

                })

            }

            Box (modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                val annotatedString:AnnotatedString= buildAnnotatedString {
                    blueGradientText("Blue")
                    append(" ")
                    blueGradientText("djfghksjd")
                }
                Text(text = annotatedString)
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background (Color.Black.copy (alpha = 0.8f)),
                contentAlignment = Alignment. Center
            ) {
                MyCustomCard (
                    modifier = Modifier.fillMaxWidth (fraction =0.8f),
                    image = R.drawable.baseline_1k_plus_24,
                    title = "Shadows & Lightnings",
                    text = "Create subtle and stunning UI designs with this tips using Jetpack Compose, The new UI Toolkit for building UI in Android",
                    publisher = Publisher (
                        name = "Mohammad Nawas",
                        job = "Android Developer",
                        image = R.drawable.baseline_1k_plus_24))
            }

        }


    }

    @Composable
    fun Greeting1(name: String) {
        Text(text = "trying${name}", fontSize = 22.sp)
    }

    //state fall is the composable whoich manges its own state
    @Composable
    fun MyTextFiledSFall() {
        var textState by remember {
            mutableStateOf("")
        }
        TextField(value = textState, onValueChange = {
            textState = it
        })
    }

    @Composable
    fun MyTextFiledSLess(
        textValue: String,
        onValueChanged: (String) -> Unit,
        onAddClick: () -> Unit
    ) {

        TextField(value = textValue, onValueChange = {
            onValueChanged(it)
        },
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    modifier = Modifier.clickable { onAddClick() })
            })

    }

    @Composable
    fun myText() {

        Text(
            text = "Land of coding",
            color = Color.Magenta,
            fontSize = 32.sp,
            textDecoration = TextDecoration.Underline,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }




    @OptIn(ExperimentalTextApi::class)
    private fun AnnotatedString.Builder.blueGradientText(text:String) {
        withStyle(
            style = SpanStyle(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF278807),
                        Color(0xFF00BBD4))),
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium
            )
        ) {
            append(text)
        }
    }

}





