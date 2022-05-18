package cc.lixou.natureyaml

class YamlLexer(private val text: String) {

    private var currentIndex = 0
    private var currentChar = text[currentIndex]

    init {

    }

    fun nextToken(): Token {
        val result = when {
            currentChar.isLetter() -> parseLiteral()
            else -> throw IllegalStateException("No Token found")
        }
        advance()
        return result
    }

    private fun parseLiteral() = _parseUntil(TokenType.LITERAL, { it.isLetter() }, { it.toString() })

    private fun _parseUntil(type: TokenType, condition: (Char) -> Boolean, data: (StringBuilder) -> Any?): Token {
        val result = StringBuilder(currentChar.toString())
        var peek = peek()
        while (condition.invoke(peek)) {
            result.append(peek)
            advance()
            peek = peek()
        }
        return Token(type, data.invoke(result))
    }

    private fun advance(): Char {
        currentIndex++
        if(text.length <= currentIndex) return Character.MIN_VALUE
        currentChar = text[currentIndex]
        return currentChar
    }

    private fun peek(): Char {
        if(text.length <= currentIndex + 1) return Character.MIN_VALUE
        return text[currentIndex + 1]
    }

}