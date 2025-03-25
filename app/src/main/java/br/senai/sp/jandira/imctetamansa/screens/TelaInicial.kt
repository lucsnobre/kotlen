package br.senai.sp.jandira.bmi.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.imctetamansa.R

@Composable
fun TelaInicial(navController: NavHostController?) {

    var nomeState = remember {
        mutableStateOf(value = "")
    }

    var isErrorStatus = remember {
        mutableStateOf(value = false)
    }

    var errorMessageState = remember {
        mutableStateOf("")
    }

    // Variavel que guarda o contexto que estamos
    var context = LocalContext.current



    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    listOf(
                        Color(0xFF82E04C),
                        Color(0xFF669126)
                    )
                )
            ),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.haltere),
                contentDescription = stringResource(R.string.logo_description),
                modifier = Modifier
                    .padding(top = 32.dp)
            )
            Text(
                text = stringResource(R.string.welcome),
                fontSize = 48.sp,
                color = Color.White,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp),
                shape = RoundedCornerShape(
                    topStart = 32.dp,
                    topEnd = 32.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp)
                ) {
                    Column {
                        Text(
                            text = stringResource(R.string.your_name),
                            fontSize = 22.sp,
                            color = Color.Black,
                            fontFamily = FontFamily.Monospace
                        )
                        OutlinedTextField(
                            value = nomeState.value,
                            onValueChange = {nome ->
                                nomeState.value = nome
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp),
                            shape = RoundedCornerShape(12.dp),
                            label = { Text("Name") },
                            leadingIcon = {
                                Icon(
                                    imageVector =  Icons.Default.AccountBox,
                                    contentDescription = "",
                                    tint = Color(0xFF383131)
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                capitalization = KeyboardCapitalization.Sentences
                            ),
                            isError = isErrorStatus.value,
                            supportingText = {
                                Text(
                                    text = errorMessageState.value,
                                    color = Color.Red
                                )
                            }
                        )
                    }
                    Button(
                        onClick = {
                            if(nomeState.value.length < 3){
                                isErrorStatus.value = true
                                errorMessageState.value = context.getString(R.string.support_name)
                            } else{
                                // Criar o acesso a um arquivo SharedPreferences
                                val sharedNome = context
                                    .getSharedPreferences("usuarios",Context.MODE_PRIVATE)
                                // Criar uma variavel para editar o arquivo que acabamos de criar ou abrir
                                val editor = sharedNome.edit()
                                // Adiciona ao arquivo uma nova linha -> nome do usuario
                                editor.putString("user_name", nomeState.value.trim())
                                // Aplica de fato a informaçao dentro do arquivo
                                editor.apply()
                                navController?.navigate(route = "user_data")
                            }
                        },
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.next)
                        )
                        Icon(
                            imageVector = Icons.Filled.ArrowForward,
                            contentDescription = ""
                        )
                    }


                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun TelaInicialPreview() {
    TelaInicial(null)
}