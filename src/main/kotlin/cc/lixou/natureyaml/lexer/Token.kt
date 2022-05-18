package cc.lixou.natureyaml.lexer

import cc.lixou.natureyaml.lexer.TokenType

data class Token(val type: TokenType, val data: Any? = null)