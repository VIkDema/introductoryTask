class dynamicArray<E>() {
    private var arr: list<treeNode<E>>? = list<treeNode<E>>()
    private var _size: Int = 0

    fun push(_treeNode: treeNode<E>) {
        arr?.pushBack(_treeNode)
        _size++
    }

    operator fun get(i: Int): treeNode<E> {
        return arr!![i]
    }

    operator fun set(i: Int, b: treeNode<E>) {

        arr!![i] = b
    }

    fun size(): Int {
        return arr!!.size()
    }
}

