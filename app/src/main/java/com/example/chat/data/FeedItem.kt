package com.example.chat.data

import com.google.firebase.Timestamp

sealed interface FeedItem {
    data class MessageData(val message: String, val date: Timestamp, val time: Long, val sender: Sender): FeedItem
    data class DateData(val date: Timestamp): FeedItem
}
