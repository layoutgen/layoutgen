package art.scidsgn.layoutgen.interpreter.stdlib.layout

import art.scidsgn.layoutgen.components.*
import art.scidsgn.layoutgen.components.layout.GappedContainerComponent
import art.scidsgn.layoutgen.components.layout.alignment.HorizontalAlignment
import art.scidsgn.layoutgen.components.layout.alignment.VerticalAlignment
import art.scidsgn.layoutgen.components.layout.flexbox.enums.FlexContentAlignment
import art.scidsgn.layoutgen.components.layout.flexbox.enums.FlexContentJustification
import art.scidsgn.layoutgen.components.layout.flexbox.enums.FlexDirection
import art.scidsgn.layoutgen.components.layout.flexbox.enums.FlexItemAlignment
import art.scidsgn.layoutgen.components.layout.withGap
import art.scidsgn.layoutgen.components.sizing.Margins
import art.scidsgn.layoutgen.error.Errors
import art.scidsgn.layoutgen.error.GeneralError
import art.scidsgn.layoutgen.interpreter.FunctionContext
import art.scidsgn.layoutgen.interpreter.TypeName

object LayoutFunctionUtils {
    val horizontalAlignmentMap = mapOf(
        Pair("left", HorizontalAlignment.LEFT),
        Pair("middle", HorizontalAlignment.MIDDLE),
        Pair("right", HorizontalAlignment.RIGHT),
    )

    val verticalAlignmentMap = mapOf(
        Pair("top", VerticalAlignment.TOP),
        Pair("center", VerticalAlignment.CENTER),
        Pair("bottom", VerticalAlignment.BOTTOM),
    )

    val flexContentAlignmentMap = mapOf(
        Pair("flexStart", FlexContentAlignment.FLEX_START),
        Pair("flexEnd", FlexContentAlignment.FLEX_END),
        Pair("center", FlexContentAlignment.CENTER),
        Pair("spaceBetween", FlexContentAlignment.SPACE_BETWEEN),
        Pair("spaceAround", FlexContentAlignment.SPACE_AROUND),
        Pair("stretch", FlexContentAlignment.STRETCH),
    )

    val flexContentJustificationMap = mapOf(
        Pair("flexStart", FlexContentJustification.FLEX_START),
        Pair("flexEnd", FlexContentJustification.FLEX_END),
        Pair("center", FlexContentJustification.CENTER),
        Pair("spaceBetween", FlexContentJustification.SPACE_BETWEEN),
        Pair("spaceAround", FlexContentJustification.SPACE_AROUND),
    )

    val flexDirectionMap = mapOf(
        Pair("row", FlexDirection.ROW),
        Pair("column", FlexDirection.COLUMN),
    )

    val flexItemAlignmentMap = mapOf(
        Pair("flexStart", FlexItemAlignment.FLEX_START),
        Pair("flexEnd", FlexItemAlignment.FLEX_END),
        Pair("center", FlexItemAlignment.CENTER),
        Pair("stretch", FlexItemAlignment.STRETCH),
    )
    
    private val marginGuard = { it: Double ->
        if (it < 0.0) {
            throw GeneralError(Errors.LAYOUT_MARGIN_CANNOT_BE_NEGATIVE)
        }
    }

    fun handleContainerArguments(component: Component, context: FunctionContext) {
        handleVisualArguments(component, context)
        handleSizeArguments(component, context)
        handleFlexGrowArgument(component, context)

        if (component is GappedContainerComponent) {
            handleGapArgument(component, context)
        }
    }

    fun getMargins(context: FunctionContext): Margins {
        var left = 0.0
        var top = 0.0
        var right = 0.0
        var bottom = 0.0
        if (context.hasArgument("all")) {
            val value = context.argumentSingleValue("all", TypeName.NUMBER, marginGuard)

            left = value
            top = value
            right = value
            bottom = value
        }
        if (context.hasArgument("vertical")) {
            val value = context.argumentSingleValue("vertical", TypeName.NUMBER, marginGuard)

            top = value
            bottom = value
        }
        if (context.hasArgument("horizontal")) {
            val value = context.argumentSingleValue("horizontal", TypeName.NUMBER, marginGuard)

            left = value
            right = value
        }
        if (context.hasArgument("left")) {
            left = context.argumentSingleValue("left", TypeName.NUMBER, marginGuard)
        }
        if (context.hasArgument("top")) {
            top = context.argumentSingleValue("top", TypeName.NUMBER, marginGuard)
        }
        if (context.hasArgument("right")) {
            right = context.argumentSingleValue("right", TypeName.NUMBER, marginGuard)
        }
        if (context.hasArgument("bottom")) {
            bottom = context.argumentSingleValue("bottom", TypeName.NUMBER, marginGuard)
        }

        return Margins(top, right, bottom, left)
    }

    private fun handleVisualArguments(component: Component, context: FunctionContext) {
        if (context.hasArgument("fill")) {
            component.withFill(context.argumentSingleValue("fill", TypeName.FILL))
        }
        if (context.hasArgument("stroke")) {
            component.withStroke(context.argumentSingleValue("stroke", TypeName.STROKE))
        }
    }

    private fun handleSizeArguments(component: Component, context: FunctionContext) {
        if (context.hasArgument("width")) {
            component.withWidth(context.argumentSingleValue("width", TypeName.NUMBER) {
                if (it < 0) {
                    throw GeneralError(Errors.LAYOUT_WIDTH_CANNOT_BE_NEGATIVE, emptyArray())
                }
            })
        }
        if (context.hasArgument("height")) {
            component.withHeight(context.argumentSingleValue("height", TypeName.NUMBER) {
                if (it < 0) {
                    throw GeneralError(Errors.LAYOUT_HEIGHT_CANNOT_BE_NEGATIVE, emptyArray())
                }
            })
        }
    }

    private fun handleGapArgument(component: GappedContainerComponent, context: FunctionContext) {
        if (context.hasArgument("gap")) {
            component.withGap(context.argumentSingleValue("gap", TypeName.NUMBER) {
                if (it < 0) {
                    throw GeneralError(Errors.LAYOUT_GAP_CANNOT_BE_NEGATIVE, emptyArray())
                }
            })
        }
    }

    private fun handleFlexGrowArgument(component: Component, context: FunctionContext) {
        if (context.hasArgument("flexGrow")) {
            component.withFlexGrow(context.argumentSingleValue("flexGrow", TypeName.NUMBER) {
                if (it < 0) {
                    throw GeneralError(Errors.LAYOUT_FLEX_GROW_CANNOT_BE_NEGATIVE)
                }
            })
        }
    }
}