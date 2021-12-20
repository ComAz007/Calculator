package expression

import operation.Token

class NumberLiteral(private val token: Token) : Expression {

    override fun evaluate(): Float = token.value as Float

    override fun toString(): String {
        return "${(token.value as Float)}"
    }
}