package denys.diomaxius.navigationdemo


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import denys.diomaxius.navigationdemo.screens.Profile
import denys.diomaxius.navigationdemo.screens.Home
import denys.diomaxius.navigationdemo.screens.Welcome


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }

    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoutes.Home.route,
    ) {
        composable(NavRoutes.Home.route) {
            Home(navController = navController)
        }

        composable(NavRoutes.Welcome.route + "/{userName}") { backStackEntry ->

            val userName = backStackEntry.arguments?.getString("userName")
            Welcome(navController = navController, userName)
        }

        composable(NavRoutes.Profile.route) {
            Profile()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MainScreen()
}