package ar.ort.edu.challenge2.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ar.ort.edu.challenge2.R
import ar.ort.edu.challenge2.ui.components.SettingsNavItem
import ar.ort.edu.challenge2.ui.components.SettingsSection
import ar.ort.edu.challenge2.ui.components.SettingsToggleItem

@Composable
fun SettingsScreen(navController: NavController) {
    var notificationsEnabled by remember { mutableStateOf(true) }
    var darkModeEnabled by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        item {
            SettingsSection(title = stringResource(R.string.account_settings)) {
                SettingsNavItem(stringResource(R.string.edit_profile)) { /* Navigate */ }
                SettingsNavItem(stringResource(R.string.change_password)) { /* Navigate */ }
                SettingsToggleItem(
                    title = stringResource(R.string.push_notifications),
                    checked = notificationsEnabled,
                    onCheckedChange = { notificationsEnabled = it }
                )
                SettingsToggleItem(
                    title = stringResource(R.string.dark_mode),
                    checked = darkModeEnabled,
                    onCheckedChange = { darkModeEnabled = it }
                )
                HorizontalDivider()
            }
        }

        item {
            SettingsSection(title = stringResource(R.string.more)) {
                SettingsNavItem(stringResource(R.string.about_us)) { /* Navigate */ }
                SettingsNavItem(stringResource(R.string.privacy_policy)) { /* Navigate */ }
                SettingsNavItem(stringResource(R.string.terms_and_conditions)) { /* Navigate */ }
            }
        }
    }
}

@Preview
@Composable
fun SettingsScreenPrewiew(){

}
