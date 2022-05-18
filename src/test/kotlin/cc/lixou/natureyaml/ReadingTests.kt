package cc.lixou.natureyaml

import io.kotest.core.spec.style.DescribeSpec

class ReadingTests : DescribeSpec({

    describe("reading a key-value") {
        it("string value") {
            val input = "test: hay"
            val node = NatureYaml.decodeFromString(input)
            println(node)
        }

        it("number value") {
            val input = "test: 12"
            val node = NatureYaml.decodeFromString(input)
            println(node)
        }
    }

})