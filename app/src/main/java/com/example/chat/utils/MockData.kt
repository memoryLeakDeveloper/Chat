package com.example.chat.utils

import androidx.compose.ui.graphics.Color
import com.example.chat.data.FeedItem
import com.example.chat.data.Sender
import com.google.firebase.Timestamp
import java.util.Date

val mockMessagesList = mutableListOf(
    FeedItem.DateData(Timestamp(Date(10000000L))),
    FeedItem.MessageData("fsdfsdfsdfsdfsdfsfsdf!", Timestamp(Date(10000000L)), 100000L, Sender.S),
    FeedItem.MessageData("sdfsdfsdfsdf!", Timestamp(Date(10000000L)), 100000L, Sender.N),
    FeedItem.DateData(Timestamp(Date(20000000L))),
    FeedItem.MessageData("Приsdfsdfsdfsdвет!", Timestamp(Date(10000000L)), 111111, Sender.S),
    FeedItem.MessageData("Gjrsdfsdfsdfsf!", Timestamp(Date(10000000L)), 323232, Sender.N),
    FeedItem.DateData(Timestamp(Date(30000000L))),
    FeedItem.MessageData("sdfsdfsdfsdfsdfsd!", Timestamp(Date(10000000L)), 23432423423423, Sender.S),
    FeedItem.MessageData("zxczxczxczczx!", Timestamp(Date(10000000L)), 12312312312, Sender.N),
    FeedItem.DateData(Timestamp(Date(40000000L))),
    FeedItem.MessageData("zxczxczxczxczxczczxczxczxczcxzxczxczxczxc!", Timestamp(Date(10000000L)), 1012312312, Sender.S),
    FeedItem.MessageData(
        "qweqweqweqeeqweqweqeqxefvjuhjfvjfvjfvjvsjknvjnjnjnjwnjlok;njlkndjsklcn   zcvvsdssdsdvsdvsdvsd!",
        Timestamp(Date(10000000L)),
        87987978,
        Sender.N
    ),
    FeedItem.DateData(Timestamp(Date(50000000L))),
    FeedItem.MessageData("Привет!", Timestamp(Date(10000000L)), 87978987, Sender.S),
    FeedItem.MessageData("Gjrf!", Timestamp(Date(10000000L)), 100789789000L, Sender.N),
    FeedItem.DateData(Timestamp(Date(60000000L))),
    FeedItem.MessageData("Привет!", Timestamp(Date(10000000L)), 1078978970000L, Sender.S),
    FeedItem.MessageData("Gjrf!", Timestamp(Date(10000000L)), 78978978, Sender.N),
    FeedItem.DateData(Timestamp(Date(70000000L))),
    FeedItem.MessageData("Привет!", Timestamp(Date(10000000L)), 78978, Sender.S),
    FeedItem.MessageData("Gjrf!", Timestamp(Date(10000000L)), 78978978, Sender.N),
    FeedItem.DateData(Timestamp(Date(80000000L))),
    FeedItem.MessageData("Привет!", Timestamp(Date(10000000L)), 78978, Sender.S),
    FeedItem.MessageData("Gjrf!", Timestamp(Date(10000000L)), 1007897897000L, Sender.N),
    FeedItem.DateData(Timestamp(Date(90000000L))),
    FeedItem.MessageData("Привет!", Timestamp(Date(10000000L)), 45645, Sender.S),
    FeedItem.MessageData("Gjrf!", Timestamp(Date(10000000L)), 64564, Sender.N)
)

val colorsList = listOf(Color.Blue, Color.Red, Color.Cyan, Color.Magenta, Color.Green)