package cc.lixou.natureyaml.nodes

abstract class ValueNode(val data: Any?) : YamlNode() {

    companion object {
        fun of(obj: Any?) = when {
            obj == null -> EmptyNode()
            obj is String -> StringNode(obj)
            obj is Number -> NumberNode(obj)
            else -> ObjectNode(obj)
        }
    }

}


class EmptyNode : ValueNode(null)

data class StringNode(val text: String) : ValueNode(text)

data class NumberNode(val number: Number) : ValueNode(number)

data class ObjectNode(val obj: Any) : ValueNode(obj)