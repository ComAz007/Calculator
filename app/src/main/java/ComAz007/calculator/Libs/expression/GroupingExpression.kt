package expression

class GroupingExpression(private val expression: Expression) : Expression {

    override fun evaluate(): Float = expression.evaluate()
    override fun toString(): String {
        return "( $expression )"
    }
}