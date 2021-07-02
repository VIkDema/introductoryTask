data class node<T>(
    var next: node<T>? = null,
    var value: T? = null,
)

class list<E> {
    private var first: node<E>? = null
    private var last: node<E>? = null
    private var size: Int = 0
    fun isEmpty(): Boolean {
        return first == null
    }

    fun pushBack(value: E) {
        if (isEmpty()) {
            first = node<E>(null, value)
            last = first
            return
        }
        last?.next = node<E>(null, value)
        last = last?.next
        size += 1
    }

    fun remove(index: Int) {
        if (index !in 0..size) throw Exception("Overstepping the list\n")
        if (index == 0 && !isEmpty()) {
            first = first?.next
        }
        if (index <= size) {
            var temp = 0
            var curr = first
            while (temp != index - 1) {
                curr = curr?.next
                temp += 1
            }
            val next = curr?.next?.next
            curr?.next = next
        }
        size -= 1
    }

    operator fun set(i: Int, b: E) {
        if (i !in 0..size) throw Exception("Overstepping the list\n")
        var temp = 0
        var curr = first
        while (temp != i) {
            curr = curr?.next
            temp += 1
        }
        curr?.value = b
    }

    operator fun get(i: Int): E {
        if (i !in 0..size) throw Exception("Overstepping the list\n")
        var temp = 0
        var curr = first
        while (temp != i) {
            curr = curr?.next
            temp += 1
        }
        return curr?.value!!
    }

    fun size(): Int {
        return size
    }

    fun printList() {
        var curr = first
        while (curr?.next != null) {
            println(curr.value)
            curr = curr.next
        }
        println(curr?.value)
    }
}