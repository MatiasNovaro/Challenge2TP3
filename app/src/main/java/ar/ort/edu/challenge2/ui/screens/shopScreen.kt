package ar.ort.edu.challenge2.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ar.ort.edu.challenge2.R
import ar.ort.edu.challenge2.ui.components.AddedToFavouritesDialog
import ar.ort.edu.challenge2.ui.components.CustomCard
import ar.ort.edu.challenge2.ui.orderList.OrderListDialog

@Composable
fun ProductListScreen(navController: NavController) {
    // Example dummy data
    val products = listOf(
        Triple("Title 1", "Subtitle 1", "Description 1"),
        Triple("Title 2", "Subtitle 2", "Description 2"),
        Triple("Title 3", "Subtitle 3", "Description 3"),
        Triple("Title 4", "Subtitle 4", "Description 4"),
        Triple("Title 5", "Subtitle 5", "Description 5")
    )
    val showFavouriteDialog = remember { mutableStateOf(false) }

    // Screen content
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), // Optional padding
        verticalArrangement = Arrangement.spacedBy(16.dp) // Space between cards
    ) {
        items(products) { (title, subtitle, description) ->

            CustomCard(
                title = title,
                subtitle = subtitle,
                description = description,
                imageRes = R.drawable.leather_boots, // Replace with your image
                onAppButtonClick = { /* handle Buy */ },
                onAppOutLinedButtonClick = { showFavouriteDialog.value = true }
            )
        }

    }
    if (showFavouriteDialog.value) {
        AddedToFavouritesDialog(
            onDismiss = { showFavouriteDialog.value = false }
        )

    }
}