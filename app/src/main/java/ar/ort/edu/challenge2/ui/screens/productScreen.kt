package ar.ort.edu.challenge2.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ar.ort.edu.challenge2.R
import ar.ort.edu.challenge2.ui.Screen
import ar.ort.edu.challenge2.ui.components.AppButton
import ar.ort.edu.challenge2.ui.components.AppOutlinedButton
import ar.ort.edu.challenge2.ui.components.OutlinedDropdownField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductScreen(navController: NavController) {
    val sizes = listOf("S", "M", "L")
    var selectedSize by remember { mutableStateOf(sizes[0]) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFCFCFC))
            .padding(20.dp)
    ) {
        Column(
            modifier = Modifier.align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = stringResource(R.string.select_size),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(24.dp))

            OutlinedDropdownField(
                label = "Size",
                options = sizes,
                selectedOption = selectedSize,
                onOptionSelected = { selectedSize = it },
                modifier = Modifier.fillMaxWidth(0.7f)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = stringResource(R.string.count_of_product),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(24.dp))

            OutlinedTextField(
                value = stringResource(R.string.input),
                onValueChange = {},
                readOnly = true,
                label = { Text(stringResource(R.string.count)) },
                placeholder = { Text(stringResource(R.string.input)) },
                modifier = Modifier.fillMaxWidth(0.9f)
            )
        }

        // Buttons at the bottom
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(horizontal = 24.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AppOutlinedButton(
                text = "Back",
                onClick = {navController.navigate(Screen.ShopScreen.route)},
                modifier = Modifier
                    .width(100.dp)
                    .height(40.dp)


            )
            AppButton(
                text = "Buy",
                onClick = {},
                modifier = Modifier
                    .width(100.dp)
                    .height(40.dp)
            )
        }
    }
}


@Preview
@Composable
fun ProductScreenPreview(){
}