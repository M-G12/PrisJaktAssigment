package com.app.prisjakt.base.ui.search

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp


@Composable
fun SearchViewText(isNetworkAvailable: Boolean, viewModel: SearchViewModel) {
    if (isNetworkAvailable) {
        val searchBy = remember { mutableStateOf(TextFieldValue("")) }
        SearchViewTextField(searchBy, viewModel)
    } else {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                "No network connection",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(8.dp),
                style = MaterialTheme.typography.h6
            )

        }
    }
}

@Composable
fun SearchViewTextField(state: MutableState<TextFieldValue>, viewModel : SearchViewModel) {
    Box(
        modifier = Modifier
            .border(width = 1.dp, color = Color.DarkGray, shape = CircleShape)
            .fillMaxWidth()
    ) {
        BasicTextField(
            value = state.value,
            onValueChange = {
                state.value = it
                viewModel.search(state.value.text)
            },
            modifier = Modifier
                .background(Color.White, CircleShape)
                .height(40.dp)
                .fillMaxWidth(),
            singleLine = true,
            maxLines = 1,
            decorationBox = { innerTextField ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 10.dp)
                ) {
                    Box(
                        modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        if (state.value == TextFieldValue("")) Text(
                            "Search"
                        )
                        innerTextField()
                    }
                    if (state.value != TextFieldValue("")) {
                        IconButton(
                            onClick = {
                                state.value = TextFieldValue("")
                            },
                        ) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "image",
                                tint = Color.Blue
                            )
                        }
                    }
                }
            }
        )
    }
}