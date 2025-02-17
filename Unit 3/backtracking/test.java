import java.util.*;

public class test {

    // Method to find all Hamiltonian Cycles
    public static List<List<Integer>> findRoutes(int[][] roadmap, int n) {
        List<List<Integer>> allRoutes = new ArrayList<>();
        boolean[] visited = new boolean[n];
        List<Integer> route = new ArrayList<>();
        route.add(0); // Start from the first city
        visited[0] = true;

        // Start backtracking to find all Hamiltonian Cycles
        solve(roadmap, route, visited, n, 1, allRoutes);
        
        return allRoutes;
    }

    // Method to perform backtracking and collect all solutions
    private static void solve(int[][] roadmap, List<Integer> route, boolean[] visited, int n, int count, List<List<Integer>> allRoutes) {
        // Base condition: If we have visited all cities and there's a road back to the first city
        if (count == n) {
            int lastCity = route.get(route.size() - 1);
            if (roadmap[lastCity][0] == 1) { // Check if there's a road back to the first city
                allRoutes.add(new ArrayList<>(route)); // Add the valid cycle to the result list
            }
            return;
        }

        // Try all possible next cities
        int currentCity = route.get(route.size() - 1);
        for (int nextCity = 0; nextCity < n; nextCity++) {
            // Check if nextCity can be visited
            if (roadmap[currentCity][nextCity] == 1 && !visited[nextCity]) {
                route.add(nextCity);
                visited[nextCity] = true;

                solve(roadmap, route, visited, n, count + 1, allRoutes); // Recurse for the next city

                // Backtrack
                route.remove(route.size() - 1);
                visited[nextCity] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the size of the roadmap (N)
        int n = sc.nextInt();
        int[][] roadmap = new int[n][n];

        // Input the roadmap grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                roadmap[i][j] = sc.nextInt();
            }
        }

        // Find all the Hamiltonian Cycles
        List<List<Integer>> routes = findRoutes(roadmap, n);

        // Print the result
        if (routes.isEmpty()) {
            System.out.println("No Solution");
        } else {
            System.out.println("Solutions :");

            for (List<Integer> route : routes) {
                for (int city : route) {
                    System.out.print(city + " ");
                }
                System.out.println(); // Print each cycle on a new line
            }
        }
    }
}
