package com.example.ehcproject.ui.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ehcproject.ui.navigation.Screen.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EhcScreen() {
    val navController = rememberNavController()
    val currentScreen = Screen.valueOf(
        navController.currentBackStackEntry?.destination?.route ?: Screen.MainScreen.name
    )
    Scaffold(
        topBar = {
            TopAppBar(
                currentScreen = currentScreen
            )
        }
    )
    { paddingValues ->
        NavHost(
            modifier = Modifier.padding(paddingValues),
            startDestination = Screen.MainScreen.name,
            navController = navController
        ) {
            composable(Screen.MainScreen.name) {

            }

            composable(Screen.MemberScreen.name) {

            }

            composable(Screen.InterestsScreen.name) {

            }
        }
    }
}

@Composable
fun TopAppBar(
    currentScreen: Screen
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = currentScreen.AppBarText),
            fontSize = 36.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
    TopAppBar(currentScreen = Screen.MainScreen)
}