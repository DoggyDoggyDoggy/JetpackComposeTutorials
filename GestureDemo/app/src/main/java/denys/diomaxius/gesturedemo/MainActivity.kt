package denys.diomaxius.gesturedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.imageResource
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(Modifier.padding(innerPadding))
                }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    MultiTouchDemo(modifier)
    //ScrollModifiers(modifier)
    //ScrollableModifier(modifier)
    //PointerInputDrag(modifier)
    //DragDemo(modifier)
    //TapPressDemo(modifier)
    //ClickDemo(modifier)
}

@Composable
fun MultiTouchDemo(modifier: Modifier = Modifier) {

    var scale by remember { mutableStateOf(1f) }
    var angle by remember { mutableStateOf(0f) }
    var offset by remember { mutableStateOf(Offset.Zero)}

    val state = rememberTransformableState {
            scaleChange, offsetChange, rotationChange ->
        scale *= scaleChange
        angle += rotationChange
        offset += offsetChange
    }

    Box(contentAlignment = Alignment.Center, modifier = modifier.fillMaxSize()) {
        Box(
            Modifier
                .graphicsLayer(
                    scaleX = scale,
                    scaleY = scale,
                    rotationZ = angle,
                    translationX = offset.x,
                    translationY = offset.y
                )
                .transformable(state = state)
                .background(Color.Blue)
                .size(100.dp)
        )
    }
}

@Composable
fun ScrollModifiers(modifier: Modifier = Modifier) {
    val image = ImageBitmap.imageResource(id = R.drawable.vacation)

    Box(modifier = modifier
        .size(150.dp)
        .verticalScroll(rememberScrollState())
        .horizontalScroll(rememberScrollState())) {
        Canvas(
            modifier = Modifier
                .size(360.dp, 270.dp)
        )
        {
            drawImage(
                image = image,
                topLeft = Offset(
                    x = 0f,
                    y = 0f
                ),
            )
        }
    }
}

@Composable
fun ScrollableModifier(modifier: Modifier = Modifier) {
    var offset by remember { mutableStateOf(0f) }

    Box(
        modifier
            .fillMaxSize()
            .scrollable(
                orientation = Orientation.Vertical,
                state = rememberScrollableState { distance ->
                    offset += distance
                    distance
                }
            )
    ) {
        Box(modifier = Modifier
            .size(90.dp)
            .offset { IntOffset(0, offset.roundToInt()) }
            .background(Color.Red))
    }
}

@Composable
fun PointerInputDrag(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {

        var xOffset by remember { mutableStateOf(0f) }
        var yOffset by remember { mutableStateOf(0f) }

        Box(
            Modifier
                .offset { IntOffset(xOffset.roundToInt(), yOffset.roundToInt()) }
                .background(Color.Blue)
                .size(100.dp)
                .pointerInput(Unit) {
                    detectDragGestures { _, distance ->
                        xOffset += distance.x
                        yOffset += distance.y
                    }
                }
        )
    }
}

@Composable
fun DragDemo(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {

        var xOffset by remember { mutableStateOf(0f) }

        Box(
            modifier = Modifier
                .offset { IntOffset(xOffset.roundToInt(), 0) }
                .size(100.dp)
                .background(Color.Blue)
                .draggable(
                    orientation = Orientation.Horizontal,
                    state = rememberDraggableState { distance ->
                        xOffset += distance
                    }
                )
        )
    }
}

@Composable
fun TapPressDemo(modifier: Modifier = Modifier) {
    var textState by remember {
        mutableStateOf("Waiting ....")
    }

    val tapHandler = { status : String ->
        textState = status

    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Box(
            Modifier
                .padding(10.dp)
                .background(Color.Blue)
                .size(100.dp)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onPress = { tapHandler("onPress Detected") },
                        onDoubleTap = { tapHandler("onDoubleTap Detected") },
                        onLongPress = { tapHandler("onLongPress Detected") },
                        onTap = { tapHandler("onTap Detected") }
                    )
                }
        )
        Spacer(Modifier.height(10.dp))
        Text(textState)
    }
}

@Composable
fun ClickDemo(modifier: Modifier = Modifier) {
    var colorState by remember { mutableStateOf(true)}
    var bgColor by remember { mutableStateOf(Color.Blue) }

    val clickHandler = {

        colorState = !colorState

        bgColor = if (colorState) {
            Color.Blue
        } else {
            Color.DarkGray
        }
    }

    Box(
        modifier
            .clickable { clickHandler() }
            .background(bgColor)
            .size(100.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
        MainScreen()
}