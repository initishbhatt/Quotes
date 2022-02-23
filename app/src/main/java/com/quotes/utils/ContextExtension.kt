package com.quotes.utils

import android.content.Context
import android.content.Intent

fun Context.share(quote: String) {
    val intent = Intent(Intent.ACTION_SEND)
    intent.type = "text/plain"
    intent.putExtra(Intent.EXTRA_TEXT, quote)
    startActivity(Intent.createChooser(intent, "Share Quote via"))
}
