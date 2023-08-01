package com.example.chat.ui.fragment.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MessageItem(message: String) {

    Box(
        modifier = Modifier
            .wrapContentHeight()
            .background(Color(0xffb9b9b9), shape = RoundedCornerShape(10.dp))
            .padding(10.dp)
            .widthIn(max = 300.dp),
        contentAlignment = Alignment.CenterStart

    ) {
        Text(text = message, lineHeight = 20.sp)

    }
}

@Preview
@Composable
fun Preview() {
    MessageItem("234324324234234324324324234234234234324324322342343242342234")
}