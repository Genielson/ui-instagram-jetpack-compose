package com.example.ui_instagram_jetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen(){
    
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar("genielson_leal", modifier = Modifier.padding(16.dp))
        Spacer(modifier = Modifier.height(4.dp))

    }

}

@Composable
fun TopBar(name:String,
           modifier: Modifier
){

    Row(
        verticalAlignment = Alignment.CenterVertically,// centraliza os icones no centro verticalmente
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

@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
){

    Column(modifier = modifier.fillMaxWidth()) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ){


        }

    }
}

@Composable
fun RoundedImage(image : Painter,modifier: Modifier = Modifier){

    Image(
        painter =  image,
        contentDescription = null,
        modifier = modifier.padding(3.dp).border(width = 1.dp,
            shape = CircleShape,
            color = Color.LightGray)
            .clip(CircleShape)
    )

}
