package ar.ort.edu.challenge2.ui.Drawer

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

data class DrawerItem(val label: String, val icon: ImageVector, val route: String)

val drawerItems = listOf(
    DrawerItem("Home", Icons.Default.ShoppingCart, "shop_list"),
    DrawerItem("Profile", Icons.Default.Favorite, "favourites"),
    DrawerItem("Settings", Icons.Default.Person, "profile"),
    DrawerItem("Logout", Icons.Default.Settings, "settings")
)
