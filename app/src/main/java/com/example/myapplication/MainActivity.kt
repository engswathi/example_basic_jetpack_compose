package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
               var name by remember {
                   mutableStateOf("")
               }
                
                var names by remember {
                    mutableStateOf(listOf<String>())
                }
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)) {

                    Row (modifier = Modifier.fillMaxSize()){

                        OutlinedTextField(value = name, onValueChange ={ text->
                            name = text
                        } )

                     Button(onClick = {

                         if(name.isNotBlank()){

                             Log.e("Button Clicked",name)
                            names = names + name
                         }


                     }) {
                         Text(text = "Add")
                     }
                    }

                    LazyColumn(){

                        items(names){currentName -> Text(text = currentName)
                        }
                    }


                }

                }
            }
        }
    }

