package com.example.navigationexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigationexample.ui.theme.NavigationExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationExampleTheme {
                StudentProfileApp()
            }
        }
    }
}

@Composable
fun StudentProfileApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "student_list"
    ) {
        composable(
            route = "student_list",
            enterTransition = {
                fadeIn(animationSpec = tween(300))
            },
            exitTransition = {
                fadeOut(animationSpec = tween(300)) + slideOutHorizontally { width -> -width / 3 }
            },
            popEnterTransition = {
                fadeIn(animationSpec = tween(300)) + slideInHorizontally { width -> -width / 3 }
            }
        ) {
            StudentListScreen(
                students = StudentRepository.studentList,
                onStudentClick = { studentId ->
                    navController.navigate("student_detail/$studentId")
                }
            )
        }

        composable(
            route = "student_detail/{studentId}",
            arguments = listOf(
                navArgument("studentId") {
                    type = NavType.IntType
                    nullable = false
                }
            ),
            enterTransition = {
                fadeIn(animationSpec = tween(300)) + slideInHorizontally { width -> width }
            },
            exitTransition = {
                fadeOut(animationSpec = tween(300))
            },
            popExitTransition = {
                fadeOut(animationSpec = tween(300)) + slideOutHorizontally { width -> width }
            }
        ) { backStackEntry ->
            val studentId = backStackEntry.arguments?.getInt("studentId")
            val student = StudentRepository.getStudentById(studentId)

            StudentDetailScreen(
                student = student,
                onGoBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
