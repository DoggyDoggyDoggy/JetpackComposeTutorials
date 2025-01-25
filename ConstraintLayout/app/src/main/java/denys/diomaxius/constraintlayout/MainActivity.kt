package denys.diomaxius.constraintlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }

        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    //val constraints = myConstraintSet(margin = 8.dp)

   //ConstraintLayout(constraints, modifier.size(width = 200.dp, height = 200.dp))
   //{
   //    MyButton(text = "Button1", Modifier.size(200.dp).layoutId("button1"))
   //}


    ConstraintLayout(modifier.size(width = 350.dp, height = 220.dp)) {
        val (button1, button2, button3) = createRefs()

        val barrier = createEndBarrier(button1, button2)

        MyButton(text = "Button1", Modifier.width(100.dp).constrainAs(button1) {
            top.linkTo(parent.top, margin = 30.dp)
            start.linkTo(parent.start, margin = 8.dp)
        })

        MyButton(text = "Button2", Modifier.width(100.dp).constrainAs(button2) {
            top.linkTo(button1.bottom, margin = 20.dp)
            start.linkTo(parent.start, margin = 8.dp)
        })

        MyButton(text = "Button3", Modifier.constrainAs(button3) {
            linkTo(parent.top, parent.bottom,
                topMargin = 8.dp, bottomMargin = 8.dp)
            linkTo(button1.end, parent.end, startMargin = 30.dp,
                endMargin = 8.dp)
            start.linkTo(barrier, margin = 30.dp)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        })
    }

}

private fun myConstraintSet(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val button1 = createRefFor("button1")

        constrain(button1) {
            linkTo(parent.top, parent.bottom, topMargin = margin,
                bottomMargin = margin)
            linkTo(parent.start, parent.end, startMargin = margin,
                endMargin = margin)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        }
    }
}

@Composable
fun MyButton(text: String, modifier: Modifier = Modifier) {
    Button(
        onClick = { },
        modifier = modifier
    ) {
        Text(text)
    }
}