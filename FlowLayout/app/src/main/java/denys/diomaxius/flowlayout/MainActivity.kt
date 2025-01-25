package denys.diomaxius.flowlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import denys.diomaxius.flowlayout.ui.theme.FlowLayoutTheme
import kotlin.random.Random

data class ItemProperties(
    val color: Color,
    val width: Dp,
    val height: Dp
)

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

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val items = (1..24).map {
        ItemProperties(
            width = Random.nextInt(20, 100).dp,
            height = Random.nextInt(10, 40).dp,
            color = Color(
                Random.nextInt(255),
                Random.nextInt(255),
                Random.nextInt(255),
                255
            )
        )
    }

    FlowColumn(
        modifier
            .width(300.dp)
            .height(120.dp),
        verticalArrangement = Arrangement.Center,
        horizontalArrangement = Arrangement.Center
    ) {

        items.forEachIndexed { index, properties ->

            var weight = 0.5f

            if (index % 2 == 0) {
                weight = 2f

            } else if (index % 3 == 0) {
                weight = 3f
            }


            Box(
                modifier = Modifier
                    .weight(weight)
                    .padding(2.dp)
                    .width(30.dp)
                    .height(30.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(properties.color)
            )
        }
    }
}