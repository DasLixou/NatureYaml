package cc.lixou.natureyaml

import cc.lixou.natureyaml.lexer.Token
import cc.lixou.natureyaml.lexer.YamlLexer

object NatureYaml {

    fun decodeFromString(text: String): List<Token> {
        val lexer = YamlLexer(text)
        val list = mutableListOf<Token>()
        var token = lexer.nextToken()
        while (token != null) {
            list.add(token)
            token = lexer.nextToken()
        }
        return list
    }

}