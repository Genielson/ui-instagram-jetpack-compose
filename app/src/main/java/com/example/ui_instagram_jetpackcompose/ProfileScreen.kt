package com.example.ui_instagram_jetpackcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen(){
    
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar("genielson_leal", modifier = Modifier.padding(16.dp))
    }

}

@Composable
fun TopBar(name:String,
           modifier: Modifier
){

    Row(
        verticalAlignment = Alignment.CenterVertically,//
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround// centralizar e dar espaços
    ) {

        Icon(contentDescription = "Back",
            modifier = Modifier.size(24.dp),
            imageVector = Icons.Default.ArrowBack,
            tint = Color.Black
        )

        Text(text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            overflow = TextOverflow.Ellipsis
        )

        Icon(contentDescription = "Back",
            painter = painterResource(id = R.drawable.ic_bell),
            modifier = Modifier.size(20.dp),
            tint = Color.Black
        )



    }

}
