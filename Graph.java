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
    
    public List<Integer> caminho(int a, int b) {
    Stack<Integer> stack = new Stack<>();
    boolean[] visited = new boolean[numVertices];
    stack.push(a);
    visited[a] = true;

    while (!stack.isEmpty()) {
        int current = stack.pop();
        if (current == b) {
            // Encontrou o caminho, retorna a pilha como lista
            List<Integer> path = new ArrayList<>(stack);
            path.add(current);
            return path;
        }
        for (int neighbor : getNeighbors(current)) {
            if (!visited[neighbor]) {
                stack.push(neighbor);
                visited[neighbor] = true;
            }
        }
    }
    // Não encontrou caminho
    return null;
}
    
    public static Graph uniao(Graph G1, Graph G2) {
    int numVertices = G1.numVertices + G2.numVertices;
    Graph unionGraph = new Graph(numVertices);

    // Adiciona arestas de G1
    for (int i = 0; i < G1.numVertices; i++) {
        for (int j = 0; j < G1.numVertices; j++) {
            int weight = G1.adjacencyMatrix[i][j];
            if (weight != 0) {
                unionGraph.addEdge(i, j, weight);
            }
        }
    }

    // Adiciona arestas de G2
    for (int i = 0; i < G2.numVertices; i++) {
        for (int j = 0; j < G2.numVertices; j++) {
            int weight = G2.adjacencyMatrix[i][j];
            if (weight != 0) {
                unionGraph.addEdge(G1.numVertices + i, G1.numVertices + j, weight);
            }
        }
    }

    return unionGraph;
}
    
    public static Graph interseccao(Graph G1, Graph G2) {
    int numVertices = Math.min(G1.numVertices, G2.numVertices);
    Graph intersectionGraph = new Graph(numVertices);

    for (int i = 0; i < numVertices; i++) {
        for (int j = 0; j < numVertices; j++) {
            if (G1.adjacencyMatrix[i][j] != 0 && G2.adjacencyMatrix[i][j] != 0) {
                intersectionGraph.addEdge(i, j, Math.min(G1.adjacencyMatrix[i][j], G2.adjacencyMatrix[i][j]));
            }
        }
    }

   



}
