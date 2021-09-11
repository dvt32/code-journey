fun main() {
    /*
    var shoppingList = mutableListOf("Lamborghini", "Penthouse", "Rolex")
    shoppingList.add("Ferrari")
    for (shoppingListItem in shoppingList) {
        println(shoppingListItem)
    }
    */

    /*
    val x = 5;
    when (x) {
        in 1..3 -> println("It is in range 1-3")
        in 3..10 -> println("In range 3-10")
        else -> {
            println("Not in range")
        }
    }
    printNumbers()
    */

    //println(isEven(num = 5))
    //val y = 5;
    //println(y.isOdd());

    /*
    //val dog = Animal("Dog");
    val dog = Dog()
    dog.makeSound();
    val cat = Cat();
    cat.makeSound();
    val bear = object : Animal("Camembear") {
        override fun makeSound() {
            println("Roar!");
        }
    }
     */

    /*
    val number = readLine() ?: "0"
    val parsedNumber = try {
        number.toInt()
    } catch (e: Exception) {
        0
    }
    println(parsedNumber)
    */

    val list = listOf("Kotlin", "is", "fun");
    //val count = list.count { currentString -> currentString.length == 3 }
    val count = list.customCount { currentString -> currentString.length >= 3 }
    println(count);

    var arr = arrayOf(1, 2, 3);
    val intArr = intArrayOf(4, 5, 6)
    //var input = readLine()?.toInt()
    //println(input)

    val day = "Monday"
    val food = when (day) {
        "Monday", "Tuesday" -> "Eat yoghurt"
        else -> "Eat cheese"
    }
    println(food);
    val drink = when {
        day == "Monday" -> "Water"
        else -> "Beer"
    }
    println(drink)

    val map = mapOf(1 to "Kotlin", 2 to "Java")
    println(map)
    for ((key, value) in map) {
        println("$key $value")
    }

    for (i in 1 until 9 step 2) {
        print(i)
    }
    println()
    for (i in 9 downTo 1) {
        print(i);
    }
    println()

    val person = Person();
    println(person.fullName)
    val person2 = Person(years = 50);
    println(person2.age)
}

fun <T> List<T>.customCount(function: (T) -> Boolean): Int {
    var counter = 0;

    for (string in this) {
        if (function(string)) {
            counter++;
        }
    }

    return counter;
}

// Non-generic version
/*
fun List<String>.customCount(function: (String) -> Boolean): Int {
    var counter = 0;

    for (string in this) {
        if (function(string)) {
            counter++;
        }
    }

    return counter;
}
*/

fun Int.isOdd(): Boolean {
    return (this % 2 == 1);
}

fun isEven(num: Int = 10): Boolean {
    return (num % 2 == 0)
}

fun printNumbers() {
    for (i in -1..99) {
        if (isEven(i)) println(i)
    }
}