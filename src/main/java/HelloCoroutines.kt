import kotlinx.coroutines.*

fun main() {
    for (i in 1..1_000_000)
        GlobalScope.launch {
            delay(100)
        }

    val x: Int = runBlocking { foo().await() }
    println(x)
}

private suspend fun foo(): Deferred<Int> {
    return GlobalScope.async {
        delay(1000)
        println("Hello")
        42
    }
}

suspend fun buyItem(itemTypeId: String, cost: Int): Boolean {
    if(decrement(cost)) {
        return false
    }
    try {
        giveItem(itemTypeId)
        return true
    } catch (ex: Exception) {
        refund(cost)
        throw Exception(ex);
    }
}

suspend fun refund(cost: Int) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

suspend fun giveItem(itemTypeId: String) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

suspend fun decrement(cost: Int): Boolean {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}
