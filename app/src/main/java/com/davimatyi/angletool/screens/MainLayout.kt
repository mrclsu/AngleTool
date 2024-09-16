package com.davimatyi.angletool.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.davimatyi.angletool.navigation.MeasureBottomNavBar
import com.davimatyi.angletool.navigation.MeasureNavHost
import com.davimatyi.angletool.ui.theme.AngleToolTheme
import com.davimatyi.angletool.viewmodels.AngleViewModel

@Composable
fun MainLayout(viewModel: AngleViewModel) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { MeasureBottomNavBar(navController) },
        modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->
        MeasureNavHost(viewModel = viewModel,navController = navController, Modifier.padding(innerPadding))
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun MainLayoutPreview() {
//    AngleToolTheme {
//        MainLayout()
//    }
//}