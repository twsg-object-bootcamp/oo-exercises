import io.kotlintest.matchers.haveLength
import io.kotlintest.properties.assertAll
import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.specs.DescribeSpec
import io.kotlintest.specs.StringSpec

class MyTests : StringSpec() {
    init {
        "addOne" {
            assertAll { a: Int ->
                addOne(a) shouldBe (a + 1)
            }
        }

        "addTwo" {
            assertAll { a: Int ->
                addTwo(a) shouldBe (a + 2)
            }
        }

        "addFour" {
            assertAll { a: Int ->
                addFour(a) shouldBe (a + 4)
            }
        }


        "addTwoImproved" {
            assertAll { a: Int ->
                addTwoImproved(a) shouldBe addTwo(a)
            }
        }

        "addFourImproved" {
            assertAll { a: Int ->
                addFourImproved(a) shouldBe addFour(a)
            }
        }

        "addFourV3" {
            assertAll { a: Int ->
                addFourV3(a) shouldBe addFour(a)
            }
        }

        "addFourV31" {
            assertAll { a: Int ->
                addFourV31()(a) shouldBe addFour(a)
            }
        }

        "addFourV4" {
            assertAll { a: Int ->
                addFourV4()(a) shouldBe addFour(a)
            }
        }

        "head should return first element" {
            head(listOf(1, 2, 3)) shouldBe 1
        }

        "head" {
            assertAll { a: List<Int> ->
                val result: Int = if (a.isEmpty())
                    -1
                else
                    a.first()
                head(a) shouldBe result
            }
        }

        "last should return first element" {
            last(listOf(1, 2, 3)) shouldBe 3
        }

        "last" {
            assertAll { a: List<Int> ->
                val result: Int = if (a.isEmpty())
                    -1
                else
                    a[a.size - 1]
                last(a) shouldBe result
            }
        }

        "max return maximum number in array" {
            max(listOf(1, 2, 3, 4, 5)) shouldBe 5
        }

        "max" {
            assertAll { a: List<Int> ->
                val result: Int = if (a.isEmpty())
                    0
                else
                    a.max()!!
                max(a) shouldBe result
            }
        }

        "min return minimum number in array" {
            max(listOf(1, 2, 3, 4, 5)) shouldBe 1
        }

        "min" {
            assertAll { a: List<Int> ->
                val result: Int = if (a.isEmpty())
                    0
                else
                    a.min()!!
                min(a) shouldBe result
            }
        }

        "length" {
            assertAll { a: List<Int> ->
                length(a) shouldBe a.size
            }
        }

        "sum" {
            assertAll { a: List<Int> ->
                sum(a) shouldBe a.sum()
            }
        }

        "any return false if all elements don't meet condition" {
            any({ it % 2 == 0 }, listOf(1, 3)) shouldBe false
        }

        "any return true if one element satisfies condition" {
            any({ it % 2 == 0 }, listOf(1, 2, 3)) shouldBe true
        }

        "all return false if one element doesn't meet condition" {
            all({ it % 2 == 0 }, listOf(1, 2, 3)) shouldBe false
        }

        "all return true if all element satisfies condition" {
            all({ it % 2 == 0 }, listOf(2, 4, 6)) shouldBe true
        }

        "countOccurrence returns occurrence of a string" {
            countOccurrence(listOf("abc", "def", "blah", "blah"), "def") shouldBe 1
            countOccurrence(listOf("abc", "def", "blah", "blah"), "blah") shouldBe 2
        }
        
        "maxOccurrence returns occurrence of a string" {
            maxOccurrence(listOf("abc", "def", "blah", "blah"), "def") shouldBe "blah"
        }
    }
}
