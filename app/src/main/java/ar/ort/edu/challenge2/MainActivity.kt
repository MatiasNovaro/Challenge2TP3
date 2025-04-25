package ar.ort.edu.challenge2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import androidx.navigation.compose.rememberNavController
import ar.ort.edu.challenge2.ui.Drawer.DrawerContent
import ar.ort.edu.challenge2.ui.Screen
import ar.ort.edu.challenge2.ui.components.ChatManagerDialog
import ar.ort.edu.challenge2.ui.components.CustomBottomBar
import ar.ort.edu.challenge2.ui.components.CustomTopBar
import ar.ort.edu.challenge2.ui.orderList.OrderListDialog
import ar.ort.edu.challenge2.ui.theme.Challenge2Theme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Challenge2Theme {
                val selectedItem = remember { mutableStateOf("Product") }
                val showCartDialog = remember { mutableStateOf(false) }
                val showChatManagerDialog = remember { mutableStateOf(false) }
                val currentTitle = remember { mutableStateOf("Shop") }
                val drawerState = rememberDrawerState(DrawerValue.Closed)
                val scope = rememberCoroutineScope()
                val navController = rememberNavController()

                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        DrawerContent(
                            navController = navController,
                            drawerState = drawerState,
                            scope = scope
                        )
                    }
                ) {
                    Scaffold(
                        modifier = Modifier.background(Color.Blue),
                        topBar = {
                            CustomTopBar(
                                title = currentTitle.value,
                                onMenuClick = { scope.launch { drawerState.open() } },
                                onProfileClick = { navController.navigate(Screen.ProfileScreen.route) }
                            )
                        },
                        bottomBar = {
                            CustomBottomBar(
                                modifier = Modifier.background(color = Color.Blue),
                                selectedItem = selectedItem.value,
                                onItemSelected = {
                                    selectedItem.value = it
                                    when (it) {
                                        "Product" -> navController.navigate(Screen.ShopScreen.route)
                                        "Cart" -> showCartDialog.value = true
                                        "Search" -> navController.navigate(Screen.ProductScreen.route)
                                        "Profile" -> navController.navigate(Screen.ProfileScreen.route)
                                        "Store" ->  showChatManagerDialog.value = true
                                    }
                                }
                            )
                        }
                    )
                    { innerPadding ->
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
                    if (showCartDialog.value) {
                        OrderListDialog(
                            onDismiss = { showCartDialog.value = false },
                            onBuyClick = {}
                        )
                    }
                    if (showChatManagerDialog.value) {
                        ChatManagerDialog(
                            onDismiss = { showChatManagerDialog.value = false },
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