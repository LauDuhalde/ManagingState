package com.example.littlelemonlogin

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.littlelemonlogin.ui.theme.LittleLemonLoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonLoginTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview(){
    LoginScreen()
}

@Composable
fun LoginScreen(){
    val context = LocalContext.current

    /*
    Las variables username y password se definen con un mutable TextFieldValue.
    En cada TextField, el valor de la propiedad value se establece en la variable creada
    anteriormente. A continuación, a la propiedad onValueChange se le asigna una función
    lambda que actualiza la variable correspondiente para ese campo de entrada.
     */
    var username by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var password by remember {
        mutableStateOf(TextFieldValue(""))
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.littlelemonlogo),
            contentDescription = "Logo Image",
            modifier = Modifier.padding(10.dp)
        )
        TextField(
            value = username,
            onValueChange = {
                username = it
            },
            label = { Text(text = "Username") },
            modifier = Modifier.padding(10.dp)
        )
        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.padding(10.dp),
        )
        Button(
            /*
            A la propiedad onClick del botón se le asigna una función lambda que realiza
            la comprobación de verificación y muestra una notificación de Toast.
             */
            onClick = {
                Log.d("AAA", "${username.text}")
                Log.d("AAA", "${password.text}")
                if(username.text == "darian"
                    && password.text=="littlelemon"
                ){
                    Toast.makeText(context,
                        "Welcome to Little Lemon!",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(context,
                        "Invalid credentials."
                                + "Please try again.",
                        Toast.LENGTH_LONG
                    ).show()
                }
            },
            colors = ButtonDefaults.buttonColors(
                Color(0xFF495E57)
            ),
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                text = "Login",
                color = Color(0xFFEDEFEE)
            )
        }
    }
}