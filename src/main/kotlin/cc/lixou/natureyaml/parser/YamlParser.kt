package cc.lixou.natureyaml.parser

import cc.lixou.natureyaml.lexer.Token
import cc.lixou.natureyaml.lexer.TokenType
import cc.lixou.natureyaml.lexer.YamlLexer
import cc.lixou.natureyaml.nodes.KeyNode
import cc.lixou.natureyaml.nodes.StringNode
import cc.lixou.natureyaml.nodes.YamlNode

class YamlParser(private val lexer: YamlLexer) {

    fun parse(): YamlNode {
        return parseKeyValue()
    }

    private fun parseKeyValue(): KeyNode {
        val key = eat(TokenType.LITERAL)
        eat(TokenType.COLON)
        val value = eat(TokenType.LITERAL)
        return KeyNode(key.data as String, StringNode(value.data as String))
    }

    private fun eat(): Token = lexer.nextToken() ?: throw IllegalStateException("Didn't expect the end here..")

    private fun eat(type: TokenType): Token {
        val result = eat()
        if (result.type != type) throw IllegalStateException("Expected '$type' but got '${result.type}'")
        return result
    }

}