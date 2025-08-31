data class Edge(val capital1: Capital, val capital2: Capital, val distance: Int) : Comparable<Edge> {
    override fun compareTo(other: Edge) = this.distance - other.distance
}

