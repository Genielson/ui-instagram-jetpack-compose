package com.example.ui_instagram_jetpackcompose

import android.view.RoundedCorner
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen(){
    
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar("genielson_leal", modifier = Modifier.padding(16.dp))
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(25.dp))
        ButtonSection(modifier = Modifier.fillMaxWidth())
        Spacer(Modifier.height(25.dp))

        HighlightSection(
            highlights = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.youtube),
                    text = "YouTube"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.qa),
                    text = "Q&A"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.discord),
                    text = "Discord"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.telegram),
                    text = "Telegram"
                ),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        PostTabView()

    }

}

@Composable
fun PostTabView(){
    
}

@Composable
fun HighlightSection(
    modifier: Modifier = Modifier,
    highlights : List<ImageWithText>
){
    LazyRow(modifier = modifier){
        items(highlights.size){

            Column(horizontalAlignment = Alignment.CenterHorizontally,
                  verticalArrangement = Arrangement.Center,
                  modifier = Modifier.padding(end = 15.dp)
                ){

                  RoundedImage(
                      image = highlights[it].image,
                      modifier = Modifier.size(size = 70.dp)
                      )

                Text(
                    text = highlights[it].text,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )

            }
        }
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
            
            RoundedImage(
                image = painterResource(id = R.drawable.genielson),
                modifier = modifier
                    .size(100.dp)
                    .weight(3f)
            )

            Spacer(modifier = Modifier.width(16.dp))
            StatSection(modifier = Modifier.weight(7f))
        }

    }
}

@Composable
fun RoundedImage(image : Painter,modifier: Modifier = Modifier){
    Image(
        painter =  image,
        contentDescription = null,
        modifier = modifier
            .padding(1.dp)
            .clip(CircleShape)
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
    )

}

@Composable
fun StatSection(modifier: Modifier = Modifier){

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
        ){

            ProfileStat(numberText = "601", text = "Posts", modifier = Modifier.padding(1.dp))
            ProfileStat(numberText = "100K", text = "Followers", modifier = Modifier.padding(1.dp))
            ProfileStat(numberText = "72", text = "Following", modifier = Modifier.padding(1.dp))

        }

}

@Composable
fun ProfileStat(numberText:String,text:String,modifier : Modifier = Modifier){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = numberText, fontSize = 20.sp,
            fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text)
    }

}

@Composable
fun ButtonSection(modifier: Modifier = Modifier){

    val minWidth = 95.dp
    val height = 30.dp
    Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = modifier) {

        ActionButton(
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Email",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )

        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .size(height)
        )
    }

}



@Composable
fun ActionButton(modifier : Modifier = Modifier, text:String? = null,icon : ImageVector? = null){
    Row(horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(5.dp))
            .padding(6.dp)
        ){

        if(text != null){
            Text(fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                text = text)
        }

        if(icon != null){
            Icon(imageVector = icon, contentDescription = null,tint = Color.Black)
        }
    }
}


