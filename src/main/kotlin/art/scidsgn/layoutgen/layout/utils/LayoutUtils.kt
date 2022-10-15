package art.scidsgn.layoutgen.layout.utils

import art.scidsgn.layoutgen.layout.Component
import art.scidsgn.layoutgen.layout.ContainerComponent
import art.scidsgn.layoutgen.layout.components.layout.GappedContainerComponent
import art.scidsgn.layoutgen.layout.enums.HorizontalAlignment
import art.scidsgn.layoutgen.layout.enums.VerticalAlignment
import art.scidsgn.layoutgen.layout.sizing.Dimensions
import kotlin.math.max

object LayoutUtils {
    fun getComponentsWithoutDefinedSize(components: List<Component>): List<Component> {
        return components.filter { it.size.definedSize == null }
    }

    fun getCombinedDefinedWidth(components: List<Component>): Double {
        var sum = 0.0

        components.forEach {
            sum += it.size.definedSize?.width ?: 0.0
        }

        return sum
    }

    fun getCombinedDefinedHeight(components: List<Component>): Double {
        var sum = 0.0

        components.forEach {
            sum += it.size.definedSize?.height ?: 0.0
        }

        return sum
    }

    fun getFittingWidth(components: List<Component>): Double {
        var sum = 0.0

        components.forEach {
            sum += it.size.targetSize.width
        }

        return sum
    }

    fun getFittingHeight(components: List<Component>): Double {
        var sum = 0.0

        components.forEach {
            sum += it.size.targetSize.height
        }

        return sum
    }

    fun setTargetSizeForExpansiveComponent(
        component: Component
    ) {
        val fallbackSize = if (component is ContainerComponent) Dimensions(
            getFittingWidth(component.childComponents),
            getFittingHeight(component.childComponents)
        ) else Dimensions(0.0, 0.0)

        if (component.size.definedSize != null) {
            component.size.targetSize = component.size.definedSize!!
        } else {
            component.size.targetSize = component.size.requestedSize ?: fallbackSize
        }
    }

    fun setTargetSizeForExpansiveComponent(
        component: GappedContainerComponent,
        horizontalGap: Double = 0.0,
        verticalGap: Double = 0.0
    ) {
        val gapCount = max(0, component.childComponents.size - 1)
        val fallbackSize = Dimensions(
            getFittingWidth(component.childComponents) + gapCount * horizontalGap,
            getFittingHeight(component.childComponents) + gapCount * verticalGap
        )

        if (component.size.definedSize != null) {
            component.size.targetSize = component.size.definedSize!!
        } else {
            component.size.targetSize = component.size.requestedSize ?: fallbackSize
        }
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