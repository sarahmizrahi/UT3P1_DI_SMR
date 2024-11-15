package com.example.playjuegossmr_ut2p2.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

//COLORES OSCUROS
private val PGDarkColorScheme = darkColorScheme(
    primary = PGPrimario,
    secondary = PGSecundario,
    background = PGFondoOscuro,
    surface = PGFondoOscuro,    //Color para superficies
    //Para textos
    //onPrimaryContainer = PGTitulo,
    onPrimary = PGTextoClaro,
    onSecondary = PGTextoClaro,
    onBackground = PGTitulo,
    onSurface = PGTextoClaro,
)

//COLORES CLAROS
private val PGLightColorScheme = lightColorScheme(
    primary = PGPrimario,
    secondary = PGSecundario,
    background = PGFondoClaro,
    surface = PGFondoClaro,    //Color para superficies
    //Para textos
    onPrimary = PGTextoOscuro,
    onSecondary = PGTextoOscuro,
    onBackground = PGTextoOscuro,
    onSurface = PGTextoOscuro,
)

//FUNCION
@Composable
fun TemaPlayJuegosPersonal(
    darkTheme: Boolean = isSystemInDarkTheme(),/*Permite que el tema decida si usa esquema claro y oscuro,
                                                por defecto esta en oscuro*/
    dynamicColor: Boolean = true,   //Permite usar colores dinamicos
    content: @Composable () -> Unit //Representa el contenido de la app
    ){
    val colorScheme = when {
        dynamicColor -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> PGDarkColorScheme
        else -> PGLightColorScheme
    }

    //Aqui se define que estilos se va a utilizar
    MaterialTheme(
        colorScheme = PGDarkColorScheme,
        typography = Typography,
        content = content
    )
}