package art.scidsgn.layoutgen.error

enum class Errors(val message: String) {
    COULD_NOT_LOAD_SOURCE_FILE("Could not load source file %s"),
    MODULE_ALREADY_EXISTS("Module %s already imported"),
    MODULE_NOT_FOUND("Module %s not found"),

    IS_RULE_NOT_FOUND("Is-rule %s not found"),
    IS_RULE_ALREADY_DEFINED("Is-rule %s already defined"),
    REWRITE_RULE_NOT_FOUND("Rewrite rule %s not found"),
    REWRITE_RULE_ALREADY_DEFINED("Rewrite rule %s already defined"),

    ROOT_RULE_NOT_PRESENT("@Root rule not present"),
    ROOT_RULE_ALREADY_PRESENT("There can be only one @Root rule"),

    RULE_INCORRECT_ARGUMENT_COUNT("Rule %s expected %s arguments, provided %s"),
    RULE_UNEXPECTED_ARGUMENT("Unexpected argument %s"),

    RULE_UNDEFINED_VARIABLE("Undefined variable %s"),

    COLOR_SYNTAX_INCORRECT("Hex colors must be in one of the following formats: #RGB, #RGBA, #RRGGBB, or #RRGGBBAA"),

    BUILTIN_FUNCTION_NOT_FOUND("%s is not a defined built-in function"),

    BUILTIN_FUNCTION_ARGUMENT_NOT_PRESENT("Required argument %s is not present"),
    BUILTIN_FUNCTION_ARGUMENT_EXPECTED_ONE_ITEM_BUT_ZERO_PROVIDED("Function expects only one value for argument %s, but none was provided (might be a recursion depth issue)"),
    BUILTIN_FUNCTION_ARGUMENT_EXPECTED_ONE_ITEM_BUT_MORE_PROVIDED("Function expects only one value for argument %s, but more was provided"),
    BUILTIN_FUNCTION_ARGUMENT_INCORRECT_TYPE("Argument %s must be of type %s"),
    BUILTIN_FUNCTION_ARGUMENT_ENUM_INCORRECT_VALUE("Argument %s must be one of the following: %s"),

    BUILTIN_FUNCTION_USELESS_BODY("Function %s does not require a body"),
    BUILTIN_FUNCTION_BODY_INCORRECT_TYPE("All body arguments must be of type %s"),

    LIST_REPEAT_COUNT_CANNOT_BE_NEGATIVE("Repeat count cannot be negative"),
    LIST_REPEAT_COUNT_MUST_BE_AN_INTEGER("Repeat count must be an integer"),

    LAYOUT_WIDTH_CANNOT_BE_NEGATIVE("Width cannot be negative"),
    LAYOUT_HEIGHT_CANNOT_BE_NEGATIVE("Height cannot be negative"),

    LAYOUT_GAP_CANNOT_BE_NEGATIVE("Gap cannot be negative"),

    LAYOUT_GRID_ROWS_MUST_CANNOT_BE_LESS_THAN_ONE("Row count cannot be less than 1"),
    LAYOUT_GRID_ROWS_MUST_BE_AN_INTEGER("Row count must be an integer"),
    LAYOUT_GRID_COLS_MUST_CANNOT_BE_LESS_THAN_ONE("Column count cannot be less than 1"),
    LAYOUT_GRID_COLS_MUST_BE_AN_INTEGER("Column count must be an integer"),

    LAYOUT_MARGIN_CANNOT_BE_NEGATIVE("Margin value cannot be negative"),

    LAYOUT_FLEX_GROW_CANNOT_BE_NEGATIVE("Flex grow cannot be negative"),

    SHAPE_ROUNDING_RADIUS_CANNOT_BE_NEGATIVE("Rounding radius cannot be negative"),

    LSYSTEM_DEPTH_CANNOT_BE_NEGATIVE("Depth cannot be negative"),
    LSYSTEM_DEPTH_MUST_BE_AN_INTEGER("Depth must be an integer"),
    LSYSTEM_MUST_BE_A_RULENAME("Element must be a rule name"),
    LSYSTEM_CANNOT_BE_A_MODULENAME("Rule name must be local"),
    LSYSTEM_CANNOT_BE_PARAMETRIZED("Rule must not be parametrized"),

    // TODO: ANTLR errors suck
    ANTLR_SYNTAX_ERROR("ANTLR parser error - %s")
}