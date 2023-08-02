package com.example.chat.utils

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


private const val hhmmPattern = "HH:mm"
val hhmmSimpleDateFormat = SimpleDateFormat(hhmmPattern, Locale.ENGLISH)
private const val mmssPattern = "mm:ss"
val mmssSimpleDateFormat = SimpleDateFormat(mmssPattern, Locale.ENGLISH)
private const val yyPattern = "YYYY"
val yySimpleDateFormat = SimpleDateFormat(yyPattern, Locale.ENGLISH)

val df: DateFormat = SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.US)

fun Long.getTimeStringHHmm() = hhmmSimpleDateFormat.format(Date(this))

fun Long.getYearString() = yySimpleDateFormat.format(Date(this))

fun Long.getTimeStringMMss() = mmssSimpleDateFormat.format(Date(this))

fun Long.getTimeddMMyyyyHHmm() = df.format(Date(this))

