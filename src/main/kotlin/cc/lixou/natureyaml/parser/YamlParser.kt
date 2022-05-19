package cc.lixou.natureyaml.parser

import cc.lixou.natureyaml.lexer.Token
import cc.lixou.natureyaml.lexer.TokenType
import cc.lixou.natureyaml.lexer.YamlLexer
import cc.lixou.natureyaml.nodes.KeyNode
import cc.lixou.natureyaml.nodes.StringNode
import cc.lixou.natureyaml.nodes.ValueNode
import cc.lixou.natureyaml.nodes.YamlNode

class YamlParser(private val lexer: YamlLexer) {

    fun parse(): YamlNode {
        return parseKeyValue()
    }

    private fun parseKeyValue(): KeyNode {
        val key = eat(TokenType.LITERAL)
        eat(TokenType.COLON)
        val value = parseValue()
        return KeyNode(key.data as String, value)
    }

    private fun parseValue(): ValueNode {
        val value = eat(TokenType.LITERAL, TokenType.NUMBER) // TODO: Add Value Type List or so
        return ValueNode.of(value.data)
    }

    private fun eat(): Token = lexer.nextToken() ?: throw IllegalStateException("Didn't expect the end here..")

    private fun eat(vararg type: TokenType): Token {
        val result = eat()
        if (!type.contains(result.type)) throw IllegalStateException("Expected '$type' but got '${result.type}'")
        return result
    }

}