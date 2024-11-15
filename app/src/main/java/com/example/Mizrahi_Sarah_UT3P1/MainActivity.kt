package com.example.playjuegossmr_ut2p2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.Mizrahi_Sarah_UT3P1.BotonesRadio
import com.example.playjuegossmr_ut2p2.ui.theme.TemaPlayJuegosPersonal

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //Aqui se cambia de tema
            TemaPlayJuegosPersonal {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    //NAVEGACION
                    val navController = rememberNavController()
                    NavHost(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        startDestination = "PantallaPrincipal"
                    ) {
                        composable("PantallaPrincipal") { Principal(navController = navController) }
                        composable("PantallaNewPlayer"){ MenuPlayer(navController = navController) }
                        composable("PantallaPreferences"){ BotonesRadio(navController = navController) }
                    }
                }
            }
        }
    }
}

