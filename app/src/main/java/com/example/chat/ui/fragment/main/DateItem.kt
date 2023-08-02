package com.example.chat.ui.fragment.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chat.data.FeedItem
import com.example.chat.utils.getTimeddMMyyyyHHmm
import com.google.firebase.Timestamp
import java.util.Date

@Composable
fun DateItem(data: FeedItem.DateData) {
    //todo
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .background(
                    Color.LightGray,
                    shape = RoundedCornerShape(30.dp)
                )
                .padding(5.dp)
                .widthIn(max = 300.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = (data.date.seconds * 1000).getTimeddMMyyyyHHmm(),
                color = Color.Black,
                fontSize = 12.sp,
                lineHeight = 20.sp
            )
        }
    }
}

@Preview
@Composable
fun PreviewDateItem() {
    DateItem(data = FeedItem.DateData(Timestamp(Date(10000000L))))
}