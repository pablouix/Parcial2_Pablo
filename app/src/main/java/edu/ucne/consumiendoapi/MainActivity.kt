package edu.ucne.consumiendoapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.consumiendoapi.remota.dto.Verbos

import edu.ucne.consumiendoapi.ui.theme.ConsumiendoAPITheme

@AndroidEntryPoint
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
fun Mostrar(
    verbosView: ViewModelVerbos = hiltViewModel()
){

    val list by verbosView._uiState.collectAsState()


    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Listar de Verbos", fontSize = 28.sp)
        LazyColumn( modifier = Modifier.padding(8.dp)){


            items(list.verbos) {

                    AsyncImage(
                        modifier = Modifier.fillMaxSize(),
                        model = it.Imagen,
                        contentDescription = null
                    )
                    Text(text = "Verbo: "+it.Verbo)
                    Text(text = "Categoria: "+it.Categoria)
                    Text(text = "Nivel: "+it.Nivel)

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