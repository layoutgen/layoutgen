package art.scidsgn.layoutgen.interpreter

enum class TypeName(val typeName: String) {
    BASE("Base"),
    NUMBER("Number"),
    STRING("String"),
    BOOLEAN("Boolean"),
    COMPONENT("Component"),
    COLOR("Color"),
    FILL("Fill"),
    GRADIENT_STOP("Stop"),
    STROKE("Stroke"),
    POINT("Point"),
    PATH_INSTRUCTION("PathInstruction"),
    TURTLE_INSTRUCTION("TurtleInstruction"),
    FONT("Font"),
    IMAGE("Image")
}