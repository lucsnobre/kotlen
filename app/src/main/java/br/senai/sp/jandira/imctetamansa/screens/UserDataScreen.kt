package br.senai.sp.jandira.imctetamansa.screens

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AssistWalker
import androidx.compose.material.icons.filled.Balance
import androidx.compose.material.icons.filled.Height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.imctetamansa.R

@Composable
fun UserDataScreen(navController: NavHostController?) {

    var nomeAge = remember {
        mutableStateOf(value = "")
    }

    var nomeWeight = remember {
        mutableStateOf(value = "")
    }

    var nomeHeight = remember {
        mutableStateOf(value = "")
    }

    // Abrir o arquivo usuario.xml para recuperar o nome que o usuario digitou na tela anterior
    var context = LocalContext.current
    var sharedUserFile = context
        .getSharedPreferences("usuarios",Context.MODE_PRIVATE)
    val userName = sharedUserFile.getString("user_name","Name not found!")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    listOf(
                        Color(color = 0xFF82E04C),
                        Color(color = 0xFF669126)
                    )
                )
            ),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                    .weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.hi) + " $userName!",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
            }
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(5f),
                shape = RoundedCornerShape(
                    topStart = 32.dp,
                    topEnd = 32.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()

                    ) {
                        Column(
                            modifier = Modifier
                                .weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Card(
                                modifier = Modifier
                                    .size(100.dp),
                                shape = CircleShape,
                                border = BorderStroke(1.dp, Color(color = 0xFF5E8BBE)),
                                elevation = CardDefaults.cardElevation(2.dp)
                            )
                            {
                                Image(
                                    painter = painterResource(id = R.drawable.profile),
                                    contentDescription = stringResource(R.string.male),
                                    modifier = Modifier
                                        .padding(1.dp)
                                )
                            }
                            Button(
                                onClick = {},
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp, vertical = 4.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(color = 0xFF03A9F4)
                                )
                            ) {
                                Text(text = stringResource(R.string.male))
                            }
                        }
                        Column(
                            modifier = Modifier
                                .weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Card(
                                modifier = Modifier
                                    .size(100.dp),
                                shape = CircleShape,
                                border = BorderStroke(1.dp, Color(color = 0xFFEF9106)),
                                elevation = CardDefaults.cardElevation(2.dp)
                            )
                            {
                                Image(
                                    painter = painterResource(id = R.drawable.woman),
                                    contentDescription = stringResource(R.string.female),
                                    modifier = Modifier
                                        .padding(1.dp)
                                )
                            }
                            Button(
                                onClick = {},
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp, vertical = 4.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(color = 0xFFE91E63)
                                )
                            ) {
                                Text(text = stringResource(R.string.female))
                            }
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        OutlinedTextField(
                            value = nomeAge.value,
                            onValueChange = {nome ->
                                nomeAge.value = nome
                            },
                            modifier = Modifier
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            label = { Text(text = stringResource(R.string.age)) },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.AssistWalker,
                                    contentDescription = "",
                                    tint = Color(color = 0xFF82E04C)
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            ),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color(color = 0xFFEF9106),
                                cursorColor = Color(color = 0xFFEF9106)
                            ),
                            textStyle = TextStyle(fontSize = 24.sp)
                        )
                        OutlinedTextField(
                            value = nomeWeight.value,
                            onValueChange = {nome ->
                                nomeWeight.value = nome
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 12.dp),
                            shape = RoundedCornerShape(16.dp),
                            label = { Text(text = stringResource(R.string.weight)) },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Balance,
                                    contentDescription = "",
                                    tint = Color(color = 0xFF82E04C)
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            ),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color(color = 0xFF82E04C),
                                cursorColor = Color(color = 0xFF82E04C)
                            ),
                            textStyle = TextStyle(fontSize = 24.sp)
                        )
                        OutlinedTextField(
                            value = nomeHeight.value,
                            onValueChange = {nome ->
                                nomeHeight.value = nome
                            },
                            modifier = Modifier
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            label = { Text(text = stringResource(R.string.height)) },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Height,
                                    contentDescription = "",
                                    tint = Color(color = 0xFF82E04C)
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Decimal,
                                imeAction = ImeAction.Done
                            ),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color(color = 0xFF82E04C),
                                cursorColor = Color(color = 0xFF82E04C)
                            ),
                            textStyle = TextStyle(fontSize = 24.sp)
                        )
                    }
                    Button(
                        onClick = {
                            val editor = sharedUserFile.edit()
                            editor.putInt("user_age",nomeAge.value.trim().toInt())
                            editor.putInt("user_weight",nomeWeight.value.trim().toInt())
                            editor.putInt("user_height",nomeHeight.value.trim().toInt())
                            editor.apply()
                            navController?.navigate(
                                route = "result_screen"
                            )},
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(color = 0xFF669126)
                        )
                    ) {
                        Text(modifier = Modifier
                            .fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            text = stringResource(R.string.calculate),
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp
                        )

                    }
                }
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun UserDataScreenPreview() {
    UserDataScreen(navController = null)
}