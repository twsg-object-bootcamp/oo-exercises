fun addOne(n: Int): Int {
    return n + 1
}

fun addTwo(n: Int): Int {
    return addOne(addOne(n))
}

fun addFour(n: Int): Int {
    return addOne(addOne(addOne(addOne(n))))
}

fun <T> doTwice(f: (T) -> T): (T) -> T {
    return { t: T -> f(f(t)) }
}

fun addTwoImproved(n: Int): Int {
    return doTwice(::addOne)(n)
}

fun addFourImproved(n: Int): Int {
    return doTwice(doTwice(::addOne))(n)
}

fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C {
    return { x -> f(g(x)) }
}

fun doTwiceImproved(f: (Int) -> Int): (Int) -> Int {
    return compose(f, f)
}

fun addFourV3(n: Int): Int {
    return compose(::doTwiceImproved, ::doTwiceImproved)(::addOne)(n)
}

fun addFourV31(): (Int) -> Int {
    return compose(::doTwiceImproved, ::doTwiceImproved)(::addOne)
}

fun addFourV4(): (Int) -> Int {
    return compose(::addOne, compose(::addOne, compose(::addOne, ::addOne)))
}

fun main() {
    runList();
}

fun runList() {
    val words = "The quick brown fox jumps over the lazy dog".split(" ")
    val lengthsList = words.filter { println("filter: $it"); it.length > 3 }
        .map { println("length: ${it.length}"); it.length }
        .take(4)

    println("Lengths of first 4 words longer than 3 chars:")
    println(lengthsList)
}

fun runSequence() {
    val words = "The quick brown fox jumps over the lazy dog".split(" ")
    //convert the List to a Sequence
    val wordsSequence = words.asSequence()

    val lengthsSequence = wordsSequence.filter { println("filter: $it"); it.length > 3 }
        .map { println("length: ${it.length}"); it.length }
        .take(4)

    println("Lengths of first 4 words longer than 3 chars")
    // terminal operation: obtaining the result as a List
    println(lengthsSequence.toList())
}

// TODO
fun head(arr: List<Int>): Int {
    return -1
}

// TODO
fun last(arr: List<Int>): Int {
    return -1
}

// TODO
fun max(arr: List<Int>): Int {
    return Int.MIN_VALUE
}

// TODO
fun min(arr: List<Int>): Int {
    return Int.MIN_VALUE
}

// TODO
fun length(arr: List<Int>): Int {
    return -1
}

// TODO
fun sum(arr: List<Int>): Int {
    return 0
}

// TODO
fun any(predicate: (Int) -> Boolean, arr: List<Int>): Boolean {
    return false
}

// TODO
fun all(predicate: (Int) -> Boolean, arr: List<Int>): Boolean {
    return false
}

// TODO
fun countOccurrence(arr: List<String>, str: String): Int {
    return 0
}

// TODO
fun maxOccurrence(arr: List<String>, str: String): String {
    return ""
}

//getRegisterForm(url).andThen(::fillForm).andThen(::submit)
