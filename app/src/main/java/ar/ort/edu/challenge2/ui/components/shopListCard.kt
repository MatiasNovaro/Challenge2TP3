package ar.ort.edu.challenge2.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import ar.ort.edu.challenge2.R
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.res.stringResource

@Composable
fun CustomCard(
    title: String,
    subtitle: String,
    description: String,
    imageRes: Int,
    onAppButtonClick: () -> Unit,
    onAppOutLinedButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .width(360.dp)
            .height(480.dp)
            .wrapContentHeight(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column (
            modifier = Modifier.fillMaxSize(), // <- Hug entire card space
            verticalArrangement = Arrangement.SpaceBetween // Spread content better
        ){
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp)
                    .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Text(
                text = subtitle,
                color = Color.Gray,
                fontSize = 14.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = description,
                fontSize = 14.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 14.dp),
                horizontalArrangement = Arrangement.End
            ) {
                AppOutlinedButton(
                    text = stringResource(R.string.add_to_favourite),
                    onClick = onAppOutLinedButtonClick,
                    modifier = Modifier
                        .width(150.dp)
                        .height(40.dp)

                )
                Spacer(modifier = Modifier.width(12.dp))
                AppButton(
                    text = stringResource(R.string.buy),
                    onClick = onAppButtonClick,
                    modifier = Modifier
                        .width(72.dp)
                        .height(40.dp)

                )
            }

        }
    }
}
@Preview
@Composable
fun ShopListCardPreview(){
    CustomCard(
        title = "Leather boots",
        subtitle = "27,5$",
        description = "Great warm shoes from the artificial leather. You can buy this model only in our shop",
        imageRes = R.drawable.leather_boots,
        onAppButtonClick = {},
        onAppOutLinedButtonClick = { },
        modifier = Modifier,
    )
}