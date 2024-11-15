package com.example.Mizrahi_Sarah_UT3P1

import android.transition.Slide
import android.widget.RadioButton
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.playjuegossmr_ut2p2.sarahColor
import com.example.playjuegossmr_ut2p2.ui.theme.PGPrimario


//@Preview(showBackground = true)
@Composable
fun BotonesRadio(modifier: Modifier = Modifier, navController: NavController) {
    val juegos = listOf("Angry Birds", "Dragon Fly", "Hill Climbing Racing", "Pocket Soccer", "Radiant Defense")

    //Variables slider
    val rango = 0f..100f
    var selec by rememberSaveable  { mutableStateOf(30f) }
    val step = 3

    //Variable para la puntuacion, sobre 5
    val punt = (selec / 100 * 5).toInt() //Hace la conversion

    //Variable para el estado de los radio y uso de Toast
    var estadoRadio by rememberSaveable { mutableStateOf("")}
    val context = LocalContext.current




    Column(Modifier.fillMaxSize()) {
        Text("Elige una opción:", fontWeight = FontWeight.Bold)
            juegos.forEach { item ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = estadoRadio == item,
                            onClick = {estadoRadio = item},  //OJO, Actualiza el juego seleccionado
                            colors = RadioButtonDefaults.colors(
                                selectedColor = PGPrimario,
                                unselectedColor = sarahColor))
                    Text(text = item, fontWeight = FontWeight.Bold)

                }
            }

        Slider(
            value = selec,
            valueRange = rango,
            steps = step,
            onValueChange = {selec = it},
            modifier = Modifier.fillMaxWidth()
        )
        Text(text = selec.toString())   //Muestra el rango


        //Boton flotante. FAB
            FloatingActionButton(
                onClick = { if (estadoRadio.isEmpty()){
                                Toast.makeText(context, "No has pulsado ninguna opcion.",
                                Toast.LENGTH_LONG).show()
                                } else {
                                    val mensaje = "Has seleccionado $estadoRadio con una puntuación de $punt"
                                    Toast.makeText(context, mensaje, Toast.LENGTH_LONG).show()}},
                containerColor = sarahColor,
                modifier = Modifier.padding(10.dp)

            ) {
                Icon(
                    imageVector = Icons.Outlined.Add,
                    contentDescription = "add",
                    tint = Color.White
                )
                //FabPosition.End solo usar en Scaffold
        }
    }
}



