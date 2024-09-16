package com.davimatyi.angletool.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun AngleVisualizer(angle : Float, visible: Boolean) {
    val density = LocalDensity.current
    val containerColor = MaterialTheme.colorScheme.secondaryContainer
    val primaryColor = MaterialTheme.colorScheme.primary
    AnimatedVisibility(
        visible = visible,
        enter = slideInVertically {
            with(density) { -40.dp.roundToPx() }
        } + expandVertically(
            expandFrom = Alignment.Top
        ) + fadeIn(
            initialAlpha = 0f
        ),
        exit = shrinkVertically() + fadeOut(targetAlpha = 0f)
    ) {
        Canvas(
            modifier = Modifier
                .size(size = 300.dp)
        ) {
            val canvasSize = size
            drawCircle(
                color = containerColor,
            )
            if(visible)
                drawArc(
                    color = primaryColor,
                    startAngle = -90f,
                    sweepAngle = -angle,
                    useCenter = false,
                    style = Stroke(width = 86f, cap = StrokeCap.Round),
                    size = canvasSize * 0.9f,
                    topLeft = Offset(x = canvasSize.width * 0.05f, y = canvasSize.height * 0.05f)
                )
        }
    }
}

@Preview
@Composable
fun AngleVisualizerPreview() {
    AngleVisualizer(0f, true)
}