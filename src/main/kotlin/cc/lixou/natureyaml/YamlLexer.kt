package cc.lixou.natureyaml

class YamlLexer(private val text: String) {

    private var currentIndex = 0
    private var currentChar = text[currentIndex]

    fun nextToken(): Token? {
        skipWhitespace()
        val result = when {
            currentChar == Character.MIN_VALUE -> null
            currentChar == ':' -> _parseCurrent(TokenType.COLON)
            currentChar.isLetter() -> parseLiteral()
            else -> throw IllegalStateException("No Token found: '$currentChar'")
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

    private fun _parseCurrent(type: TokenType): Token = Token(type, currentChar.toString())

    private fun skipWhitespace() {
        while (currentChar.isWhitespace() && currentChar != Character.MIN_VALUE) {
            advance()
        }
    }

    private fun advance(): Char {
        currentIndex++
        currentChar = if (text.length <= currentIndex) {
            Character.MIN_VALUE
        } else {
            text[currentIndex]
        }
        return currentChar
    }

    private fun peek(): Char {
        if (text.length <= currentIndex + 1) return Character.MIN_VALUE
        return text[currentIndex + 1]
    }

}