package art.scidsgn.layoutgen.interpreter

enum class TypeName(val typeName: String) {
    BASE("Base"),
    NUMBER("Number"),
    STRING("String"),
    BOOLEAN("Boolean"),
    COMPONENT("Component"),
    FILL("Fill"),
    STROKE("Stroke"),
    POINT("Point"),
    PATH_INSTRUCTION("PathInstruction"),
    FONT("Font"),
    IMAGE("Image")
}