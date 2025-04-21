package ar.ort.edu.challenge2.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.ort.edu.challenge2.R

@Composable
fun ProfileCard(
    imagePainter: Int,
    name: String,
    role: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .width(139.dp)
            .height(200.dp)
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(96.dp)
        ) {
            // Avatar image
            Image(
                painter = painterResource(imagePainter),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            // Orange icon overlaid (bottom right)
            Icon(
                imageVector = Icons.Default.Create, // replace with a custom icon if needed
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .offset(4.dp, 4.dp)
                    .background(
                        color = Color(0xFFFF7A00),
                        shape = CircleShape
                    )
                    .padding(6.dp)
                    .size(16.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = name,
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
        )

        Text(
            text = role,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Preview
@Composable
fun ProfileCardPreview(){
    ProfileCard(
        imagePainter = R.drawable.profile_pic,
        name ="Martin",
        role = "UI UX DESIGN"
    )
}