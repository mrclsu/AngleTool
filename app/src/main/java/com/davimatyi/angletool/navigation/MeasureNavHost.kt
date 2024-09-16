package com.davimatyi.angletool.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MotionPhotosOn
import androidx.compose.material.icons.outlined.MotionPhotosOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.davimatyi.angletool.screens.AngleScreen
import com.davimatyi.angletool.screens.LevelScreen
import com.davimatyi.angletool.viewmodels.AngleViewModel
import dev.marcell.colors_wallpaper.ui.components.icons.ToolsLevel

sealed class MeasureNavRoutes(val route: String, val icon: ImageVector) {
    data object Level : MeasureNavRoutes("level", Icons.Filled.ToolsLevel)
    data object Angle : MeasureNavRoutes("angle", Icons.Outlined.MotionPhotosOn)

    companion object {
        val allRoutes: List<MeasureNavRoutes> = listOf(
            Level,
            Angle,
        )
    }
}

@Composable
fun MeasureNavHost(viewModel: AngleViewModel, navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = MeasureNavRoutes.Angle.route,
        enterTransition = {
            EnterTransition.None
        },
        exitTransition = {
            ExitTransition.None
        },
        popEnterTransition = {
            EnterTransition.None
        },
        popExitTransition = {
            ExitTransition.None
        },
        modifier = modifier
    ) {
        composable(MeasureNavRoutes.Level.route) { LevelScreen() }
        composable(MeasureNavRoutes.Angle.route) { AngleScreen(viewModel) }
    }
}