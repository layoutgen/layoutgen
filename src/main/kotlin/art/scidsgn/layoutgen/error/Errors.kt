package art.scidsgn.layoutgen.error

enum class Errors(val message: String) {
    COULD_NOT_LOAD_SOURCE_FILE("Could not load source file %s"),
    MODULE_ALREADY_EXISTS("Module %s already imported"),
    MODULE_NOT_FOUND("Module %s not found"),

    IS_RULE_NOT_FOUND("Is-rule %s not found"),
    REWRITE_RULE_NOT_FOUND("Rewrite rule %s not found"),

    RULE_INCORRECT_ARGUMENT_COUNT("Rule %s expected %s arguments, provided %s"),
    RULE_UNEXPECTED_ARGUMENT("Unexpected argument %s"),

    RULE_UNDEFINED_VARIABLE("Undefined variable %s"),

    BUILTIN_FUNCTION_NOT_FOUND("%s is not a defined built-in function"),

    BUILTIN_FUNCTION_ARGUMENT_NOT_PRESENT("Required argument %s is not present"),
    BUILTIN_FUNCTION_ARGUMENT_EXPECTED_ONE_ITEM_BUT_ZERO_PROVIDED("Function expects only one value for argument %s, but none was provided (might be a recursion depth issue)"),
    BUILTIN_FUNCTION_ARGUMENT_EXPECTED_ONE_ITEM_BUT_MORE_PROVIDED("Function expects only one value for argument %s, but more was provided"),
    BUILTIN_FUNCTION_ARGUMENT_INCORRECT_TYPE("Argument %s must be of type %s"),

    BUILTIN_FUNCTION_USELESS_BODY("Function %s does not require a body"),
    BUILTIN_FUNCTION_BODY_INCORRECT_TYPE("All body arguments must be of type %s")
}