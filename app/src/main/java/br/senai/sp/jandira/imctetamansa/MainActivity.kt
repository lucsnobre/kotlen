package br.senai.sp.jandira.imctetamansa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.senai.sp.jandira.bmi.screens.TelaInicial
import br.senai.sp.jandira.imctetamansa.screens.UserDataScreen
import br.senai.sp.jandira.imctetamansa.ui.theme.ImcTetaMansaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImcTetaMansaTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "home"
                ) {
                    composable("home") {
                        TelaInicial(navController)
                    }
                    composable("user_data") {
                        UserDataScreen()
                    }
                }
            }
        }
    }
}
