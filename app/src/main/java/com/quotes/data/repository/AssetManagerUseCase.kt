package com.quotes.data.repository

import android.content.res.AssetManager
import com.quotes.data.model.Quotes
import java.nio.charset.Charset
import javax.inject.Inject
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

/**
 * @author nitishbhatt
 */
class AssetManagerUseCase @Inject constructor(
    private val assetManager: AssetManager,
    private val json: Json
) {
    fun fetchQuotesList(assetName: String): List<Quotes> {
        val jsonString = assetManager.open(assetName).bufferedReader(Charset.defaultCharset()).use {
            it.readText()
        }
        return json.decodeFromString(jsonString)
    }
}
