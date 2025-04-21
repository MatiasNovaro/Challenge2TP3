package ar.ort.edu.challenge2.ui

sealed class Screen(val route: String) {
    data object ShopScreen : Screen("shop_screen")
    data object ProductScreen : Screen("product_screen")
    data object FavouritesScreen : Screen("favourites_screen")
    data object SettingsScreen : Screen("settings_screen")
    data object ProfileScreen : Screen("profile_screen")
}