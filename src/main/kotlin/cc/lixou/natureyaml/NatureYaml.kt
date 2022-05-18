package cc.lixou.natureyaml

object NatureYaml {

    fun decodeFromString(text: String): Token {
        val lexer = YamlLexer(text)
        return lexer.nextToken()
    }

}