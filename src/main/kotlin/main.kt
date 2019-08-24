// Submit your answer code using functions below.
// You can use additional function as well.
// Don't forget copy import statements, if you use some libraries.
// submit to:
// https://forms.gle/3pTnurkXmpvdr6kp6
fun answer1(list1: ListNode, list2: ListNode): ListNode {
    val node = ListNode(list1.value + list2.value)
    list1.next?.also { l1 -> list2.next?.also { l2 -> node.next = answer1(l1, l2) } }
    return node
}

fun answer2(y: Int, b: Int, r: Int): Int {
    val a = minOf(y + 2, b + 1, r)
    return a * 3 - 3
}

fun answer3(inputs: Int): Long {
    return LongRange(0, inputs.toLong()).filterNot { it.and(1) == 1L }.reduce { a, b -> a + b }
}

@UseExperimental(ExperimentalUnsignedTypes::class)
fun answer4(input: Sequence<Int>): Int {
    val a = ULongArray(100_000_000 / 64 + 1)
    input.forEach {
        a[it / 64] = a[it / 64].or((1UL).shl(it.rem(64)))
    }

    return a.sumBy {
        java.lang.Long.bitCount(it.toLong()).toUInt()
    }.toInt()
}

// ---- submit above ----

// These are dummy test cases.
// We will use more test cases to estimate your code.
fun main() {
    println("Q1")
    val list1 = ListNode(5)
    list1.next = ListNode(4)
    val list2 = ListNode(3)
    list2.next = ListNode(2)
    testListNode(ListNode(0)) {
        return@testListNode answer1(list1, list2)
    }

    println("Q2")
    testInt(0) {
        return@testInt answer2(1, 2, 3)
    }

    println("Q3")
    testLong(0) {
        return@testLong answer3(10)
    }

    println("Q4")
    val testSequence = generateSequence(200_000_000, randomSet())
    testInt(0) {
        return@testInt answer4(testSequence)
    }
}
