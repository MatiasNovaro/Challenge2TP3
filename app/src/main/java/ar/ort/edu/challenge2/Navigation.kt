package ar.ort.edu.challenge2

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import ar.ort.edu.challenge2.ui.Screen
import ar.ort.edu.challenge2.ui.screens.FavouritesScreen
import ar.ort.edu.challenge2.ui.screens.ProductListScreen
import ar.ort.edu.challenge2.ui.screens.ProductScreen
import ar.ort.edu.challenge2.ui.screens.ProfileScreen
import ar.ort.edu.challenge2.ui.screens.SettingsScreen


@Composable
fun Navigation(navController: NavHostController, onDestinationChanged: (String) -> Unit){
    LaunchedEffect(navController) {
        navController.currentBackStackEntryFlow.collect { backStackEntry ->
            when (backStackEntry.destination.route) {
                Screen.ShopScreen.route -> onDestinationChanged("Shop")
                Screen.ProductScreen.route -> onDestinationChanged("Product")
                Screen.FavouritesScreen.route -> onDestinationChanged("Favourites")
                Screen.SettingsScreen.route -> onDestinationChanged("Settings")
                Screen.ProfileScreen.route->  onDestinationChanged("Profile")
            }
        }
    }
    NavHost(navController = navController, startDestination = Screen.ShopScreen.route, modifier = Modifier.background(
        Color.Red)){
        composable(route=Screen.ShopScreen.route){
            ProductListScreen(navController= navController )
        }
        composable(route=Screen.ProductScreen.route){
            ProductScreen(navController= navController )
        }
        composable(route=Screen.FavouritesScreen.route){
           FavouritesScreen(navController= navController)
        }
        composable(route=Screen.SettingsScreen.route){
            SettingsScreen(navController= navController)
        }
        composable(route=Screen.ProfileScreen.route){
            ProfileScreen(navController= navController)
        }
    }
}