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
import androidx.compose.material.icons.filled.Numbers
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
fun UserDataScreen(
    navController: NavHostController?
) {
    val context = LocalContext.current
    val ageState = remember {
        mutableStateOf(value = "")
    }
    val weightState = remember {
        mutableStateOf(value = "")
    }
    val heightState = remember {
        mutableStateOf(value = "")
    }


    val isErrorStateInputAge = remember {
        mutableStateOf(value = false)
    }
    val erroMessageStateAge = remember {
        mutableStateOf(value = "")
    }

    val isErrorStateInputWeight = remember {
        mutableStateOf(value = false)
    }
    val erroMessageStateWeight = remember {
        mutableStateOf(value = "")
    }

    val isErrorStateInputHeight = remember {
        mutableStateOf(value = false)
    }
    val erroMessageStateHeight = remember {
        mutableStateOf(value = "")
    }

    // Abre o arquivo usuario.xml
    // E pega seus dados
    val sharedUserFile = context
        .getSharedPreferences(
            "user",
            Context.MODE_PRIVATE
        )

    val editor = sharedUserFile.edit()


    val userName = sharedUserFile.getString(
        "user_name",
        "Name not found!"
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    listOf(
                        Color(0xFF5608A4),
                        Color(0xFFBA88FF)
                    )
                )
            )
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ){

            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(10.dp),
                text = stringResource(R.string.titleHi) + " $userName!",
                fontSize = 48.sp,
                color = Color.White,

                )
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(9f)
                    .padding(0.dp, 32.dp, 0.dp, 0.dp),
                colors = CardDefaults.cardColors(Color(0xFFffffff)),
                shape = RoundedCornerShape(48.dp, 48.dp)

            ){
                Column (
                    modifier = Modifier
                        .padding(32.dp)
                        .weight(1f),
                    verticalArrangement = Arrangement.SpaceAround
                ){
                    Row (
                        modifier = Modifier
                            .padding(0.dp, 10.dp),
                    ){
                        Column (
                            modifier = Modifier
                                .weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Card (
                                modifier = Modifier
                                    .size(130.dp),
                                shape = CircleShape,
                                border = BorderStroke(
                                    2.dp,
                                    brush = Brush.linearGradient(
                                        listOf(
                                            Color(0xFF5608A4),
                                            Color(0xFFBA88FF)
                                        )
                                    )),
                                elevation = CardDefaults.elevatedCardElevation(5.dp)
                            ){
                                Image(
                                    painter = painterResource(id = R.drawable.profile),
                                    contentDescription = stringResource(R.string.logo_description),
                                    modifier = Modifier
                                        .padding(top = 32.dp)
                                        .fillMaxSize()

                                )
                            }
                            Button(
                                onClick = {},
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp, 5.dp),
                                border = BorderStroke(
                                    1.dp,
                                    brush = Brush.linearGradient(
                                        listOf(
                                            Color(0xFF5608A4),
                                            Color(0xFFBA88FF)
                                        )
                                    )),
                                elevation = ButtonDefaults.buttonElevation(5.dp),
                                colors = ButtonDefaults.buttonColors(Color(0xFF5608A4))
                            ) {
                                Text(
                                    text = stringResource(R.string.buttonMale)
                                )
                            }
                        }
                        Column (
                            modifier = Modifier
                                .weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Card (
                                modifier = Modifier
                                    .size(130.dp),
                                shape = CircleShape,
                                border = BorderStroke(
                                    2.dp,
                                    brush = Brush.linearGradient(
                                        listOf(
                                            Color(0xFF5608A4),
                                            Color(0xFFBA88FF)
                                        )
                                    )),
                                elevation = CardDefaults.elevatedCardElevation(5.dp)
                            ){
                                Image(
                                    painter = painterResource(id = R.drawable.woman),
                                    contentDescription = stringResource(R.string.logo_description),
                                    modifier = Modifier
                                        .padding(top = 32.dp)
                                        .fillMaxSize()
                                )
                            }
                            Button(
                                onClick = {},
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp, 5.dp),
                                border = BorderStroke(
                                    1.dp,
                                    brush = Brush.linearGradient(
                                        listOf(
                                            Color(0xFF5608A4),
                                            Color(0xFFBA88FF)
                                        )
                                    )),
                                elevation = ButtonDefaults.buttonElevation(5.dp),
                                colors = ButtonDefaults.buttonColors(Color(0xFF5608A4))
                            ){
                                Text(
                                    text = stringResource(R.string.buttonFemale)
                                )
                            }
                        }
                    }
                    Column (
                        modifier = Modifier
                            .padding(0.dp, 10.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ){
                        OutlinedTextField(
                            value = ageState.value,
                            onValueChange = {
                                ageState.value = it
                            },
                            modifier = Modifier
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            label = {
                                Text(
                                    text = stringResource(R.string.Age)
                                )
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Numbers,
                                    contentDescription = "",
                                    tint = Color(0xFF5608A4)
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            ),
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedLabelColor = Color(0xFFBA88FF),
                                cursorColor = Color(0xFFBA88FF)
                            ),
                            isError = isErrorStateInputAge.value,
                            supportingText = {
                                Text(
                                    text = erroMessageStateAge.value,
                                    color = Color.Red
                                )
                            }
                        )
                        OutlinedTextField(
                            value = weightState.value,
                            onValueChange = {
                                weightState.value = it
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(0.dp, 30.dp),
                            shape = RoundedCornerShape(16.dp),
                            label = {
                                Text(
                                    text = stringResource(R.string.Weight)
                                )
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Balance,
                                    contentDescription = "",
                                    tint = Color(0xFF5608A4)
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            ),
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedLabelColor = Color(0xFFBA88FF),
                                cursorColor = Color(0xFFBA88FF)
                            ),
                            isError = isErrorStateInputWeight.value,
                            supportingText = {
                                Text(
                                    text = erroMessageStateWeight.value,
                                    color = Color.Red
                                )
                            }
                        )
                        OutlinedTextField(
                            value = heightState.value,
                            onValueChange = {
                                heightState.value = it
                            },
                            modifier = Modifier
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            label = {
                                Text(
                                    text = stringResource(R.string.Height)
                                )
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Height,
                                    contentDescription = "",
                                    tint = Color(0xFF5608A4)
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Decimal,
                                imeAction = ImeAction.Done
                            ),
                            colors = OutlinedTextFieldDefaults.colors(
                                cursorColor = Color(0xFFBA88FF),
                                unfocusedLabelColor = Color(0xFFBA88FF)
                            ),
                            isError = isErrorStateInputHeight.value,
                            supportingText = {
                                Text(
                                    text = erroMessageStateHeight.value,
                                    color = Color.Red
                                )
                            }
                        )
                    }

                    Button(
                        onClick = {
                            if (ageState.value.length == 0){
                                isErrorStateInputAge.value = true
                                erroMessageStateAge.value = context.getString(R.string.supportEmptyField)

                            }else if(weightState.value.length == 0){
                                isErrorStateInputWeight.value = true
                                erroMessageStateWeight.value = context.getString(R.string.supportEmptyField)

                            }else if(heightState.value.length == 0){
                                isErrorStateInputHeight.value = true
                                erroMessageStateHeight.value = context.getString(R.string.supportEmptyField)

                            }else if (ageState.value.toIntOrNull() == null){
                                isErrorStateInputAge.value = true
                                erroMessageStateAge.value = context.getString(R.string.supportTextFieldForInt)

                            }else if(weightState.value.toIntOrNull() == null){
                                isErrorStateInputWeight.value = true
                                erroMessageStateWeight.value = context.getString(R.string.supportTextFieldForInt)

                            }else if(heightState.value.toIntOrNull() == null){
                                isErrorStateInputHeight.value = true
                                erroMessageStateHeight.value = context.getString(R.string.supportTextFieldForInt)

                            }else{
                                isErrorStateInputAge.value = false
                                isErrorStateInputWeight.value = false
                                isErrorStateInputHeight.value = false




                                editor.putInt("user_age", ageState.value.trim().toInt())
                                editor.putInt("user_weight", weightState.value.trim().toInt())
                                editor.putInt("user_height", heightState.value.trim().toInt())
                                editor.apply()

                                navController?.navigate("result_screen")
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth(),
                        border = BorderStroke(
                            1.dp,
                            brush = Brush.linearGradient(
                                listOf(
                                    Color(0xFF5608A4),
                                    Color(0xFFBA88FF)
                                )
                            )),
                        elevation = ButtonDefaults.buttonElevation(5.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFF5608A4)),
                        shape = RoundedCornerShape(10.dp)
                    )  {
                        Text(
                            text = stringResource(R.string.buttonCalculate),
                            fontSize = 28.sp,
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
    UserDataScreen(null)
}