open class Person constructor(var firstName: String = "John", var lastName: String = "Doe", var age: Int = 25) {
    val fullName: String get() = "$firstName $lastName"

    constructor(years: Int): this() {
        age += years;
    }
}

class Employee : Person() {

}