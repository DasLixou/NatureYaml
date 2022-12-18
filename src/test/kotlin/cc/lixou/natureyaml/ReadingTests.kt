package cc.lixou.natureyaml

import cc.lixou.natureyaml.nodes.KeyNode
import cc.lixou.natureyaml.nodes.NumberNode
import cc.lixou.natureyaml.nodes.StringNode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class ReadingTests : DescribeSpec({

    describe("reading a key-value") {
        it("string value") {
            val value = "hay"
            val input = "test: $value"
            val node = NatureYaml.decodeFromString(input)
            ((node as KeyNode).value as StringNode).text shouldBe value
        }

        context("number value") {
            it("normal integer") {
                val value = 12
                val input = "test: $value"
                val node = NatureYaml.decodeFromString(input)
                ((node as KeyNode).value as NumberNode).number.toInt() shouldBe value
            }
            it("double number") {
                val value = 12.1f
                val valueString = "12.1f"
                val input = "test: $valueString"
                val node = NatureYaml.decodeFromString(input)
                println(((node as KeyNode).value as NumberNode).number)
                ((node as KeyNode).value as NumberNode).number shouldBe value
            }
            it("hexadecimal number") {
                val value = 0x132
                val valueString = "0x132"
                val input = "test: $valueString"
                val node = NatureYaml.decodeFromString(input)
                println(((node as KeyNode).value as NumberNode).number)
                ((node as KeyNode).value as NumberNode).number shouldBe value
            }
        }
    }

})