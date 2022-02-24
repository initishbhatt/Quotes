package com.quotes.ui.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.quotes.R
import com.quotes.utils.Tags

@Composable
fun RefreshCta(onRefreshButtonClick: () -> Unit) {
    val isRotated = remember {
        mutableStateOf(false)
    }
    val angle: Float by animateFloatAsState(
        targetValue = if (isRotated.value) 180f else 0f,
        animationSpec = tween(
            durationMillis = 500,
            easing = LinearEasing
        ),
        finishedListener = { isRotated.value = false }
    )
    IconButton(onClick = {
        onRefreshButtonClick()
        isRotated.value = !isRotated.value
    }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_refresh),
            contentDescription = stringResource(R.string.refresh),
            modifier = Modifier
                .rotate(angle)
                .size(64.dp).testTag(Tags.REFRESHCTA)
        )
    }
}
