import java.io.File

class binaryTree {
    private val treeArr: dynamicArray<Char> = dynamicArray()
    private var countTree: Int = 0
    private val mem: Int = 0
    private var rootTree: Int = 0
    private var index: Int = 0
    private var count: Int = 0

    private fun isNull(bt: Int): Boolean {
        if (bt < 0) {
            return true
        }
        val res = treeArr[bt]
        return res.nullBool
    }

    private fun root(bt: Int): Char? {
        val res = treeArr[bt]
        return res.root
    }

    private fun cons(elem: Char, left: Int, right: Int): Int {
        treeArr.push(treeNode<Char>(false, elem, left, right))
        countTree += 1
        return countTree - 1
    }

    //добавить файл
    fun writeNode(bt: Int, file: File?) {
        if (file != null) {
            if (!isNull(bt)) {
                file.appendText(root(bt).toString())
                writeNode(treeArr[bt].leftIndex, file)
                writeNode(treeArr[bt].rightIndex, file)
            }
        } else {
            if (!isNull(bt)) {
                print(root(bt))
                writeNode(treeArr[bt].leftIndex, null)
                writeNode(treeArr[bt].rightIndex, null)
            }
        }
    }

    fun writeLeaflet(bt: Int, file: File?) {
        if (file != null) {
            if (!isNull(bt)) {
                if (isNull(treeArr[bt].leftIndex) && isNull(treeArr[bt].rightIndex)) {
                    file.appendText(root(bt).toString())
                }
                writeLeaflet(treeArr[bt].leftIndex, file)
                writeLeaflet(treeArr[bt].rightIndex, file)
            }
        } else {
            if (!isNull(bt)) {
                if (isNull(treeArr[bt].leftIndex) && isNull(treeArr[bt].rightIndex)) {
                    print(root(bt))
                }
                writeLeaflet(treeArr[bt].leftIndex, null)
                writeLeaflet(treeArr[bt].rightIndex, null)
            }
        }
    }

    fun writeLevel(bt: Int, level: Int, n: Int) {
        if (!isNull(bt)) {
            if (n == level) {
                count += 1
                return
            }
            writeLevel(treeArr[bt].leftIndex, level + 1, n)
            writeLevel((treeArr[bt].rightIndex), level + 1, n)
        }

    }


    fun enterTree(string: String): Int {
        val l: Int
        val r: Int
        val ch: Char = string[index]
        if (ch == '/') {
            return -1
        } else {
            index += 1
            l = enterTree(string)
            index += 1
            r = enterTree(string)
            return cons(ch, l, r)
        }
    }

    fun enter(): Boolean {
        val type:Int
        println("Enter from console -1")
        println("Enter from file -2")
        type = scan.nextInt()

        when (type) {
            1 -> {
                val string = scan.next()
                index = 0
                rootTree = enterTree(string)
            }
            2 -> {
                var string = scan.next()
                index = 0
                val file = File(string)
                string = file.readLines()[0]
                rootTree = enterTree(string)
            }
            else -> return false
        }
        return true
    }

    fun writeResult(): Boolean {
        val type:Int
        count = 0
        println("Print to console -1")
        println("Print to file -2")
        type = scan.nextInt()
        println("At what level to count the number of tree nodes?")
        val level = scan.nextInt()

        when (type) {
            1 -> {
                print("Tree elements: ")
                writeNode(rootTree, null)
                println()
                print("Tree leaves:")
                writeLeaflet(rootTree, null)
                println()
                print("Count tree elements with level ${level}:")
                writeLevel(rootTree, 0, level)
                print(count)
            }
            2 -> {
                println("Enter file name")
                val string = scan.next()
                index = 0
                val file = File(string)
                file.writeText("")
                file.appendText("Tree elements:")
                writeNode(rootTree, file)
                file.appendText("\n")
                file.appendText("Tree leaves:")
                writeLeaflet(rootTree, file)
                file.appendText("\n")
                file.appendText("Count tree elements with level ${level}:")
                writeLevel(rootTree, 0, level)
                file.appendText(count.toString())
            }
            else -> return false
        }
        return true
    }
}

