package com.quotes.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.quotes.R
import com.quotes.utils.Tags

@Composable
fun FavouriteCta(onFavButtonClick: () -> Unit) {
    IconButton(onClick = { onFavButtonClick() }) {
        Icon(
            imageVector = Icons.Outlined.Favorite,
            contentDescription = stringResource(R.string.favourites),
            modifier = Modifier.padding(16.dp).testTag(Tags.FAVOURITESCTA)
        )
    }
}
