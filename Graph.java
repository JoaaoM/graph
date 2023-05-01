public class Graph {
    private int[][] adjacencyMatrix;
    private int numVertices;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int source, int destination, int weight) {
        adjacencyMatrix[source][destination] = weight;
        adjacencyMatrix[destination][source] = weight;
    }

    public void removeEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 0;
        adjacencyMatrix[destination][source] = 0;
    }

    public boolean isAdjacent(int source, int destination) {
        return adjacencyMatrix[source][destination] != 0;
    }

    public List<Integer> getNeighbors(int vertex) {
        List<Integer> neighbors = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[vertex][i] != 0) {
                neighbors.add(i);
            }
        }
        return neighbors;
    }

    public void addVertex() {
        int[][] newMatrix = new int[numVertices + 1][numVertices + 1];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                newMatrix[i][j] = adjacencyMatrix[i][j];
            }
        }
        adjacencyMatrix = newMatrix;
        numVertices++;
    }

    public void removeVertex(int vertex) {
        int[][] newMatrix = new int[numVertices - 1][numVertices - 1];
        int iNew = 0;
        int jNew;
        for (int i = 0; i < numVertices; i++) {
            if (i == vertex) {
                continue;
            }
            jNew = 0;
            for (int j = 0; j < numVertices; j++) {
                if (j == vertex) {
                    continue;
                }
                newMatrix[iNew][jNew] = adjacencyMatrix[i][j];
                jNew++;
            }
            iNew++;
        }
        adjacencyMatrix = newMatrix;
        numVertices--;
    }

    public int getVertexValue(int vertex) {
        return 0;
    }

    public void setVertexValue(int vertex, int value) {
        // do nothing
    }

    public int getEdgeValue(int source, int destination) {
        return adjacencyMatrix[source][destination];
    }

    public void setEdgeValue(int source, int destination, int value) {
        adjacencyMatrix[source][destination] = value;
        adjacencyMatrix[destination][source] = value;
    }
}
