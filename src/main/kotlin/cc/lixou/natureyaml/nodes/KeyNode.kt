package cc.lixou.natureyaml.nodes

data class KeyNode(val key: String, val value: ValueNode) : YamlNode()