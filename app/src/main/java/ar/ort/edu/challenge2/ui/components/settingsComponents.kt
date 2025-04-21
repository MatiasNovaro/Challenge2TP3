package ar.ort.edu.challenge2.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.ListItem
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color

@Composable
fun SettingsSection(
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(Color.Transparent)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        content()
    }
}

@Composable
fun SettingsNavItem(
    title: String,
    onClick: () -> Unit
) {
    ListItem(
        headlineContent = { Text(title) },
        trailingContent = {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null
            )
        }

    )
}

@Composable
fun SettingsToggleItem(
    title: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    ListItem(
        headlineContent = { Text(title) },
        trailingContent = {
            Switch(
                checked = checked,
                onCheckedChange = onCheckedChange
            )
        },
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview
@Composable
fun SettingComponentsPreview(){
    SettingsSection(title = "Account Settings") {
        SettingsNavItem("Edit Profile") { /* Navigate */ }
        SettingsNavItem("Change Password") { /* Navigate */ }
        var notificationsEnabled = true
        var darkModeEnabled = true
        SettingsToggleItem(
            title = "Push Notifications",
            checked = notificationsEnabled,
            onCheckedChange = { notificationsEnabled = it }
        )
        SettingsToggleItem(
            title = "Dark Mode",
            checked = darkModeEnabled,
            onCheckedChange = { darkModeEnabled = it }
        )
    }
}

