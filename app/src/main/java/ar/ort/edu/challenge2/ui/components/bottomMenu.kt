package ar.ort.edu.challenge2.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import ar.ort.edu.challenge2.R
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CustomBottomBar(
    selectedItem: String,
    onItemSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val navItems = listOf("Product", "Search", "Cart", "Profile")
    val icons = listOf(
        R.drawable.ic_product,
        R.drawable.ic_search,
        R.drawable.ic_shopping_cart,
        R.drawable.ic_person
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(135.dp)
            .navigationBarsPadding()
            .background(Color.Transparent)
    ) {
        // Background image
        Image(
            painter = painterResource(id = R.drawable.subtract),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .width(428.dp)
                .align(Alignment.BottomCenter)
                .background(color = Color.Transparent),
            contentScale = ContentScale.FillBounds
        )

        // Bottom Navigation
        NavigationBar(
            containerColor = Color.Transparent,
            tonalElevation = 0.dp,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(color = Color.Transparent),
            windowInsets = WindowInsets(0)
        ) {
            navItems.take(2).forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = selectedItem == item,
                    onClick = { onItemSelected(item) },
                    icon = {
                        Icon(
                            painter = painterResource(id = icons[index]),
                            contentDescription = item
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.Transparent // <- prevents selection background
                    ),
                    label = { Text(text = item, fontSize = 12.sp) },
                    alwaysShowLabel = true
                )
            }

            Spacer(modifier = Modifier.width(64.dp)) // Space for FAB

            navItems.drop(2).forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = selectedItem == item,
                    onClick = { onItemSelected(item) },
                    icon = {
                        Icon(
                            painter = painterResource(id = icons[index + 2]),
                            contentDescription = item
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.Transparent // <- prevents selection background
                    ),
                    label = { Text(text = item, fontSize = 12.sp) },
                    alwaysShowLabel = true
                )
            }
        }

        // Floating Action Button
        FloatingActionButton(
            onClick = { onItemSelected("Store") },
            shape = CircleShape,
            containerColor = Color(0xFF9A4521),
            elevation = FloatingActionButtonDefaults.elevation(8.dp),
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = (-15).dp)
                .size(64.dp),
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_storefront),
                contentDescription = "Store",
                modifier = Modifier.size(28.dp)
            )
        }
    }
}




@Preview(showBackground = false)
@Composable
fun BottomManuPreview() {
    val selectedItem = remember { mutableStateOf("Product") }
    CustomBottomBar(
        selectedItem = selectedItem.value,
        onItemSelected = { selectedItem.value = it }
    )
}