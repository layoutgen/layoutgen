package art.scidsgn.layoutgen.interpreter

import art.scidsgn.layoutgen.ruletree.Ruletree
import art.scidsgn.layoutgen.ruletree.ast.BuiltinCall
import kotlin.reflect.typeOf

class FunctionContext(
    val interpreter: Interpreter,
    val ruleTree: Ruletree,
    val builtinCall: BuiltinCall,
    val ruleArguments: Map<String, Any>,
    val depth: Int
) {
    fun expectArgumentIsPresent(name: String) {
        if (!builtinCall.arguments.containsKey(name)) {
            TODO("argument $name not present!")
        }
    }

    fun argumentRawValue(name: String): Any {
        expectArgumentIsPresent(name)
        return interpreter.interpretElement(ruleTree, builtinCall.arguments[name]!!, ruleArguments, depth)
    }

    inline fun <reified T> argumentSingleValue(name: String): T {
        val rawValue = argumentRawValue(name)

        if (rawValue is List<*>) {
            if (rawValue.size == 0) {
                TODO("error about recursion depth limit possibly for arg $name")
            } else if (rawValue.size > 1) {
                TODO("function expects only 1 item")
            }

            if (rawValue[0] is T) {
                return rawValue[0] as T
            }
        } else if (rawValue is T) {
            return rawValue
        }

        TODO("error: expected $name be of type ${typeOf<T>()}")
    }

    inline fun <reified T> argumentList(name: String): List<T> {
        val rawValue = argumentRawValue(name)

        val rawList = if (rawValue is List<*>) rawValue else listOf(rawValue)

        rawList.forEach {
            if (it !is T) {
                TODO("at least one of the items in $name ain't good!!")
            }
        }

        return rawList as List<T>
    }

    inline fun <reified T> body(): List<T> {
        val rawList = builtinCall.body.map {
            interpreter.interpretElement(ruleTree, it, ruleArguments, depth)
        }.flat()

        rawList.forEach {
            if (it !is T) {
                TODO("at least one of the items in the function body ain't good!!")
            }
        }

        return rawList as List<T>
    }
}
