package ar.ort.edu.challenge2.ui.Drawer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ar.ort.edu.challenge2.R
import ar.ort.edu.challenge2.ui.Screen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun DrawerContent(
    navController: NavController,
    drawerState: DrawerState,
    scope: CoroutineScope
) {
    val drawerItems = listOf(
        DrawerItem(stringResource(R.string.shop_list), Icons.Default.ShoppingCart, Screen.ShopScreen.route),
        DrawerItem(stringResource(R.string.favourites), Icons.Default.Favorite, Screen.FavouritesScreen.route),
        DrawerItem(stringResource(R.string.profile1), Icons.Default.Person, Screen.ProfileScreen.route),
        DrawerItem(stringResource(R.string.settings), Icons.Default.Settings, Screen.SettingsScreen.route)
    )

    val currentDestination = navController.currentBackStackEntryAsState().value?.destination

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFCFCFC))
            .padding(vertical = 36.dp),
        tonalElevation = 4.dp
    ) {
        Column {
            Text(
                text = "Title",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(start = 20.dp, bottom = 24.dp)
            )

            DrawerItemSection(
                navController = navController,
                drawerState = drawerState,
                scope = scope,
                drawerItems = drawerItems,
                sectionHeader = stringResource(R.string.section_header),
                currentRoute = currentDestination?.route
            )
        }
    }
}

@Composable
fun DrawerItemSection(
    navController: NavController,
    drawerState: DrawerState,
    scope: CoroutineScope,
    drawerItems: List<DrawerItem>,
    sectionHeader: String,
    currentRoute: String?
) {
    Column {
        Text(
            text = sectionHeader,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(start = 20.dp, bottom = 12.dp)
        )

        drawerItems.forEach { item ->
            val isSelected = currentRoute == item.route
            NavigationDrawerItem(
                label = { Text(item.label) },
                icon = { Icon(item.icon, contentDescription = null) },
                selected = isSelected,
                onClick = {
                    navController.navigate(item.route)
                    scope.launch { drawerState.close() }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                colors = NavigationDrawerItemDefaults.colors(
                    unselectedContainerColor = Color.Transparent,
                    selectedContainerColor = Color(0xFFFFDBCD), // Red color
                )
            )
        }
    }
}



@Preview
@Composable
fun DrawerContentPreview(){
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    DrawerContent(
        navController = navController,
        drawerState = drawerState,
        scope = scope
    )
}