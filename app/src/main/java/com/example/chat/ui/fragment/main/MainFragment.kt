package com.example.chat.ui.fragment.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chat.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MainFragment() {

    var inputState by remember { mutableStateOf("") }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    val focusManager = LocalFocusManager.current
    val sendCallback: () -> Unit = {
        //todo
        inputState = ""
    }
    val inputCallback: (String) -> Unit = { inputState = it }

    Scaffold { padding ->
        Column(
            Modifier
                .fillMaxSize()
                .consumeWindowInsets(padding)
                .padding(10.dp)
        ) {
            LazyColumn(
                state = listState,
                modifier = Modifier
                    .weight(1F)
                    .padding(vertical = 10.dp),
                contentPadding = padding,
                verticalArrangement = Arrangement.spacedBy(10.dp),
                reverseLayout = true,
            ) {
                itemsIndexed(mutableListOf<String>().apply {
                    repeat(
                        times = 30,
                        { add("234020sdfgdfgfdgdfgdfgfdhgghdgfdgfdgdfgdfdsfsdfsdfdsfsd3432") })
                }) { index, item ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = if (index % 2 == 0) Arrangement.End else Arrangement.Start
                    ) {
                        MessageItem(item)
                    }
                }
            }
            Row(
                modifier = Modifier.wrapContentHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    modifier = Modifier
                        .weight(1F)
                        .background(color = Color.Black, shape = RoundedCornerShape(10.dp))
                        .background(
                            color = Color(0xffb9b9b9),
                            shape = CircleShape
                        ), colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent, //hide the indicator
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    value = inputState, onValueChange = { inputCallback(it) }, placeholder = { Text("Enter the message") }
                )
                Spacer(modifier = Modifier.width(10.dp))
                Image(
                    modifier = Modifier
                        .size(50.dp)
                        .padding(5.dp)
                        .clickable {
                            sendCallback()
                            coroutineScope.launch {
                                focusManager.clearFocus()
                                delay(300L)
                                if (listState.canScrollBackward)
                                    listState.animateScrollToItem(0)
                            }
                        },
                    painter = painterResource(id = R.drawable.ic_send),
                    contentDescription = null
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewMain() {
    MainFragment()
}
