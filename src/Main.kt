import java.io.FileNotFoundException

class TelecomApp(private val repository: GraphRepository) {

    private var graph: Graph? = null

    /**
     * The main function for running the telecom application.
     */
    fun run() {
        println("Welcome to the EuroConnect Telecoms Application")

        while (true) {
            printMainMenu()
            when (readLine()?.trim()) {
                "1" -> loadCapitalsFile()
                "2" -> displayGraph()
                "3" -> calculateAndDisplayMST()
                "4" -> {
                    println("Exiting application. Goodbye!")
                    return
                }
                else -> println("Invalid choice. Please try again.")
            }
        }
    }

    /**
     * Prints the main menu for the application.
     */
    private fun printMainMenu() {
        println("\nMenu:")
        println("1. Load capitals distance file")
        println("2. Display all capitals and edges")
        println("3. Calculate Minimum Spanning Tree (MST)")
        println("4. Exit")
        print("Enter your choice: ")
    }

    /**
     * Loads the capitals distance file from user input.
     */
    private fun loadCapitalsFile() {
        print("Please enter the filename of the capitals distance data (e.g., resources/Capitals.txt): ")
        val filename = readLine()

        if (filename.isNullOrEmpty()) {
            println("Error: Filename cannot be empty.")
            return
        }

        try {
            graph = repository.loadGraph(filename)
            println("File loaded successfully: ${graph!!.capitals.size} capitals and ${graph!!.edges.size} edges found.")
        } catch (e: FileNotFoundException) {
            println("Error: ${e.message}")
        } catch (e: IllegalArgumentException) {
            println("Error: ${e.message}")
        }
    }

    /**
     * Displays all the capitals and edges in the loaded graph.
     */
    private fun displayGraph() {
        if (graph == null) {
            println("Error: No graph loaded. Please load a file first.")
            return
        }

        println("\nList of all Capitals and Edges:")
        graph!!.edges.forEach {
            println("${it.capital1.name} - ${it.capital2.name}: ${it.distance} km")
        }
    }

    /**
     * Calculates and displays the Minimum Spanning Tree (MST).
     */
    private fun calculateAndDisplayMST() {
        if (graph == null) {
            println("Error: No graph loaded. Please load a file first.")
            return
        }

        try {
            val mstCalculator = MSTCalculator(graph!!)
            val mst = mstCalculator.calculateMST()

            println("\nMinimum Spanning Tree:")
            mst.forEach {
                println("${it.capital1.name} - ${it.capital2.name}: ${it.distance} km")
            }
            val totalDistance = mst.sumOf { it.distance }
            println("Total Cable Length Required: $totalDistance km")
        } catch (e: Exception) {
            println("Error calculating MST: ${e.message}")
        }
    }
}

fun main() {
    val repository = FileRepository()
    val app = TelecomApp(repository)
    app.run()
}





