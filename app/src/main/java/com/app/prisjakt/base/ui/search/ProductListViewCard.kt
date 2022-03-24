package com.app.prisjakt.base.ui.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
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
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.app.prisjakt.domain.model.ProductInfo
import com.app.prisjakt.util.loadPicture

@Composable
fun ProductListViewCard(
    productInfo: ProductInfo,
    onClick: () -> Unit,
) {
    Card(
        backgroundColor = Color.White,
        modifier = Modifier
            .padding(
                bottom = 6.dp,
                top = 50.dp
            )
            .height(150.dp)
            .fillMaxWidth()
            .fillMaxHeight(0.9f)
            .clickable(onClick = onClick),
        elevation = 20.dp
    ) {
        ConstraintLayout {
            val (productImage, title, price, offer) = createRefs()
            val img = loadPicture(
                url = productInfo.mediaList?.image280x280.toString()
            ).value
            img?.let { image ->
                Image(
                    modifier = Modifier
                        .size(120.dp)
                        .constrainAs(productImage) {
                            top.linkTo(parent.top)
                        },
                    bitmap = image.asImageBitmap(),
                    contentDescription = "Image",

                    contentScale = ContentScale.Crop
                )
            }
            Text(
                text = productInfo.name.toString(),
                modifier = Modifier
                    .width(60.dp)
                    .wrapContentWidth(Alignment.Start)
                    .constrainAs(title) {
                        top.linkTo(parent.top)
                        linkTo(
                            start = productImage.end,
                            end = parent.end,
                            startMargin = 8.dp,
                            endMargin = 8.dp
                        )
                        width = Dimension.fillToConstraints
                    },
                style = TextStyle(
                    fontFamily = FontFamily.Cursive,
                    fontStyle = FontStyle.Italic,
                    fontSize = 15.sp
                )
            )

            productInfo.priceList?.let {
                Text(
                    modifier = Modifier.constrainAs(price) {
                        top.linkTo(title.bottom)
                        linkTo(start = title.start, end = title.end)
                        width = Dimension.fillToConstraints
                    },
                    text = "Price: ${it.offer}Kr",
                    style = TextStyle(
                        fontFamily = FontFamily.Serif,
                        color = Color.Green,
                        fontSize = 26.sp,
                        textAlign = TextAlign.Right
                    )
                )
                Text(
                    modifier = Modifier.constrainAs(offer) {
                        top.linkTo(price.bottom)
                        linkTo(start = price.start, end = price.end)
                        width = Dimension.fillToConstraints
                    },
                    text = "Discount By: ${it.diffPercentage}%",
                    style = TextStyle(
                        fontFamily = FontFamily.Serif,
                        color = Color.Red,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Right
                    )
                )
            }
        }
    }
}



