package com.davimatyi.angletool.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.davimatyi.angletool.viewmodels.AngleViewModel
import com.davimatyi.angletool.components.AngleVisualizer


@Composable
fun AngleScreen(viewModel: AngleViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box (modifier = Modifier
            .width(300.dp)
            .height(300.dp)) {
            AngleVisualizer(viewModel.currentAngle.toFloat(), viewModel.isLocked)
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AngleLabel(viewModel.angleText, viewModel.isLocked)
                LockButton(viewModel.isLocked, viewModel::switchLock)
            }
        }
    }
}

@Composable
fun AngleLabel(text: String, visible: Boolean) {
    val density = LocalDensity.current
    AnimatedVisibility(
        visible = visible,
        enter = slideInVertically {
            with(density) { -40.dp.roundToPx() }
        } + expandVertically(
            expandFrom = Alignment.Top
        ) + fadeIn(
            initialAlpha = 0.3f
        ),
        exit = slideOutVertically() + shrinkVertically() + fadeOut()
    ) {
        Text(
            text = text,
            fontSize = 64.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun LockButton(isLocked: Boolean, switchLock: () -> Unit) {
    Button(
        onClick = switchLock,
        shape = RoundedCornerShape(50),
        contentPadding = PaddingValues(0.dp),
        modifier = Modifier.size(
            width = 200.dp,
            height = 70.dp
        )
    ) {
        Text(
            text = if (isLocked) "Clear" else "Start",
            fontSize = 40.sp
        )
    }
}
