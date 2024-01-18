package com.example.assignment_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.assignment_2.ui.theme.Assignment_2Theme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment_2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.LightGray     // Creates Grey Background
                ) {
                    ScreenLayout()
                }
            }
        }
    }
}


@Composable
fun ScreenLayout(modifier: Modifier = Modifier) {
    // Centers All Elements
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        // import image from drawables
        val androidImage = painterResource(R.drawable.android_3)

        // Android  image
        Image(
            painter = androidImage,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(275.dp)
        )

        DisplayCount()

    }

}



@Composable
fun DisplayCount(modifier: Modifier = Modifier) {
    var button_count by remember { mutableStateOf(3) }

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {

        // Current Count Display
        Text(
            text = "Current Count = ${button_count.toString()}",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            color = Color(0xFF3366CC),
            modifier = Modifier
                .padding(bottom = 5.dp)
        )

        // Name + Course Display
        Row(
            modifier = Modifier
                .padding(bottom = 25.dp)
        ){
            Text(
                text = stringResource(R.string.student_name),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color(0xFF3366CC),
                modifier = Modifier
                        .padding(end = 5.dp)
            )
            Text(
                text = stringResource(R.string.course_num),
                fontSize = 18.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color(0xFF3366CC),

            )
        }



        Row(
            horizontalArrangement = Arrangement.Center
        ) {

            // Decrement Button - contained in Box for resizing
            Box(
                modifier = Modifier

            ){
                // decrement button
                Button(
                    onClick = { button_count = getNewCount(button_count, false) },
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier
                        .padding(end=10.dp)
                ) {
                    Text(
                        text = stringResource(R.string.subtract),
                        fontSize = 40.sp
                    )
                }

            }

            // Increment Button
            Box (
                modifier = Modifier
            ){
                Button(
                    onClick = { button_count = getNewCount(button_count, true) },
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Text(text = stringResource(R.string.add), fontSize = 40.sp)
                }
            }


        }


    }
}


    /*
        Increments or decrements the input buttonCount, BUT count must stay within the
        range [1,5] (inclusive). Meaning 5+1 returns 1, 1-1 returns 5.
        * @param buttonCount The current button count.
        * @param isIncrement True if the operation is increment, false for decrement.
        * @return The updated button count after the specified operation.
    */
    fun getNewCount(buttonCount: Int, isIncrement: Boolean): Int {
        return when {
            isIncrement && buttonCount == 5 -> 1
            !isIncrement && buttonCount == 1 -> 5
            isIncrement -> buttonCount + 1
            else -> buttonCount - 1
        }
    }






@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Assignment_2Theme {
        ScreenLayout()
    }
}
