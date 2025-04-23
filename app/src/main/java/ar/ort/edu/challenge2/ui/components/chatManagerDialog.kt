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
fun ChatManagerDialog(
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(24.dp),
            color = Color(0xFFF6EDE7)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .width(390.dp)
                    .height(216.dp)
            ) {
                    Text(
                        stringResource(R.string.chat_with_manager),
                        style = MaterialTheme.typography.headlineSmall,
                        color = Color(0xFF1A1A1A)
                    )

                Spacer(modifier = Modifier.height(16.dp))

                // Subtitle
                Text(
                    stringResource(R.string.hello_my_name_is_alex_please_write_your_question_below_here),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.DarkGray
                )

                Spacer(modifier = Modifier.weight(1f)) // Push footer to the bottom

                // Footer buttons
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    AppButton(
                        text = "Send",
                        onClick = onDismiss,
                        modifier = Modifier
                            .width(80.dp)
                            .height(40.dp)

                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ChatManagerDialogPreview(){
    var showDialog by remember { mutableStateOf(false) }
    ChatManagerDialog(
        onDismiss = { showDialog = false }
    )
}