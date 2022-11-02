package edu.ucne.consumiendoapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import dagger.hilt.android.AndroidEntryPoint

import edu.ucne.consumiendoapi.ui.theme.ConsumiendoAPITheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConsumiendoAPITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Mostrar()


                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun Mostrar(){
    
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Lista de imagenes", fontSize = 20.sp)
        LazyColumn( modifier = Modifier.padding(8.dp)){
            item {
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = "https://cdn.pixabay.com/photo/2020/04/12/07/18/post-it-5033079__480.jpg",
                    contentDescription = null
                )
            }
            item {
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = "https://catequesisellimon.files.wordpress.com/2018/03/doc.jpg",
                    contentDescription = null
                )
            }
            item {
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = "https://ci2.ual.es/wp-content/uploads/citar.png",
                    contentDescription = null
                )
            }
            item {
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = "https://static.diariofemenino.com/uploads/amor/174578-mensajes-todos.jpg",
                    contentDescription = null
                )
            }
            item {
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = "https://image.shutterstock.com/image-vector/forgetful-persons-brain-dementia-260nw-1880082937.jpg",
                    contentDescription = null
                )
            }
        }
    }

    
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ConsumiendoAPITheme {
        Greeting("Android")
    }
}