class Graph {
    val edges = mutableListOf<Edge>()
    val capitals = mutableSetOf<Capital>()

    fun addEdge(cap1: String, cap2: String, dist: Int) {
        val capital1 = Capital(cap1)
        val capital2 = Capital(cap2)
        edges.add(Edge(capital1, capital2, dist))
        capitals.add(capital1)
        capitals.add(capital2)
    }
}
