package br.senai.sp.jandira.bmi.screens

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Card
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
import androidx.compose.ui.text.font.FontWeight
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

    var erroState = remember{
        mutableStateOf(false)
    }

    var errorMessageState = remember{
        mutableStateOf("")
    }

    var context = LocalContext.current


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    listOf(
                        Color(0xff30A345), Color(0xff54C468)
                    )
                )
            ), contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.haltere),
                contentDescription = stringResource(R.string.logo_description),
                modifier = Modifier.padding(top = 50.dp)
            )
            Text(
                text = stringResource(R.string.welcome),
                fontSize = 40.sp,
                color = Color.White,
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(450.dp), shape = RoundedCornerShape(
                    topStart = 32.dp, topEnd = 32.dp
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = stringResource(R.string.your_name),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                        OutlinedTextField(value = nomeState.value,
                            onValueChange = {
                                nomeState.value = it
                            },
                            modifier = Modifier
                                .padding(start = 20.dp, top = 10.dp)
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            label = {
                                Text(text = stringResource(R.string.your_name_here))
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.AccountCircle,
                                    contentDescription = "",
                                    tint = Color(0xff54C468)
                                )
                            },
                            isError = erroState.value,
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
                                erroState.value = true
                                errorMessageState.value = context.getString(R.string.suport_name)
                            }else {
                                navController?.navigate("user_data")
                            }
                        },
                        shape = RoundedCornerShape(12.dp)

                    ) {
                        Text(
                            text = stringResource(R.string.next)
                        )
                        Icon(
                            imageVector = Icons.Filled.ArrowForward, contentDescription = ""
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