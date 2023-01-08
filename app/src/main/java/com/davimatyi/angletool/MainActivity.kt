package com.davimatyi.angletool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.davimatyi.angletool.ui.theme.AngleToolTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AngleToolTheme {
                val systemUiController = rememberSystemUiController()
                val backgroundColor = MaterialTheme.colorScheme.background
                val darkIcons = !isSystemInDarkTheme()
                val viewModel = AngleViewModel(application)

                SideEffect {
                    systemUiController.setStatusBarColor(
                        color = backgroundColor,
                        darkIcons
                    )
                    systemUiController.setNavigationBarColor(
                        color = backgroundColor,
                        darkIcons
                    )
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = backgroundColor
                ) {
                    AppLayout(viewModel)
                }
            }
        }
    }
}

@Composable
fun AppLayout(viewModel: AngleViewModel) {
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

@Composable
fun AngleVisualizer(angle : Float, visible: Boolean) {
    val density = LocalDensity.current
    val containerColor = MaterialTheme.colorScheme.primaryContainer
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
                color = containerColor
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    AngleToolTheme {
        //AppLayout()
    }
}