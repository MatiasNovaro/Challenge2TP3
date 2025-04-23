package ar.ort.edu.challenge2.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ar.ort.edu.challenge2.R
import ar.ort.edu.challenge2.ui.components.AppButton
import ar.ort.edu.challenge2.ui.components.HorizontalItemCard

@Composable
fun FavouritesScreen(navController: NavController) {
    // Simulación de datos
    val favourites = remember {
        List(10) {
            Triple("Título $it", "Subtítulo de ejemplo", it + 1)
        }
    }

    val image = painterResource(id = R.drawable.leather_boots) // Reemplazalo con tu imagen

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        itemsIndexed(favourites) { index, (title, subtitle, number) ->
            HorizontalItemCard(
                itemNumber = number,
                title = title,
                subtitle = subtitle,
                imagePainter = image,
                modifier = Modifier.fillMaxWidth()
            )
        }

        item {
            // Botón final
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                AppButton(
                    onClick = { /* Acción agregar más */ },
                    text = stringResource(R.string.buyMas),
                ) 
            }
        }
    }
}

@Preview
@Composable
fun FavouritesScreenPreview(){
}

