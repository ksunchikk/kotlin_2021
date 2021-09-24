class MyList<T>() {
    private data class Node<T>(var inf: T, var index: Int = 0, var next: Node<T>? = null)

    private var head: Node<T>? = null
    fun add(nInf: T) {
        if (head == null) {
            head = Node(nInf, 0)
        } else {
            var cur = head
            while (cur?.next != null) {
                cur = cur?.next
            }
            cur?.next = Node(nInf, cur!!.index + 1)
        }
    }

    fun set(n: Int, nInf: T) {
        var cur = head
        while (cur != null) {
            if (cur?.index == n ) {
                cur?.inf = nInf
                return
            }
            cur = cur?.next
        }
        error("There isn't node with this number. Operation SET is invalid!")
    }

    fun contains(nInf: T): Boolean {
        var cur = head
        while (cur != null) {
            if (cur!!.inf == nInf) return true
            cur = cur?.next
        }
        return false
    }

    fun indexOf(nInf: T): Int {
        var cur = head
        while (cur != null) {
            if (cur?.inf == nInf) return cur?.index
            cur = cur?.next
        }
        return -1
    }

    fun remove(nInf: T) {
        var cur = head
        if (cur?.inf == nInf) {
            this.head = cur?.next
            var tmp = head
            while (tmp != null) {
                tmp?.index--
                tmp = tmp?.next
            }
        } else {
            while (cur?.next != null) {
                if (cur?.next!!?.inf == nInf) {
                    cur?.next = cur?.next?.next
                    cur = cur?.next
                    while (cur != null) {
                        cur?.index--
                        cur = cur?.next
                    }
                    break
                }
                cur = cur?.next
            }
        }
    }
}

fun main(args: Array<String>) {
    var nu = MyList<String>()
    nu.add("abb")
    nu.add("gg")
    nu.add("ktrn")
    nu.add("abcd")
    nu.set(2, "hh")
    println(nu.contains("ktrn"))
    println(nu.contains("tt"))
    println(nu.indexOf("ktrn"))
    println(nu.indexOf("tt"))
    println(nu.contains("abcd"))
    nu.remove("abcd")
    println(nu.contains("abcd"))
    nu.remove("abb")
}
