package ar.ort.edu.challenge2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import ar.ort.edu.challenge2.ui.Screen
import ar.ort.edu.challenge2.ui.components.CustomBottomBar
import ar.ort.edu.challenge2.ui.components.CustomTopBar
import ar.ort.edu.challenge2.ui.screens.ProductListScreen
import ar.ort.edu.challenge2.ui.theme.Challenge2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Challenge2Theme {
                val selectedItem = remember { mutableStateOf("Product") }
                val currentTitle = remember { mutableStateOf("Home") }
                val navController = rememberNavController()
                Scaffold(
                    topBar = {
                        CustomTopBar(
                            title = currentTitle.value,
                            onMenuClick = { /* Open drawer or show toast */ },
                            onProfileClick = { navController.navigate(Screen.ProfileScreen.route) }
                        )
                    },
                    bottomBar = {CustomBottomBar(
                        selectedItem = selectedItem.value,
                        onItemSelected = { selectedItem.value = it
                            when (it) {
                                "Product" -> navController.navigate(Screen.ShopScreen.route)
                                "Cart"-> navController.navigate(Screen.ProductScreen.route)
                                "Search"-> navController.navigate(Screen.FavouritesScreen.route)
                                "Profile" -> navController.navigate(Screen.SettingsScreen.route)
                            }
                        }
                    ) }
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Navigation(
                            onDestinationChanged = { title -> currentTitle.value = title },
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Challenge2Theme {
        Greeting("Android")
    }
}