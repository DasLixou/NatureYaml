package cc.lixou.natureyaml

import io.kotest.core.spec.style.DescribeSpec

class ReadingTests : DescribeSpec({

    describe("reading a key-value") {
        val input = "test"
        val token = NatureYaml.decodeFromString(input)
        println(token)
    }

})