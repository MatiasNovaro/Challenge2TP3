package ar.ort.edu.challenge2.ui.orderList

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.HorizontalDivider
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
fun OrderListDialog(
    onDismiss: () -> Unit,
    onBuyClick: () -> Unit
) {
    val items = listOf(
        OrderItem(stringResource(R.string.leather_boots)),
        OrderItem(stringResource(R.string.sneakers)),
        OrderItem(stringResource(R.string.yellow_slippers)),
        OrderItem(stringResource(R.string.yellow_slippers)),
        OrderItem(stringResource(R.string.yellow_slippers)),
        OrderItem(stringResource(R.string.yellow_slippers))
    )

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(24.dp),
            color = Color(0xFFF6EDE7) // Background similar to the design
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .width(280.dp)
                    .height(400.dp)
            ) {
                // Title
                Text("Order list", style = MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.height(8.dp))

                // Subtitle
                Text(
                    "There are products, which you have chosen to buy. Make the final purchase decision and place an order .",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.DarkGray
                )
                Spacer(modifier = Modifier.height(16.dp))

                // Scrollable list
                LazyColumn(
                    modifier = Modifier
                        .heightIn(min = 100.dp, max = 200.dp)
                ) {
                    itemsIndexed(items) { index, item ->
                        OrderListItem(index = index + 1, item = item)
                        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Footer buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        "Back",
                        color = Color(0xFF944323),
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier.clickable { onDismiss() }
                    )
                    Spacer(modifier = Modifier.width(30.dp))
                    Text(
                        "Buy",
                        color = Color(0xFF944323),
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier.clickable { onBuyClick() }
                    )
                }
            }
        }
    }
}
data class OrderItem(val name: String, val isChecked: Boolean=true)

@Composable
fun OrderListItem(index: Int, item: OrderItem) {
    var checked by remember { mutableStateOf(true) }
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(36.dp)
                .background(Color(0xFF944323), shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(index.toString(), color = Color.White, style = MaterialTheme.typography.labelLarge)
        }
        Spacer(modifier = Modifier.width(16.dp))
        Text(item.name, modifier = Modifier.weight(1f))
        Checkbox(
            checked = checked,
            onCheckedChange = { checked = it },
            colors = CheckboxDefaults.colors(checkedColor = Color(0xFF944323))
        )
    }
}

@Preview
@Composable
fun OrderListPreview(){
    var showDialog by remember { mutableStateOf(false) }
    OrderListDialog(
        onDismiss = { showDialog = false },
        onBuyClick = {
            showDialog = false
        }
    )
}