package com.example.assignment_1_business_card_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.assignment_1_business_card_app.ui.theme.Assignment_1_Business_Card_AppTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextDecoration



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment_1_Business_Card_AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ScreenLayout()
                }
            }
        }
    }
}

// Attempt #1 -----------------------------------------------------------
/*
@Composable
fun ScreenLayout(modifier: Modifier = Modifier) {
    Box(
    ){


        val bc_back = painterResource(R.drawable.bc_back)
        val meme_kid = painterResource(R.drawable.meme_kid)

        // red/black background image
        Image(
            painter = bc_back,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .padding(1.dp)
        )

        // Center display
        Column (
            modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            // meme kid image
            Image(
                painter = meme_kid,
                contentDescription = null,
                modifier = Modifier
                    .padding(bottom= 32.dp)
            )


            // Create section containing business card info
            CardInfo(
                name = stringResource(R.string.card_name),
                email = stringResource(R.string.card_email),
                univ = stringResource(R.string.card_univ),
                course = stringResource(R.string.card_course)
            )
        }

    }

}


@Composable
private fun CardInfo(name: String, email: String, univ: String, course: String,  modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ){

        Text (
            text = name,
            modifier = modifier,
            color = Color.White
        )
        Text(
            text = email,
            modifier = modifier,
            color = Color.White,
        )
        Text(
            text = univ,
            modifier = modifier,
            color = Color.White
        )
        Text(
            text = course,
            modifier = modifier,
            color = Color.White
        )
    }
}
*/
// Attempt #1 END ---------------------------------------------------------------
// Attempt #2 --------------------------------------------------------------------

@Composable
fun ScreenLayout(modifier: Modifier = Modifier) {
    Box(
    ){


        val bc_back = painterResource(R.drawable.bc_back)

        // red/black background image
        Image(
            painter = bc_back,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .padding(1.dp)
        )

        // Centers All Elements
        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally)
        {

            // Meme kid photo, Job Title, Job Phrase Display
            ImageWithName()

            // Contact Information Display
            ContactInfoLines()
        }
    }
}



@Composable
private fun ImageWithName(modifier: Modifier = Modifier){

    val meme_kid = painterResource(R.drawable.meme_kid)

    // meme kid image
    Image(
        painter = meme_kid,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(bottom= 15.dp)
            .size(200.dp)
    )

    // My name
    Text(
        text = stringResource(R.string.card_name),
        color = Color.White,

        style = TextStyle(fontSize = 32.sp),
        modifier = Modifier
            .padding(bottom = 6.dp)
    )

    // Job Title
    Text(
        text = "Pokemon Trainer",
        color = Color.White,
        style = TextStyle(fontSize = 24.sp),
        fontStyle = FontStyle.Italic,
        modifier = Modifier
            .padding(bottom = 30.dp)   // padding added to push ContactInfoLines() down screen
    )

    // Saying
    Text(
        text = "Gotta Catch'em All !",
        color = Color.White,
        style = TextStyle(fontSize = 42.sp),
        fontFamily = FontFamily.Cursive,
        modifier = Modifier
            .padding(bottom = 80.dp)   // padding added to push ContactInfoLines() down screen
    )
}

@Composable
private fun IconWithContactLine(iconId: Int, contactInfoId: Int, modifier: Modifier = Modifier) {

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {

        // display Icon image
        Image(
            painter = painterResource(iconId),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .padding(end = 10.dp)
        )
        // display Icon text
        Text(
            text = stringResource(contactInfoId),
            modifier = modifier,
            color = Color.White,
            style = TextStyle(fontSize = 20.sp),
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif
        )

    }
}



@Composable
private fun ContactInfoLines(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier

    ){
        IconWithContactLine(R.drawable.phone_icon, R.string.card_phone, modifier)
        IconWithContactLine(R.drawable.email_icon, R.string.card_email, modifier)
        IconWithContactLine(R.drawable.book, R.string.card_univ, modifier)
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Assignment_1_Business_Card_AppTheme {

        ScreenLayout()
    }
}
