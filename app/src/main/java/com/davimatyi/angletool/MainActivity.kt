package com.davimatyi.angletool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.davimatyi.angletool.screens.MainLayout
import com.davimatyi.angletool.ui.theme.AngleToolTheme
import com.davimatyi.angletool.viewmodels.AngleViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            AngleToolTheme {
                val systemUiController = rememberSystemUiController()
                val backgroundColor = MaterialTheme.colorScheme.background
                val darkIcons = !isSystemInDarkTheme()
                val viewModel = AngleViewModel(application)
//                val navController = rememberNavController()

                SideEffect {
                    systemUiController.setStatusBarColor(
                        color = backgroundColor,
                        darkIcons
                    )
                }

                Surface(
                    modifier = Modifier.fillMaxSize().fillMaxHeight(),
                    color = backgroundColor
                ) {
                    MainLayout(viewModel)
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    AngleToolTheme {
//        AppLayout()
    }
}