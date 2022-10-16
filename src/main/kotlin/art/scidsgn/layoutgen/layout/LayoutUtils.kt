package art.scidsgn.layoutgen.layout

import art.scidsgn.layoutgen.layout.enums.HorizontalAlignment
import art.scidsgn.layoutgen.layout.enums.VerticalAlignment
import art.scidsgn.layoutgen.layout.sizing.Dimensions

object LayoutUtils {
    fun getComponentsWithoutDefinedWidth(components: List<Component>): List<Component> {
        return components.filter { !it.hasDefinedWidth() }
    }

    fun getComponentsWithoutDefinedHeight(components: List<Component>): List<Component> {
        return components.filter { !it.hasDefinedHeight() }
    }

    fun getCombinedDefinedWidth(components: List<Component>): Double {
        var sum = 0.0

        components.forEach {
            sum += it.size.definedSize.width ?: 0.0
        }

        return sum
    }

    fun getCombinedDefinedHeight(components: List<Component>): Double {
        var sum = 0.0

        components.forEach {
            sum += it.size.definedSize.height ?: 0.0
        }

        return sum
    }

    fun getMaxDefinedWidthOrNull(components: List<Component>): Double? {
        return components.filter { it.hasDefinedWidth() }.maxOfOrNull { it.size.definedSize.width!! }
    }

    fun getMaxDefinedHeightOrNull(components: List<Component>): Double? {
        return components.filter { it.hasDefinedHeight() }.maxOfOrNull { it.size.definedSize.height!! }
    }

    fun getFittingWidth(components: List<Component>): Double {
        return components.sumOf { it.size.targetSize.width }
    }

    fun getFittingHeight(components: List<Component>): Double {
        return components.sumOf { it.size.targetSize.height }
    }

    fun getMaxWidth(components: List<Component>): Double {
        return components.maxOf { it.size.targetSize.width }
    }

    fun getMaxHeight(components: List<Component>): Double {
        return components.maxOf { it.size.targetSize.height }
    }

    fun setTargetSizeForExpansiveComponent(
        component: Component,
        fallbackSize: Dimensions = Dimensions(0.0, 0.0)
    ) {
        component.size.targetSize = Dimensions(
            component.size.definedSize.width ?: component.size.requestedSize.width ?: fallbackSize.width,
            component.size.definedSize.height ?: component.size.requestedSize.height ?: fallbackSize.height
        )
    }

    fun setChildrenParent(parent: ContainerComponent) {
        parent.childComponents.forEach { it.parent = parent }
    }

    fun calculateAlignmentOffset(
        parentDimension: Double, childDimension: Double, alignment: HorizontalAlignment
    ): Double {
        return when (alignment) {
            HorizontalAlignment.LEFT -> 0.0
            HorizontalAlignment.MIDDLE -> (parentDimension - childDimension) / 2.0
            HorizontalAlignment.RIGHT -> parentDimension - childDimension
        }
    }

    fun calculateAlignmentOffset(
        parentDimension: Double, childDimension: Double, alignment: VerticalAlignment
    ): Double {
        return when (alignment) {
            VerticalAlignment.TOP -> 0.0
            VerticalAlignment.CENTER -> (parentDimension - childDimension) / 2.0
            VerticalAlignment.BOTTOM -> parentDimension - childDimension
        }
    }
}