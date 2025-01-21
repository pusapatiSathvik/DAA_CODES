import java.util.*;

class FloydWarshall {
    final static int INF = 99999; // A large number to represent infinity

    public void floydWarshall(int[][] graph) {
        int n = graph.length;
        int[][] dist = new int[n][n];

        // Initialize the solution matrix same as input graph matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Update the solution matrix using Floyd-Warshall Algorithm
        for (int k = 0; k < n; k++) { // Intermediate vertex
            for (int i = 0; i < n; i++) { // Source vertex
                for (int j = 0; j < n; j++) { // Destination vertex
                    // If vertex k is on the shortest path from i to j, update dist[i][j]
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Print the final distance matrix
        printSolution(dist);
    }

    private void printSolution(int[][] dist) {
        System.out.println("Shortest distances between every pair of vertices:");
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[i].length; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        FloydWarshall fw = new FloydWarshall();

        int[][] graph = {
            {0, 3, INF, 5},
            {2, 0, INF, 4},
            {INF, 1, 0, INF},
            {INF, INF, 2, 0}
        };

        fw.floydWarshall(graph);
    }
}
