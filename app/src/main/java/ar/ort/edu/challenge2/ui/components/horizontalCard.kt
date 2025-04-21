package ar.ort.edu.challenge2.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.ort.edu.challenge2.R

@Composable
fun HorizontalItemCard(
    itemNumber: Int,
    title: String,
    subtitle: String,
    imagePainter: Painter,
    modifier: Modifier = Modifier
) {
    OutlinedCard(
        modifier = modifier
            .width(362.dp)
            .height(80.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.outlinedCardColors(),
        border = CardDefaults.outlinedCardBorder()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
        ) {
            // Icon + number
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 12.dp, end = 16.dp)
                    .clip(CircleShape)
                    .size(40.dp)
                    .background(Color(0xFF9A4521))
            ) {
                Text(
                    text = itemNumber.toString(),
                    style = MaterialTheme.typography.labelLarge,
                    color = Color(0xFFFCFCFC)
                )
            }

            // Title + subtitle
            Column(
                modifier = Modifier.weight(1f)

            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
            // Image
            Image(
                painter = imagePainter,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(80.dp)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(topEnd = 12.dp, bottomEnd = 12.dp))
            )
        }

    }
}

@Preview
@Composable
fun HorizontalCardPreview(){
    HorizontalItemCard(
        itemNumber = 1,
        title = "Leather Boots",
        subtitle = "27,5$",
        imagePainter = painterResource(id = R.drawable.leather_boots),
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    )
}