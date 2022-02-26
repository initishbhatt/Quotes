package com.quotes.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.quotes.R
import com.quotes.utils.Tags

@Composable
fun ShareCta(onShareButtonClick: () -> Unit) {
    IconButton(onClick = { onShareButtonClick() }) {
        Image(
            painter = painterResource(id = R.drawable.ic_share),
            contentDescription = stringResource(R.string.share),
            modifier = Modifier
                .padding(16.dp)
                .size(36.dp)
                .testTag(Tags.ShareCTA)
        )
    }
}
