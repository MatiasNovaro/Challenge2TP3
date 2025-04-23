package ar.ort.edu.challenge2.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ar.ort.edu.challenge2.R
import ar.ort.edu.challenge2.ui.components.ProfileCard

@Composable
fun ProfileScreen(navController: NavController){
    val imagePainter =R.drawable.profile_pic
    val name = "Martin"
    val role = "UI UX DESIGN"
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFCFCFC))
            .padding(20.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .verticalScroll(rememberScrollState())

        ) {
            ProfileCard(
                imagePainter = imagePainter,
                name = name,
                role = role,
            )
            OutlinedTextField(
                value = "xxx@gmail.com",
                onValueChange = {},
                readOnly = true,
                label = { Text(stringResource(R.string.e_mail_address)) },
                placeholder = { Text(stringResource(R.string.xxx_gmail_com)) },
                modifier = Modifier.fillMaxWidth(0.9f),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email, // Use your desired icon
                        contentDescription = stringResource(R.string.email_icon)
                    )
                }
            )
            Spacer(modifier = Modifier.height(32.dp))
            OutlinedTextField(
                value = "+5493123135",
                onValueChange = {},
                readOnly = true,
                label = { Text(stringResource(R.string.phone_number)) },
                placeholder = { Text("+5493123135") },
                modifier = Modifier.fillMaxWidth(0.9f),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Phone, // Use your desired icon
                        contentDescription = "Phone Icon"
                    )
                }
            )
            Spacer(modifier = Modifier.height(32.dp))
            OutlinedTextField(
                value = "www.google.com",
                onValueChange = {},
                readOnly = true,
                label = { Text(stringResource(R.string.web_site)) },
                placeholder = { Text("www.google.com") },
                modifier = Modifier.fillMaxWidth(0.9f),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Settings, // Use your desired icon
                        contentDescription = "Web Icon"
                    )
                }
            )
            Spacer(modifier = Modifier.height(32.dp))
            OutlinedTextField(
                value = "xxxxxxxxxxxxxxx",
                onValueChange = {},
                readOnly = true,
                label = { Text(stringResource(R.string.password)) },
                placeholder = { Text("xxxxxxxxxxxxxxx") },
                modifier = Modifier.fillMaxWidth(0.9f),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock, // Use your desired icon
                        contentDescription = "Email Icon"
                    )
                }
            )

        }
    }

}

@Preview
@Composable
fun ProfileScreenPreview(){
}