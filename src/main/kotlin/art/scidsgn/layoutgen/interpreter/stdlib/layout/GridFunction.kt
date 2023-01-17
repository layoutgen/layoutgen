package art.scidsgn.layoutgen.interpreter.stdlib.layout

import art.scidsgn.layoutgen.components.Component
import art.scidsgn.layoutgen.components.layout.grid.Grid
import art.scidsgn.layoutgen.error.Errors
import art.scidsgn.layoutgen.error.GeneralError
import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.interpreter.stdlib.utils.LayoutFunctionUtils

class GridFunction : BuiltinFunction("Grid") {
    override fun execute(context: FunctionContext): Grid {
        // TODO: "each" argument

        val rows = context.argumentSingleValue<Double>("rows", TypeName.NUMBER) {
            if (it < 1) {
                throw GeneralError(Errors.LAYOUT_GRID_ROWS_MUST_CANNOT_BE_LESS_THAN_ONE)
            } else if (it.rem(1) != 0.0) {
                throw GeneralError(Errors.LAYOUT_GRID_ROWS_MUST_BE_AN_INTEGER)
            }
        }.toInt()
        val cols = context.argumentSingleValue<Double>("cols", TypeName.NUMBER) {
            if (it < 1) {
                throw GeneralError(Errors.LAYOUT_GRID_COLS_MUST_CANNOT_BE_LESS_THAN_ONE)
            } else if (it.rem(1) != 0.0) {
                throw GeneralError(Errors.LAYOUT_GRID_COLS_MUST_BE_AN_INTEGER)
            }
        }.toInt()

        val childComponents: List<Component>
        if (context.hasArgument("each")) {
            childComponents = context.argumentList("each", TypeName.COMPONENT)
        } else {
            childComponents = context.body(TypeName.COMPONENT)
        }

        val component = Grid(rows, cols, childComponents)
        LayoutFunctionUtils.handleContainerArguments(component, context)

        if (context.hasArgument("alignCellsHorizontally")) {
            component.withCellHorizontalAlignment(
                context.argumentEnumValue(
                    "alignCellsHorizontally",
                    LayoutFunctionUtils.horizontalAlignmentMap
                )
            )
        }
        if (context.hasArgument("alignCellsVertically")) {
            component.withCellVerticalAlignment(
                context.argumentEnumValue(
                    "alignCellsVertically",
                    LayoutFunctionUtils.verticalAlignmentMap
                )
            )
        }

        return component
    }
}