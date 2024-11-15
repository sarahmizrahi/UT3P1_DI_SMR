package com.example.playjuegossmr_ut2p2

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.playjuegossmr_ut2p2.ui.theme.PGTextoClaro
import com.example.playjuegossmr_ut2p2.ui.theme.colorBoton

//Color personalizado
val sarahColor = Color(0xFF960E42)

@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
@Composable
fun MenuPlayer(modifier: Modifier = Modifier, navController: NavController) //Parametros para que innerPadding funiones en el main
{
    //Variable para controlar error de los campos nombre y nickname
    var nameError by remember { mutableStateOf(false) }

    //Variables para TextField
    //Crear una para cada campo, de lo contrario, al compartir variable se escribe lo mismo en todos los campos
    var nombre by remember { mutableStateOf("") }
    var apellidos by remember { mutableStateOf("") }
    var nick by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

//Variables para las propiedades de los TextField para VERTICAL
    val tamañoVert = Modifier
        .width(230.dp)
        .height(60.dp)
//Variables para las propiedades de los TextField para HORIZONTAL
    val tamañoHoriz = Modifier
        .width(600.dp)
        .height(60.dp)
    //Colores, para ambas orientaciones
    val colores = TextFieldDefaults.colors(
        focusedContainerColor = sarahColor,  //Color fondo campo al clicar
        unfocusedContainerColor = sarahColor,  //Color fondo campo
        cursorColor = Color.White  //Color cursor
    )


    //Orientacion
    val configuration = LocalConfiguration.current  //Obtiene la orientacion actual

    when (configuration.orientation) {  //Cuando la orientacion es
        Configuration.ORIENTATION_PORTRAIT -> {    //Vertical

            Column(modifier = modifier) {
                //Nombre
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.End //Alinear final derecha
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.account), //Ruta imagen
                        contentDescription = "account",     //Nombre
                        modifier = Modifier.requiredSize(60.dp),    //Tamaño

                    )
                    //Espacio
                    Spacer(30)

                    Column {
                        TextField(
                            value = nombre,
                            onValueChange = {
                                nombre = it
                                nameError = false //Resetea el estado de error cuando el usuario escribe algo
                                },
                            label = {Text("Nombre",color = PGTextoClaro)},
                            isError = nameError,
                            colors = colores,   //Color del textField
                            modifier = tamañoVert
                        )
                        // Texto de ayuda o de error
                        val assistiveElementText = if (nameError) "Error: Obligatorio" else ""
                        val assistiveElementColor = if (nameError) {
                            Color.Red
                        } else {
                            sarahColor //Color de texto cuando no hay error
                        }

                        Text(
                            text = assistiveElementText,
                            color = assistiveElementColor,
                        )
                    }



                }
                //Apellido
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.End //Alinear final derecha
                ) {
                    TextField(
                        value = apellidos,
                        onValueChange = { apellidos = it },
                        label = { Text("Apellido", color = PGTextoClaro) },
                        colors = colores,
                        modifier = tamañoVert
                    )
                }

                //Nickname
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.End //Alinear final derecha
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.emoji), //Ruta imagen
                        contentDescription = "emoji",     //Nombre
                        modifier = Modifier.requiredSize(60.dp),    //Tamaño
                    )

                    //Espacio
                    Spacer(30)

                    Column {
                        TextField(
                            value = nick,
                            onValueChange = {
                                nick = it
                                nameError = false //Resetea el estado de error cuando el usuario escribe algo
                            },
                            label = {Text("Nickname",color = PGTextoClaro)},
                            isError = nameError,
                            colors = colores,   //Color del textField
                            modifier = tamañoVert
                        )
                        // Texto de ayuda o de error
                        val assistiveElementText = if (nameError) "Error: Obligatorio" else ""
                        val assistiveElementColor = if (nameError) {
                            Color.Red
                        } else {
                            sarahColor //Color de texto cuando no hay error
                        }

                        Text(
                            text = assistiveElementText,
                            color = assistiveElementColor,
                        )
                    }
                }

                //Espacio
                Spacer(15)

                //Aqui va el icono android y el boton
                Row(
                    modifier = Modifier
                        .align(Alignment.End),
                    verticalAlignment = Alignment.CenterVertically  //Alinea el el boton con la imagen
                )
                {
                    //Icono android
                    Image(
                        painter = painterResource(id = R.drawable.android), //Ruta imagen
                        contentDescription = "android",     //Nombre
                        modifier = Modifier.requiredSize(100.dp),    //Tamaño
                    )

                    //Espacio
                    Spacer(30)

                    //Boton
                    Button(
                        //Para cambiar solo el color del fondo del boton
                        colors = ButtonDefaults.buttonColors(containerColor = colorBoton),

                        onClick = { },
                        shape = RoundedCornerShape(50), //Redondea los bordes
                        modifier = Modifier
                            .width(150.dp)  //Ancho del boton
                            .padding(end = 10.dp)   //Alinear con los textos
                    ) {
                        Text(text = "Preferences")

                    }
                }

                //Espacio
                Spacer(20)

                //Telefono
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.End //Alinear final derecha
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.phone), //Ruta imagen
                        contentDescription = "phone",     //Nombre
                        modifier = Modifier.requiredSize(60.dp),    //Tamaño
                    )

                    //Espacio
                    Spacer(30)

                    TextField(
                        value = telefono,
                        onValueChange = {telefono = it},
                        label = { Text("Teléfono", color = PGTextoClaro) },
                        colors = colores,
                        modifier = tamañoVert
                    )
                }

                //Email
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.End //Alinear final derecha
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.email), //Ruta imagen
                        contentDescription = "email",     //Nombre
                        modifier = Modifier.requiredSize(60.dp),    //Tamaño
                    )

                    //Espacio
                    Spacer(30)

                    TextField(
                        value = email,
                        onValueChange = {email = it},
                        label = { Text("E-mail", color = PGTextoClaro) },
                        colors = colores,
                        modifier = tamañoVert
                    )
                }
                //Boton Añadir jugador
                Button(
                    //Para cambiar solo el color del fondo del boton
                    colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                    onClick =  {
                        nameError = nombre.isBlank() && nick.isBlank() //Configura el error si el nombre y nick estan en blanco
                    },
                    shape = RoundedCornerShape(30), //Redondea los bordes
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text(text = "Add new player")

                }
            }
        }


//-----------------------------------------------------------------------------------------------------------
        //Horizontal
        else -> {
            Column(modifier = Modifier
                .padding(16.dp)
                .verticalScroll(rememberScrollState())) {

                //Nombre
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.End //Alinear final derecha
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.account), //Ruta imagen
                        contentDescription = "account",     //Nombre
                        modifier = Modifier.requiredSize(60.dp),    //Tamaño

                    )
                    //Espacio
                    Spacer(30)
                    Column {
                        TextField(
                            value = nombre,
                            onValueChange = {
                                nombre = it
                                nameError = false //Resetea el estado de error cuando el usuario escribe algo
                            },
                            label = {Text("Nombre",color = PGTextoClaro)},
                            isError = nameError,
                            colors = colores,   //Color del textField
                            modifier = tamañoHoriz
                        )
                        // Texto de ayuda o de error
                        val assistiveElementText = if (nameError) "Error: Obligatorio" else ""
                        val assistiveElementColor = if (nameError) {
                            Color.Red
                        } else {
                            sarahColor //Color de texto cuando no hay error
                        }

                        Text(
                            text = assistiveElementText,
                            color = assistiveElementColor,
                        )
                    }
                }
                //Apellido
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.End //Alinear final derecha
                ) {
                    TextField(
                        value = apellidos,
                        onValueChange = { apellidos = it },
                        label = { Text("Apellido", color = PGTextoClaro) },
                        colors = colores,
                        modifier = tamañoHoriz
                    )
                }

                //Nickname
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.End //Alinear final derecha
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.emoji), //Ruta imagen
                        contentDescription = "emoji",     //Nombre
                        modifier = Modifier.requiredSize(60.dp),    //Tamaño
                    )

                    //Espacio
                    Spacer(30)

                    Column {
                        TextField(
                            value = nick,
                            onValueChange = {
                                nick = it
                                nameError = false //Resetea el estado de error cuando el usuario escribe algo
                                },
                            label = {Text("Nickname",color = PGTextoClaro)},
                            isError = nameError,
                            colors = colores,   //Color del textField
                            modifier = tamañoHoriz
                        )
                        // Texto de ayuda o de error
                        val assistiveElementText = if (nameError) "Error: Obligatorio" else ""
                        val assistiveElementColor = if (nameError) {
                            Color.Red
                        } else {
                            sarahColor //Color de texto cuando no hay error
                        }

                        Text(
                            text = assistiveElementText,
                            color = assistiveElementColor,
                        )
                    }
                }

                //Espacio
                Spacer(15)

                //Aqui va el icono android y el boton
                Row(
                    modifier = Modifier
                        .align(Alignment.End),
                    verticalAlignment = Alignment.CenterVertically  //Alinea el el boton con la imagen
                )
                {
                    //Icono android
                    Image(
                        painter = painterResource(id = R.drawable.android), //Ruta imagen
                        contentDescription = "android",     //Nombre
                        modifier = Modifier.requiredSize(100.dp),    //Tamaño
                    )

                    //Espacio
                    Spacer(100)

                    //Boton
                    Button(
                        //Para cambiar solo el color del fondo del boton
                        colors = ButtonDefaults.buttonColors(containerColor = colorBoton),

                        onClick = { }, //Si no lo pongo me da error, espera una accion
                        shape = RoundedCornerShape(50), //Redondea los bordes
                        modifier = Modifier
                            .width(300.dp)  //Ancho del boton
                            .padding(end = 10.dp)   //Alinear con los textos
                    ) {
                        Text(text = "Preferences")

                    }
                }

                //Espacio
                Spacer(50)

                //Telefono
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.End //Alinear final derecha
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.phone), //Ruta imagen
                        contentDescription = "phone",     //Nombre
                        modifier = Modifier.requiredSize(60.dp),    //Tamaño
                    )

                    //Espacio
                    Spacer(30)

                    TextField(
                        value = telefono,
                        onValueChange = {telefono = it},
                        label = { Text("Teléfono", color = PGTextoClaro) },
                        colors = colores,
                        modifier = tamañoHoriz
                    )
                }

                //Email
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.End //Alinear final derecha
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.email), //Ruta imagen
                        contentDescription = "email",     //Nombre
                        modifier = Modifier.requiredSize(60.dp),    //Tamaño
                    )

                    //Espacio
                    Spacer(30)

                    TextField(
                        value = email,
                        onValueChange = {email = it},
                        label = { Text("E-mail", color = PGTextoClaro) },
                        colors = colores,
                        modifier = tamañoHoriz
                    )
                }
                //Boton Añadir jugador
                Button(
                    //Para cambiar solo el color del fondo del boton
                    colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                    onClick =  {
                        nameError = nombre.isBlank() && nick.isBlank() //Configura el error si el nombre y nick estan en blanco
                    },
                    shape = RoundedCornerShape(30), //Redondea los bordes
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text(text = "Add new player")

                }
            }
        }
    }
}


