package art.scidsgn.layoutgen.layout

abstract class ContainerComponent : Component() {
    abstract val childComponents: List<Component>

    abstract fun determineChildrenPositions()

    fun hasChildren(): Boolean {
        return childComponents.isNotEmpty()
    }

    override fun isLaidOut(): Boolean {
        return super.isLaidOut() && childComponents.all { it.isLaidOut() }
    }
}