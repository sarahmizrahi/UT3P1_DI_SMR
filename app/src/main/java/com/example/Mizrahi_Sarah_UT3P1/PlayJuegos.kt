package com.example.playjuegossmr_ut2p2

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.playjuegossmr_ut2p2.ui.theme.courgette_regular



@Composable
fun Principal(modifier: Modifier = Modifier, navController: NavController) //Parametros para que innerPadding funiones en el main
{
    //Orientacion
    val configuration = LocalConfiguration.current  //Obtiene la orientacion actual

    //Box para tener todos los componentes juntos
    Box(
        modifier = Modifier.fillMaxSize(), //Ocupa toda la pantalla

    ) {
        //Modo columna para que los componentes se apilen
        Column(
            modifier = Modifier.align(Alignment.Center),    //Alinea toda la columna al centro de la pantalla,
            // si la columna no estuviera dentro de un Box no podria centrarlo.
            horizontalAlignment = Alignment.CenterHorizontally, //Alinear horizontalmente
        ) {
            //Imagen
            Image(
                painter = painterResource(id = R.drawable.games), //Ruta imagen
                contentDescription = "games",     //Nombre
                modifier = Modifier.requiredSize(150.dp)    //Tamaño
            )

            //Espacio, uso mi función
            Spacer(10)

            //Texto del medio
            Text(
                text = "Play Games",
                fontFamily = courgette_regular, //Tipografia creada en type.kt
                fontSize = 40.sp,   //Tamaño fuente
            )

            //Espacio, uso mi función
            Spacer(10)


            //VERTICAL
            when (configuration.orientation) {
                Configuration.ORIENTATION_LANDSCAPE -> {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        //PLAY Y NEW PLAYER A LA IZQUIERDA
                        Column {
                            //Botones
                            Button(
                                onClick = {},
                                shape = RoundedCornerShape(50), //Redondea los bordes
                                modifier = Modifier
                                    .width(170.dp),  //Ancho del boton
                            ) {
                                Text(text = "Play")
                            }

                            //NAVEGAR A PANTALLA NEW PLAYER
                            Button(
                                onClick = { navController.navigate("PantallaNewPlayer") },
                                shape = RoundedCornerShape(50),
                                modifier = Modifier
                                    .width(170.dp)
                            ) {
                                Text(text = "New Player")
                            }
                        }
                        //Espaciado entre columnas. Mi funcion
                        Spacer(20)

                        //PREFERENCES Y USERS A LA DERECHA
                        //NAVEGAR A PantallaPreferences
                        Column {
                            Button(
                                onClick = { navController.navigate("PantallaPreferences") },
                                shape = RoundedCornerShape(50),
                                modifier = Modifier
                                    .width(170.dp)
                            ) {
                                Text(text = "Preferences")
                            }
                            Button(
                                onClick = { },
                                shape = RoundedCornerShape(50),
                                modifier = Modifier
                                    .width(170.dp)
                            ) {
                                Text(text = "Users")
                            }
                        }
                    }
                    //Boton "About"no se mueve
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(50),
                        modifier = Modifier
                            .width(170.dp)
                    ) {
                        Text(text = "About")
                    }
                }

                //VERTICAL. PORTRAIT
                else -> {
                    Column {
                        Button(
                            onClick = { },
                            shape = RoundedCornerShape(50),
                            modifier = Modifier
                                .width(170.dp)
                        ) {
                            Text(text = "Play")
                        }

                        Button(
                            onClick = { navController.navigate("PantallaNewPlayer") },
                            shape = RoundedCornerShape(50),
                            modifier = Modifier
                                .width(170.dp)
                        ) {
                            Text(text = "New Player")
                        }

                        Button(
                            onClick = { navController.navigate("PantallaPreferences") },
                            shape = RoundedCornerShape(50),
                            modifier = Modifier
                                .width(170.dp)
                        ) {
                            Text(text = "Preferences")
                        }

                        Button(
                            onClick = { },
                            shape = RoundedCornerShape(50),
                            modifier = Modifier
                                .width(170.dp)
                        ) {
                            Text(text = "Users")
                        }

                        Button(
                            onClick = { },
                            shape = RoundedCornerShape(50),
                            modifier = Modifier
                                .width(170.dp)
                        ) {
                            Text(text = "About")
                        }
                    }
                }
            }
        }
    }
}

//Mi funcion para establecer espacios entre layouts
@Composable
fun Spacer(size: Int) {
    androidx.compose.foundation.layout.Spacer(
        modifier = Modifier
            .width(size.dp)
            .height(size.dp)
    )
}
