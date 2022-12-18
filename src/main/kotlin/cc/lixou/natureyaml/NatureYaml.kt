package cc.lixou.natureyaml

import cc.lixou.natureyaml.lexer.YamlLexer
import cc.lixou.natureyaml.nodes.YamlNode
import cc.lixou.natureyaml.parser.YamlParser

object NatureYaml {

    fun decodeFromString(text: String): YamlNode {
        val lexer = YamlLexer(text)
        val parser = YamlParser(lexer)

        return parser.parse()
    }

}