import java.util.PriorityQueue

class MSTCalculator(private val graph: Graph) {

    /**
     * Calculates and returns the Minimum Spanning Tree (MST) for the graph.
     */
    fun calculateMST(): List<Edge> {
        val parent = graph.capitals.associateWith { it }.toMutableMap()
        val rank = graph.capitals.associateWith { 0 }.toMutableMap()

        fun find(capital: Capital): Capital {
            if (parent[capital] != capital) parent[capital] = find(parent[capital]!!)
            return parent[capital]!!
        }

        fun union(cap1: Capital, cap2: Capital) {
            val root1 = find(cap1)
            val root2 = find(cap2)
            if (root1 != root2) {
                if (rank[root1]!! > rank[root2]!!) parent[root2] = root1
                else {
                    parent[root1] = root2
                    if (rank[root1] == rank[root2]) rank[root2] = rank[root2]!! + 1
                }
            }
        }

        val priorityQueue = PriorityQueue(graph.edges)
        return generateSequence { priorityQueue.poll() }
            .filter { it != null && find(it.capital1) != find(it.capital2) }
            .onEach { union(it.capital1, it.capital2) }
            .take(graph.capitals.size - 1)
            .toList()
    }
}



