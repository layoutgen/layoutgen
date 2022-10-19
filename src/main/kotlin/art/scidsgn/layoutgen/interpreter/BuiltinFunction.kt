package art.scidsgn.layoutgen.interpreter

abstract class BuiltinFunction(val name: String) {
    // TODO: maybe a predefined contract for checking arguments before interpreting?

    abstract fun execute(context: FunctionContext): Any
}