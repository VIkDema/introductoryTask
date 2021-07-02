class dynamicArray<E>(capacity: Int) {
    private var arr: Array<treeNode<E>>? = Array<treeNode<E>>(capacity) { i -> treeNode<E>() }
    private var _size: Int = 0


    fun push(_treeNode: treeNode<E>) {
        if (_size >= size() - 1) {
            val arrNew: Array<treeNode<E>>? = Array<treeNode<E>>(_size * 2) { i -> treeNode<E>() }
            val s = arr!!.size - 1
            for (i in 0..s) {
                arrNew?.set(i, arr!![i])
            }
            arr = arrNew
        }
        arr?.set(_size, _treeNode)
        _size++
    }

    operator fun get(i: Int): treeNode<E> {
        return arr!![i]
    }

    operator fun set(i: Int, b: treeNode<E>) {

        arr!![i] = b
    }

    fun size(): Int {
        return arr!!.size
    }
}

