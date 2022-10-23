package art.scidsgn.layoutgen.interpreter.stdlib.layout

import art.scidsgn.layoutgen.interpreter.BuiltinFunction
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName
import art.scidsgn.layoutgen.layout.components.grid.Grid

class GridFunction : BuiltinFunction("Grid") {
    override fun execute(context: FunctionContext): Grid {
        val rows = context.argumentSingleValue<Double>("rows", TypeName.NUMBER) {
            if (it < 1) {
                TODO("rows less than 1")
            } else if (it.rem(1) != 0.0) {
                TODO("rows not int")
            }
        }.toInt()
        val cols = context.argumentSingleValue<Double>("cols", TypeName.NUMBER) {
            if (it < 1) {
                TODO("cols less than 1")
            } else if (it.rem(1) != 0.0) {
                TODO("cols not int")
            }
        }.toInt()

        val component = Grid(rows, cols, context.body(TypeName.COMPONENT))
        LayoutFunctionUtils.handleSizeArguments(component, context)
        LayoutFunctionUtils.handleGapArgument(component, context)

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