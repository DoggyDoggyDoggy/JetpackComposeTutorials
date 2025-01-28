package denys.diomaxius.gesturedemo.glance

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.DpSize
import androidx.glance.appwidget.SizeMode
import androidx.glance.text.TextStyle
import androidx.glance.text.FontWeight
import androidx.glance.unit.ColorProvider
import java.util.Locale
import androidx.glance.text.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.dp
import androidx.glance.action.clickable
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Column
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.padding
import androidx.glance.appwidget.updateAll
import androidx.glance.appwidget.cornerRadius
import androidx.glance.ImageProvider
import androidx.glance.Image
import androidx.glance.LocalSize
import androidx.glance.layout.Alignment
import denys.diomaxius.gesturedemo.R
import kotlinx.coroutines.*
import java.time.Duration

class StockAppWidget : GlanceAppWidget() {

    private var job: Job? = null

    companion object {
        private val smallMode = DpSize(100.dp, 80.dp)
        private val mediumMode = DpSize(120.dp, 120.dp)
    }

    override val sizeMode: SizeMode = SizeMode.Responsive(
        setOf(smallMode, mediumMode)
    )

    override suspend fun provideGlance(context: Context, id: GlanceId) {

        if (job == null) {
            job = startUpdateJob(
                Duration.ofSeconds(20).toMillis(),
                context
            )
        }

        provideContent {
            GlanceTheme {
                GlanceContent()
            }
        }
    }

    private fun startUpdateJob(timeInterval: Long, context: Context): Job {

        return CoroutineScope(Dispatchers.Default).launch {
            while (true) {
                PriceDataRepo.update()
                StockAppWidget().updateAll(context)
                delay(timeInterval)
            }
        }
    }

    @Composable
    fun GlanceContent() {
        val stateCount by PriceDataRepo.currentPrice.collectAsState()
        val size = LocalSize.current

        when (size) {
            smallMode -> Small(stateCount)
            mediumMode -> Medium(stateCount)
        }
    }

    @Composable
    private fun Small(stateCount: Float) {
        Column(modifier = GlanceModifier
            .clickable { refreshPrice() }
            .fillMaxSize()
            .background(GlanceTheme.colors.background)
            .padding(8.dp)) {

            StockDisplay(stateCount)
        }
    }

    @Composable
    private fun Medium(stateCount: Float) {
        Column(horizontalAlignment = Alignment.Horizontal.CenterHorizontally,
            modifier = GlanceModifier
                .clickable { refreshPrice() }
                .fillMaxSize()
                .cornerRadius(15.dp)
                .background(GlanceTheme.colors.background)
                .padding(8.dp)) {

            StockDisplay(stateCount)

            Image(
                provider = ImageProvider(if (PriceDataRepo.change > 0)
                    R.drawable.up_arrow else R.drawable.down_arrow),
                contentDescription = "Arrow Image",
                modifier = GlanceModifier
                    .fillMaxSize()
                    .padding(20.dp)
            )
        }
    }

    private fun refreshPrice() {
        PriceDataRepo.update()
    }

    @Composable
    private fun StockDisplay(stateCount: Float) {

        val color = if (PriceDataRepo.change > 0) Color.Green else Color.Red
        val textStyle = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = ColorProvider(color)
        )

        Text(
            PriceDataRepo.ticker, style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold)
        )

        Text(text = String.format(Locale.getDefault(), "%.2f", stateCount),
            style = textStyle)

        Text("${PriceDataRepo.change} %", style = textStyle)
    }

}