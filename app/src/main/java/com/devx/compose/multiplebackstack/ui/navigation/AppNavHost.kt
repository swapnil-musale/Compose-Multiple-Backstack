package com.devx.compose.multiplebackstack.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.devx.compose.multiplebackstack.ui.common.GenericScreen

@Composable
fun AppNavHost(rootNavController: NavHostController) {
    NavHost(navController = rootNavController, startDestination = "home") {
        composable("home") {
            HomeNavHost()
        }

        composable("profile") {
            ProfileNavHost()
        }

        composable("settings") {
            SettingsNavHost()
        }
    }
}

@Composable
fun HomeNavHost() {
    val homeNavController = rememberNavController()
    NavHost(navController = homeNavController, startDestination = "home_1") {
        for (i in 1..10) {
            composable(route = "home_$i") {
                GenericScreen(
                    text = "Home $i",
                    onNavigateClick = {
                        if (i < 10) {
                            homeNavController.navigate("home_${i.plus(1)}")
                        }
                    },
                )
            }
        }
    }
}

@Composable
fun ProfileNavHost() {
    val homeNavController = rememberNavController()
    NavHost(navController = homeNavController, startDestination = "profile_1") {
        for (i in 1..10) {
            composable(route = "profile_$i") {
                GenericScreen(
                    text = "Profile $i",
                    onNavigateClick = {
                        if (i < 10) {
                            homeNavController.navigate("profile_${i.plus(1)}")
                        }
                    },
                )
            }
        }
    }
}

@Composable
fun SettingsNavHost() {
    val homeNavController = rememberNavController()
    NavHost(navController = homeNavController, startDestination = "settings_1") {
        for (i in 1..10) {
            composable(route = "settings_$i") {
                GenericScreen(
                    text = "Settings $i",
                    onNavigateClick = {
                        if (i < 10) {
                            homeNavController.navigate("settings_${i.plus(1)}")
                        }
                    },
                )
            }
        }
    }
}
