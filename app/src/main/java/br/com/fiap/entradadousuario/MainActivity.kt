package br.com.fiap.entradadousuario

import android.os.Bundle
import android.text.method.SingleLineTransformationMethod
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.entradadousuario.ui.theme.EntradaDoUsuarioTheme
import kotlin.math.log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EntradaDoUsuarioTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {

    var texto by remember {
        mutableStateOf("")
    }
    var idade by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var kotlin by remember {
        mutableStateOf(false)
    }
    var java by remember {
        mutableStateOf(false)
    }
    var csharp by remember {
        mutableStateOf(false)
    }

    Column(modifier = Modifier.padding(32.dp)) {
        TextField(
            value = texto,
            onValueChange = {letra ->
                texto = letra

            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "qual o seu nome?")
            },
            placeholder = {
                Text(text = "nome e sobrenome")
            },
            trailingIcon = {
                Icon(painter = painterResource(id = R.drawable.settings_24),
                    contentDescription = "ícone de configuração" )
            },
            leadingIcon = {
                Icon(painter = painterResource(id = R.drawable.person_24),
                    contentDescription = "ícone de usuário" )
            }
        )


        TextField(
            value = idade,
            onValueChange = {letra ->
                idade = letra

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            label = {
                Text(text = "qual a sua idade?")
            },
            placeholder = {
                Text(text = "digite o número")
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "ícone home"
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            textStyle = TextStyle(color = Color.Red,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End
            ),
            colors = TextFieldDefaults.colors())


        Spacer(modifier = Modifier.height(32.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            label = {
                Text(text = "qual o seu email?")
            },
            placeholder = {
                Text(text = "digite o seu email")
            }
        )
        Spacer(modifier = Modifier.height(32.dp))
        Row(verticalAlignment = Alignment.CenterVertically ) {
            Checkbox(checked = kotlin, onCheckedChange = {
                kotlin = it
            })
            Text(text = "Kotlin")
        }
        Row(verticalAlignment = Alignment.CenterVertically ) {
            Checkbox(checked = csharp, onCheckedChange = {
                csharp = it
            })
            Text(text = "Csharp")
        }
        Row(verticalAlignment = Alignment.CenterVertically ) {
            Checkbox(checked = java, onCheckedChange = {
                java = it
            })
            Text(text = "java")
        }
        Spacer(modifier = Modifier.height(32.dp))

        var linguagemSelecionada by remember {
            mutableStateOf(0)
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = linguagemSelecionada == 0,
                onClick = { linguagemSelecionada = 0 },
                colors = RadioButtonDefaults.colors(selectedColor = Color.Yellow, unselectedColor = Color.Blue)
            )
            Text(text = "windows")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = linguagemSelecionada == 1,
                onClick = { linguagemSelecionada = 1 },
                colors = RadioButtonDefaults.colors(selectedColor = Color.Yellow, unselectedColor = Color.Blue)
            )
            Text(text = "linux")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = linguagemSelecionada == 2,
                onClick = { linguagemSelecionada = 2 },
                colors = RadioButtonDefaults.colors(selectedColor = Color.Yellow, unselectedColor = Color.Blue)
            )
            Text(text = "mac")
        }
        Spacer(modifier = Modifier.height(32.dp))
        Row(horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.size(width = 200.dp, height = 130.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor =  Color(0xFFDB3636),
                    contentColor = Color(0xFF021163)
                ),
                border = BorderStroke(4.dp, Color(0xff123456)),
                shape = CircleShape
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                Icon(imageVector = Icons.Default.Share, contentDescription = "Share")
                Text(text = "clique-me")

                }
            }
        }
    }

}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    EntradaDoUsuarioTheme {
        Greeting()
    }
}