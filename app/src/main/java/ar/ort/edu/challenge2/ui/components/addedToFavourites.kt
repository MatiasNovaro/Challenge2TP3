package ar.ort.edu.challenge2.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import ar.ort.edu.challenge2.R

@Composable
fun AddedToFavouritesDialog(
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(24.dp),
            color = Color(0xFFF6EDE7) // Background similar to the design
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .width(312.dp)
                    .height(289.dp)
            ) {
                // 🟢 Centered Icon + Title
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        Icons.Default.ThumbUp,
                        contentDescription = null,
                        tint = Color(0xFF944323), // Optional: style it
                        modifier = Modifier.size(35.dp)
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        stringResource(R.string.added_to_favourites),
                        style = MaterialTheme.typography.headlineSmall,
                        color = Color(0xFF1A1A1A)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Subtitle
                Text(
                    stringResource(R.string.now_you_can_find_this_product_at_item_favourites),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.DarkGray
                )

                Spacer(modifier = Modifier.weight(1f)) // Push footer to the bottom

                // Footer buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        stringResource(R.string.back),
                        color = Color(0xFF944323),
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier.clickable { onDismiss() }
                    )
                    Spacer(modifier = Modifier.width(30.dp))
                    Text(
                        stringResource(R.string.dismiss),
                        color = Color(0xFF944323),
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier.clickable { onDismiss() }
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun AddedToFavouritesPreview(){
    var showDialog by remember { mutableStateOf(false) }
    AddedToFavouritesDialog(
        onDismiss = { showDialog = false }
    )
}