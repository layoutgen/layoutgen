package art.scidsgn.layoutgen.interpreter

fun List<Any>.flat(): List<Any> {
    val outputList = mutableListOf<Any>()

    this.forEach {
        if (it is List<*>) {
            outputList.addAll(it as List<Any>)
        } else {
            outputList.add(it)
        }
    }

    return outputList
}