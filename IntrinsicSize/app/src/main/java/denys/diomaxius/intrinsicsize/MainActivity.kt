package denys.diomaxius.intrinsicsize

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height


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
    var textState by remember { mutableStateOf("") }

    val onTextChange = { text : String ->
        textState = text
    }

    Column(modifier.width(200.dp).padding(5.dp)) {
        Column(Modifier.width(IntrinsicSize.Min)) {
            Text(
                modifier = Modifier
                    .padding(start = 4.dp),
                text = textState
            )
            Box(Modifier
                .height(10.dp)
                .fillMaxWidth()
                .background(Color.Blue)
            )
        }
        MyTextField(text = textState, onTextChange = onTextChange)
    }
}

@Composable
fun MyTextField(text: String, onTextChange : (String) -> Unit) {
    TextField(
        value = text,
        onValueChange = onTextChange
    )
}