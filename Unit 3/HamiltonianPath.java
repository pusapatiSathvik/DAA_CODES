import java.util.Arrays;

public class HamiltonianPath {
    public static void main(String[] args) {
        // Example graph as adjacency matrix
        int[][] graph = {
            {0, 1, 1, 1},
            {1, 0, 1, 0},
            {1, 1, 0, 1},
            {1, 0, 1, 0}
        };

        int numVertices = graph.length; // Number of vertices in the graph
        int[] path = new int[numVertices]; // To store the Hamiltonian Path
        Arrays.fill(path, -1); // Initialize path as empty

        // Start the path with vertex 0
        path[0] = 0;

        if (hamiltonianPath(graph, path, numVertices, 1)) {
            System.out.println("Hamiltonian Path exists: " + Arrays.toString(path));
        } else {
            System.out.println("No Hamiltonian Path exists.");
        }
    }

    static boolean hamiltonianPath(int[][] graph, int[] path, int numVertices, int pos) {
        // Base case: If all vertices are included in the path
        if (pos == numVertices) {
            return true;
        }

        // Try different vertices as the next candidate
        for (int v = 0; v < numVertices; v++) {
            // Check if adding vertex v is valid
            if (isSafe(graph, path, v, pos)) {
                path[pos] = v; // Add vertex to path

                // Recur to construct the rest of the path
                if (hamiltonianPath(graph, path, numVertices, pos + 1)) {
                    return true;
                }

                // Backtrack
                path[pos] = -1;
            }
        }
        return false; // No vertex could be added
    }

    static boolean isSafe(int[][] graph, int[] path, int v, int pos) {
        // Check if this vertex is adjacent to the previous one
        if (graph[path[pos - 1]][v] == 0) {
            return false;
        }

        // Check if the vertex is already included in the path
        for (int i = 0; i < pos; i++) {
            if (path[i] == v) {
                return false;
            }
        }

        return true;
    }
}
