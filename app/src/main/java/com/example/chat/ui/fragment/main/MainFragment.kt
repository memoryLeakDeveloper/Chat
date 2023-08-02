package com.example.chat.ui.fragment.main

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chat.R
import com.example.chat.data.FeedItem
import com.example.chat.data.Sender
import com.example.chat.utils.mockMessagesList
import com.example.chat.utils.noRippleClickable
import com.google.firebase.Timestamp
import kotlinx.coroutines.launch
import java.util.Date

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MainFragment() {

    val haptic = LocalHapticFeedback.current
    val coroutineScope = rememberCoroutineScope()

    var inputState by remember { mutableStateOf("") }
    val listState = rememberLazyListState()
    var mockData by remember { mutableStateOf(mockMessagesList.reversed()) }
    val sendIconColor = remember { Animatable(Color.Red) }
    var sendIconState by rememberSaveable { mutableStateOf(false) }
    val animatedSizeDp by animateDpAsState(
        targetValue = if (sendIconState) 30.dp else 40.dp,
        finishedListener = { if (sendIconState) sendIconState = false },
        animationSpec = TweenSpec(durationMillis = 300)
    )
    val sendCallback: (String) -> Unit = {
        //todo
        mockData = mockData.toMutableList()
            .apply { add(0, FeedItem.MessageData(it, Timestamp(Date(System.currentTimeMillis())), System.currentTimeMillis(), Sender.S)) }
        coroutineScope.launch {
            sendIconColor.animateTo(Color.Red)
            if (listState.canScrollBackward)
                listState.animateScrollToItem(0)
        }
        inputState = ""
    }
    val inputCallback: (String) -> Unit = {
        if (it.isBlank() && sendIconColor.value != Color.Red && !sendIconColor.isRunning) {
            coroutineScope.launch {
                sendIconColor.animateTo(Color.Red, animationSpec = tween(500))
            }
        } else if (it.isNotBlank() && sendIconColor.value != Color.Blue && !sendIconColor.isRunning) {
            coroutineScope.launch {
                sendIconColor.animateTo(Color.Blue, animationSpec = tween(500))
            }
        }
        inputState = it
    }

    Scaffold { padding ->
        Column(
            Modifier
                .fillMaxSize()
                .consumeWindowInsets(padding)
                .background(Color.Gray)
                .paint(painter = painterResource(id = R.drawable.ic_background), contentScale = ContentScale.Crop)
        ) {
            LazyColumn(
                state = listState,
                modifier = Modifier.weight(1F),
                contentPadding = PaddingValues(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                reverseLayout = true,
            ) {
                items(mockData) {
                    if (it is FeedItem.MessageData)
                        MessageItem(it)
                    else
                        DateItem(it as FeedItem.DateData)
                }
            }
            TextField(
                value = inputState,
                onValueChange = { inputCallback(it) },
                placeholder = { Text("Enter the message", modifier = Modifier.alpha(0.5F)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp),
                trailingIcon = {
                    Icon(
                        painterResource(id = R.drawable.ic_send), contentDescription = null, modifier = Modifier
                            .size(animatedSizeDp)
                            .padding(5.dp)
                            .noRippleClickable {
                                if (inputState.isBlank())
                                    return@noRippleClickable
                                haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                                sendCallback(inputState.trim())
                                sendIconState = true
                            },
                        tint = sendIconColor.value
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White
                )
            )
        }
    }
}

@Preview
@Composable
fun PreviewMain() {
    MainFragment()
}