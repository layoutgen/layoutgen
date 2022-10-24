package art.scidsgn.layoutgen.interpreter

import art.scidsgn.layoutgen.error.Errors
import art.scidsgn.layoutgen.error.GeneralError
import art.scidsgn.layoutgen.error.InFileError
import art.scidsgn.layoutgen.ruletree.Ruletree
import art.scidsgn.layoutgen.ruletree.ast.BuiltinCall

class FunctionContext(
    val interpreter: Interpreter,
    val ruleTree: Ruletree,
    val builtinCall: BuiltinCall,
    val ruleArguments: Map<String, Any>,
    val depth: Int
) {
    fun hasArgument(name: String): Boolean {
        return builtinCall.arguments.containsKey(name)
    }

    fun expectArgumentIsPresent(name: String) {
        if (!builtinCall.arguments.containsKey(name)) {
            throw InFileError(
                Errors.BUILTIN_FUNCTION_ARGUMENT_NOT_PRESENT, arrayOf(name),
                builtinCall.codePosition
            )
        }
    }

    fun argumentRawValue(name: String): Any {
        expectArgumentIsPresent(name)
        return interpreter.interpretElement(
            ruleTree,
            builtinCall.arguments[name]!!,
            ruleArguments,
            depth
        )
    }

    inline fun <reified T> argumentSingleValue(
        name: String,
        typeName: TypeName,
        checkBlock: (value: T) -> Unit = {}
    ): T {
        val rawValue = argumentRawValue(name)
        val codePosition = builtinCall.arguments[name]!!.codePosition

        if (rawValue is List<*>) {
            if (rawValue.size == 0) {
                throw InFileError(
                    Errors.BUILTIN_FUNCTION_ARGUMENT_EXPECTED_ONE_ITEM_BUT_ZERO_PROVIDED,
                    arrayOf(name),
                    codePosition
                )
            } else if (rawValue.size > 1) {
                throw InFileError(
                    Errors.BUILTIN_FUNCTION_ARGUMENT_EXPECTED_ONE_ITEM_BUT_MORE_PROVIDED,
                    arrayOf(name),
                    codePosition
                )
            }

            if (rawValue[0] is T) {
                try {
                    checkBlock(rawValue[0] as T)
                } catch (e: GeneralError) {
                    throw InFileError(e, codePosition)
                }

                return rawValue[0] as T
            }
        } else if (rawValue is T) {
            try {
                checkBlock(rawValue)
            } catch (e: GeneralError) {
                throw InFileError(e, codePosition)
            }

            return rawValue
        }

        throw InFileError(
            Errors.BUILTIN_FUNCTION_ARGUMENT_INCORRECT_TYPE, arrayOf(name, typeName.typeName),
            codePosition
        )
    }

    fun <T> argumentEnumValue(name: String, enumMap: Map<String, T>): T {
        val codePosition = builtinCall.arguments[name]!!.codePosition
        val error = InFileError(
            Errors.BUILTIN_FUNCTION_ARGUMENT_ENUM_INCORRECT_VALUE, arrayOf(
                name, enumMap.keys.map { "\"${it}\"" }.joinToString(", ")
            ), codePosition
        )

        val strValue = try {
            argumentSingleValue<String>(name, TypeName.STRING)
        } catch (e: InFileError) {
            throw error
        }

        if (!enumMap.containsKey(strValue)) {
            throw error
        }

        return enumMap[strValue]!!
    }

    inline fun <reified T> argumentList(name: String, typeName: TypeName): List<T> {
        val rawValue = argumentRawValue(name)
        val codePosition = builtinCall.arguments[name]!!.codePosition

        val rawList = if (rawValue is List<*>) rawValue else listOf(rawValue)

        rawList.forEach {
            if (it !is T) {
                throw InFileError(
                    Errors.BUILTIN_FUNCTION_ARGUMENT_INCORRECT_TYPE,
                    arrayOf(name, typeName.typeName),
                    codePosition
                )
            }
        }

        return rawList as List<T>
    }

    fun noBody() {
        if (builtinCall.body.size > 0) {
            throw InFileError(
                Errors.BUILTIN_FUNCTION_USELESS_BODY, arrayOf(builtinCall.name.name),
                builtinCall.body[0].codePosition
            )
        }
    }

    inline fun <reified T> body(typeName: TypeName): List<T> {
        val rawList = builtinCall.body.map {
            interpreter.interpretElement(ruleTree, it, ruleArguments, depth)
        }.flat()

        rawList.forEach {
            if (it !is T) {
                // TODO: per-item codePosition would be useful here
                throw InFileError(
                    Errors.BUILTIN_FUNCTION_BODY_INCORRECT_TYPE, arrayOf(typeName.typeName),
                    builtinCall.body[0].codePosition
                )
            }
        }

        return rawList as List<T>
    }
}
