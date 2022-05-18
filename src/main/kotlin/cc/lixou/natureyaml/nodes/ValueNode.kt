package cc.lixou.natureyaml.nodes

abstract class ValueNode(val data: Any?) : YamlNode()


class EmptyNode : ValueNode(null)

data class StringNode(val text: String) : ValueNode(text)