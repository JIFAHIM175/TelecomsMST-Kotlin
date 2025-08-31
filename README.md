# Telecoms MST Kotlin

A Kotlin desktop application for planning telecom networks between European capitals. The app uses graph-based modeling and calculates the **Minimum Spanning Tree (MST)** to determine the minimum total cable length required to connect all capitals.

---

## Features

- Load and process a file containing distances between European capitals.
- Object-oriented domain and entity classes for graph representation.
- Minimum Spanning Tree calculation using a weighted graph.
- User-friendly interface (CLI or GUI) to view the network and MST.

---

## Project Structure

TelecomsMST-Kotlin/
├── src/
│ ├── main.kt # Entry point
│ ├── domain/ # Domain and entity classes
│ └── mst/ # Minimum Spanning Tree algorithm
├── data/ # Sample input files
└── README.md

markdown
Copy code

- `domain/`: Contains classes for nodes, edges, and graph structure.
- `mst/`: Contains the MST algorithm implementation.
- `data/`: Example CSV files with distances between capitals.

---

## Getting Started

### Prerequisites

- JDK 11 or higher
- Kotlin (latest stable version)
- IntelliJ IDEA (recommended) or any Kotlin-compatible IDE

### Running the Application

1. Clone the repository:
```bash
git clone https://github.com/<USERNAME>/TelecomsMST-Kotlin.git
cd TelecomsMST-Kotlin
Open the project in IntelliJ IDEA or build with Gradle/CLI.

Run the main.kt file.

Load a CSV file containing distances between European capitals. Example format:

python-repl
Copy code
Source,Destination,Distance
Paris,Berlin,1050
London,Paris,340
...
View the generated Minimum Spanning Tree and total cable length.
