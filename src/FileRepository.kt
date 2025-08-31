import java.io.File
import java.io.FileNotFoundException

interface GraphRepository {
    fun loadGraph(filename: String): Graph
}

class FileRepository : GraphRepository {

    /**
     * Loads a graph from a file.
     * @param filename Path to the file.
     * @throws FileNotFoundException if the file cannot be found.
     * @throws IllegalArgumentException for invalid file content.
     */
    override fun loadGraph(filename: String): Graph {
        val graph = Graph()
        val file = File(filename)

        if (!file.exists()) {
            throw FileNotFoundException("File '$filename' not found.")
        }

        file.forEachLine { line ->
            val parts = line.split(",")
            if (parts.size == 3) {
                try {
                    val capital1 = parts[0].trim()
                    val capital2 = parts[1].trim()
                    val distance = parts[2].trim().toInt()
                    graph.addEdge(capital1, capital2, distance)
                } catch (e: NumberFormatException) {
                    throw IllegalArgumentException("Invalid distance format in line: $line")
                }
            } else {
                throw IllegalArgumentException("Invalid line format: $line")
            }
        }

        return graph
    }
}

