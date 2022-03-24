package com.app.prisjakt.base.ui.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.prisjakt.domain.model.ProductInfo
import com.app.prisjakt.util.loadPicture

@Composable
fun ProductView(
    productInfo: ProductInfo,
) {
    Surface(
        elevation = 10.dp
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            item {
                val image = loadPicture(
                    url = productInfo.mediaList?.image800x800.toString()
                ).value
                image?.let { img ->
                    Image(
                        bitmap = img.asImageBitmap(),
                        contentDescription = "Product 800x800 image",
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentScale = ContentScale.Crop,
                    )
                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                        .padding(20.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 4.dp)
                    ) {
                        Text(
                            text = productInfo.name.toString(),
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentWidth(Alignment.Start),
                            style = TextStyle(
                                fontFamily = FontFamily.SansSerif,
                                fontStyle = FontStyle.Italic,
                                fontSize = 20.sp
                            )
                        )
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(20.dp)
                                .padding(20.dp)
                        )
                        Text(
                            text = "Price :${productInfo.priceList?.offer.toString()} Kr",
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentWidth(Alignment.Start)
                                .align(Alignment.CenterHorizontally),
                            color = Color.Green,
                            fontSize = 40.sp,
                            textAlign = TextAlign.Right
                        )
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(20.dp)
                                .padding(20.dp)
                        )

                        Text(
                            text = "Price drop down by :${productInfo.priceList?.diffPercentage.toString()} %",
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentWidth(Alignment.Start)
                                .align(Alignment.CenterHorizontally),
                            color = Color.Red,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Right
                        )
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .padding(20.dp)
                        )

                        Text(
                            text = "Date of creation :${productInfo.dateOfCreation}",
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentWidth(Alignment.Start)
                                .align(Alignment.CenterHorizontally),
                            color = Color.DarkGray,
                            fontSize = 10.sp,
                            textAlign = TextAlign.Left
                        )
                    }
                }
            }
        }
    }
}