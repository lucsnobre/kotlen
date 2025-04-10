package br.senai.sp.jandira.imctetamansa.screens

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import java.util.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.imctetamansa.model.BmiStatus
import br.senai.sp.jandira.imctetamansa.R
import br.senai.sp.jandira.imctetamansa.calc.bmiCalculator
import br.senai.sp.jandira.imctetamansa.components.BmiLevel
import br.senai.sp.jandira.imctetamansa.isFilled
import br.senai.sp.jandira.imctetamansa.numberFormat

@Composable
fun BMIResultScreen(
    navController: NavHostController?
) {
    val context = LocalContext.current
    val sharedUserFile = context
        .getSharedPreferences(
            "user",
            Context.MODE_PRIVATE
        )

    val userAge = sharedUserFile.getInt(
        "user_age",
        0
    )
    val userWeight = sharedUserFile.getInt(
        "user_weight",
        0
    )
    val userHeight = sharedUserFile.getInt(
        "user_height",
        0
    ).toDouble()
    val bmiResult = bmiCalculator(userHeight, userWeight)

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
                    .padding(20.dp),
                text = stringResource(R.string.titleYourBMIResult),
                fontSize = 34.sp,
                color = Color.White,

                )
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(9f)
                    .padding(0.dp, 10.dp, 0.dp, 0.dp),
                colors = CardDefaults.cardColors(Color(0xFFffffff)),
                shape = RoundedCornerShape(48.dp, 48.dp)

            ){
                Column (
                    modifier = Modifier
                        .padding(32.dp, 0.dp, 32.dp, 32.dp)
                        .weight(1f),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){

                    Column (
                        modifier = Modifier,
                        verticalArrangement = Arrangement.SpaceAround,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Card(
                            modifier = Modifier
                                .size(140.dp),
                            shape = CircleShape,
                            colors = CardDefaults.cardColors(Color(0xFFffffff)),
                            border = BorderStroke(
                                5.dp,
                                color = bmiResult.color
                            ),
                            elevation = CardDefaults.elevatedCardElevation(5.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize(),
                                verticalArrangement = Arrangement.SpaceAround,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = String.format(
                                        Locale.getDefault(),
                                        "%.1f",
                                        bmiResult.bmi.second
                                    ),
                                    fontSize = 40.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }

                        }
                        Text(
                            text = bmiResult.bmi.first,
                            fontSize = 28.sp,
                        )
                        Card (
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(90.dp),
                            colors = CardDefaults.cardColors(Color(0x9FA7A0AF)),
                            shape = RoundedCornerShape(20.dp)
                        ){
                            Row (
                                modifier = Modifier
                                    .fillMaxSize()
                                    .height(100.dp)
                                    .padding(10.dp),
                                horizontalArrangement = Arrangement.SpaceAround
                            ){
                                Column(
                                    modifier = Modifier
                                        .fillMaxHeight(),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.SpaceAround
                                ) {
                                    Text(
                                        text = stringResource(R.string.Age),
                                        fontSize = 20.sp,
                                    )
                                    Text(
                                        text = "$userAge",
                                        fontSize = 22.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                                VerticalDivider()
                                Column (
                                    modifier = Modifier
                                        .fillMaxHeight(),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.SpaceAround
                                ){
                                    Text(
                                        text = stringResource(R.string.Weight),
                                        fontSize = 20.sp,
                                    )
                                    Text(
                                        text = "$userWeight Kg",
                                        fontSize = 22.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                                VerticalDivider()
                                Column(
                                    modifier = Modifier
                                        .fillMaxHeight(),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.SpaceAround
                                ) {
                                    Text(
                                        text = stringResource(R.string.Height),
                                        fontSize = 20.sp,
                                    )
                                    Text(
                                        text = String.format(
                                            Locale.getDefault(),
                                            "%.2f",
                                            userHeight.div(100)
                                        ),
                                        fontSize = 22.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }
                    }

                    //

                    BmiLevel(
                        markColor = colorResource(R.color.light_blue),
                        isFilled = isFilled(bmiResult.bmiStatus, BmiStatus.UNDERWEIGHT),
                        textRight = stringResource(R.string.under_weight_table),
                        textLeft = "< ${numberFormat(18.5)}"
                    )
                    BmiLevel(
                        markColor = colorResource(R.color.light_green),
                        isFilled = isFilled(bmiResult.bmiStatus, BmiStatus.NORMAL),
                        textRight = stringResource(R.string.normal_weight_table),
                        textLeft = "${numberFormat(18.6)} - ${numberFormat(24.9)}"
                    )
                    BmiLevel(
                        markColor = colorResource(R.color.yellow),
                        isFilled = isFilled(bmiResult.bmiStatus, BmiStatus.OVERWEIGHT),
                        textRight = stringResource(R.string.over_weigh_tablet),
                        textLeft = "${numberFormat(25.0)} - ${numberFormat(29.9)}"
                    )
                    BmiLevel(
                        markColor = colorResource(R.color.light_orange),
                        isFilled = isFilled(bmiResult.bmiStatus, BmiStatus.OBESITY1),
                        textRight = stringResource(R.string.class1_weight_table),
                        textLeft = "${numberFormat(30.0)} - ${numberFormat(34.9)}"
                    )
                    BmiLevel(
                        markColor = colorResource(R.color.dark_orange),
                        isFilled = isFilled(bmiResult.bmiStatus, BmiStatus.OBESITY2),
                        textRight = stringResource(R.string.class2_weight_table),
                        textLeft = "${numberFormat(35.5)} - ${numberFormat(40.0)}"
                    )
                    BmiLevel(
                        markColor = colorResource(R.color.red),
                        isFilled = isFilled(bmiResult.bmiStatus, BmiStatus.OBESITY3),
                        textRight = stringResource(R.string.class3_weight_table),
                        textLeft = "> ${numberFormat(40.0)}"
                    )

                    HorizontalDivider()



                    Button(
                        onClick = {
                            navController?.navigate("home")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        border = BorderStroke(
                            2.dp,
                            brush = Brush.linearGradient(
                                listOf(
                                    Color(0xFF9DE134),
                                    Color(0xFF9DE134)
                                )
                            )),
                        elevation = ButtonDefaults.buttonElevation(5.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFF9DE134)),
                        shape = RoundedCornerShape(10.dp)
                    ){
                        Text(
                            text = stringResource(R.string.buttonNewCalc),
                            fontSize = 30.sp,
                        )
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun BMIResultScreenPreview() {
    BMIResultScreen(null)
}