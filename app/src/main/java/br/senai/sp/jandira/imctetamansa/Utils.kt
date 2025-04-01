package br.senai.sp.jandira.imctetamansa

import br.senai.sp.jandira.imctetamansa.model.BmiStatus
import java.util.Locale

fun numberFormat(number: Double) =
    String.format(
        Locale.getDefault(),
        "%.1f",
        number
    )
fun isFilled(userStatus: BmiStatus, status: BmiStatus) =
    if(userStatus == status) true else false