package com.example.pam_userinput

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
    val kawin:List<String> = listOf("Janda", "Lajang", "Duda")


    Column (modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
        )
    {
        Card (modifier = Modifier
            .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color.Gray
            )){
            Row () {
                Column {
                    Text(
                        text = stringResource(R.string.judul),
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(top = 50.dp, bottom = 10.dp, start = 10.dp),
                    )
                }
            }
        }
    }


    Column {
        ElevatedCard (modifier = Modifier
            .fillMaxWidth(1f)
            .padding(12.dp, top = 110.dp, end = 12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )) {

    Column (modifier = Modifier.padding(all = 15.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        ){
        Text(text = "NAMA LENGKAP")
        OutlinedTextField(
            value = textNama,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.width(250.dp),
            label = {Text(text = "Nama Lengkap")},
            onValueChange = {
                textNama = it
            }
        )

        Column {
            Text(text = "JENIS KELAMIN")
            gender.forEach { item ->
                Row(modifier = Modifier.selectable(
                    selected = textJK == item,
                    onClick = {textJK = item}
                ), verticalAlignment = Alignment.CenterVertically){
                    RadioButton(
                        selected = textJK == item,
                        onClick = {
                            textJK = item
                        })
                    Text(item)
                }
            }
        }

        Column {
            Text(text = "STATUS PERKAWINAN")
            kawin.forEach { item ->
                Row(modifier = Modifier.selectable(
                    selected = textJK == item,
                    onClick = {textJK = item}
                ), verticalAlignment = Alignment.CenterVertically){
                    RadioButton(
                        selected = textJK == item,
                        onClick = {
                            textJK = item
                        })
                    Text(item)
                }
            }
        }

        Text(text = "STATUS PERKAWINAN")
        OutlinedTextField(
            value = textAlamat,
            singleLine = true,
            modifier = Modifier.width(280.dp),
            label = {Text(text = "Alamat Lengkap")},
            onValueChange = {
                textAlamat = it
            }
        )
        Spacer(modifier= Modifier.height(20.dp))
            Button(
                modifier = Modifier.fillMaxWidth(1f),
                // the buttton is enabled when the user make a selection
                enabled = textAlamat.isNotEmpty(),
                onClick = {
                    nama = textNama
                    jenis = textJK
                    alamat = textAlamat
                }
            )
            {
                Text(stringResource(R.string.submit))
            }
    } }

        HorizontalDivider(
            modifier = Modifier
                .padding(bottom = dimensionResource(R.dimen.padding_medium),
                    top = dimensionResource(
                        id = R.dimen.padding_medium
                    )),
            thickness = dimensionResource(R.dimen.divider_tipis),
            color = Color.DarkGray
        )

        ElevatedCard (
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Black),
            modifier = Modifier
                .height(180.dp)
                .width(300.dp)
        ) {
            Column (modifier = Modifier
                .padding(horizontal = 5.dp, vertical = 15.dp),)
            {
                Text(text = "Nama   : "+nama, color = Color.White)
                Text(text = "Gender : "+jenis, color = Color.White)
                Text(text = "Alamat : "+alamat, color = Color.White)
            }
        }
    }
}