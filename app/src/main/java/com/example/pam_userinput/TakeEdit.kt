package com.example.pam_userinput

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.unit.dp

@Composable
fun FormDataDiri(modifier: Modifier
) {
    //variabel2 untuk mengingat nilai masukan dari keyboard
    var textNama by remember { mutableStateOf("")}
    var textAlamat by remember {mutableStateOf("")}
    var textJK by remember {mutableStateOf("")}

    //variabel2 untuk menyimpan data yang diperoleh dari komponen UI
    var nama by remember {mutableStateOf("")}
    var alamat by remember {mutableStateOf("")}
    var jenis by remember {mutableStateOf("")}

    val gender:List<String> = listOf("Laki-laki", "Perempuan")

    Column (modifier = Modifier.padding(top = 50.dp),
        ){  }
}