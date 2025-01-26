package denys.diomaxius.pager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import denys.diomaxius.pager.ui.theme.PagerTheme
import kotlinx.coroutines.launch

val drawableIds = listOf(R.drawable.cover_1, R.drawable.cover_2,
    R.drawable.cover_3, R.drawable.cover_4, R.drawable.cover_5)

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
    CoverPager()
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CoverPager() {
    val pagerState = rememberPagerState { drawableIds.size }
    val coroutineScope = rememberCoroutineScope()

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth()
        ) { page ->
            Image(
                painter = painterResource(drawableIds[page]),
                contentDescription = "cover",
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(10.dp))
            )
        }
        Row {
            Icon(
                Icons.Filled.KeyboardArrowLeft,
                contentDescription = "Next Page",
                modifier = Modifier
                    .size(75.dp)
                    .clickable {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage - 1)
                        }
                    }
            )

            Icon(
                imageVector = Icons.Filled.KeyboardArrowRight,
                contentDescription = "Next Page",
                modifier = Modifier
                    .size(75.dp)
                    .clickable {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }
            )
        }
    }
}