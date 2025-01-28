package denys.diomaxius.gesturedemo.glance

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.random.Random

object PriceDataRepo {
    var ticker = "GOOGL"
    private var previousPrice = 0f
    var change = 0

    private var _currentPrice = MutableStateFlow(0f)
    val currentPrice: StateFlow<Float> get() = _currentPrice

    fun update() {
        previousPrice = currentPrice.value
        _currentPrice.value = Random.nextInt(20, 35) + Random.nextFloat()
        change = ((_currentPrice.value - previousPrice)
                / previousPrice * 100).toInt()
    }
}