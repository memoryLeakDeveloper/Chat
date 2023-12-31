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
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chat.data.FeedItem
import com.example.chat.data.Sender
import com.example.chat.utils.getTimeStringHHmm
import com.google.firebase.Timestamp
import java.util.Date

@Composable
fun MessageItem(message: FeedItem.MessageData) {
    //todo
    val isYourMessage = message.sender == Sender.S
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = if (isYourMessage) Arrangement.End else Arrangement.Start
    ) {
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .background(
                    Color.White,
                    shape = if (isYourMessage)
                        AbsoluteRoundedCornerShape(
                            topLeftPercent = 25,
                            topRightPercent = 25,
                            bottomLeftPercent = 25,
                            bottomRightPercent = 5
                        )
                    else
                        AbsoluteRoundedCornerShape(
                            topLeftPercent = 25,
                            topRightPercent = 25,
                            bottomLeftPercent = 5,
                            bottomRightPercent = 25
                        )
                )
                .padding(10.dp)
                .widthIn(max = 300.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Text(modifier = Modifier.widthIn(max = 250.dp), text = message.message, lineHeight = 20.sp)
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = message.time.getTimeStringHHmm(),
                color = Color.Gray,
                fontSize = 8.sp,
                lineHeight = 20.sp
            )
        }
    }
}

@Preview
@Composable
fun Preview() {
    MessageItem(FeedItem.MessageData("Привеsdvssdvvsdт!", Timestamp(Date(10000000L)), 100000L, Sender.N))
}