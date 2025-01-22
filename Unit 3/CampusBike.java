import java.util.HashSet;
import java.util.Set;

public class CampusBikesII {
    public static void main(String[] args) {
        int[][] workers = {{0, 0}, {2, 1}};
        int[][] bikes = {{1, 2}, {3, 3}};

        int minDistance = assignBikes(workers, bikes);
        System.out.println("Minimum Manhattan Distance: " + minDistance);
    }

    public static int assignBikes(int[][] workers, int[][] bikes) {
        // Use backtracking to find the minimum Manhattan distance
        return backtrack(workers, bikes, 0, new HashSet<>(), 0, Integer.MAX_VALUE);
    }

    private static int backtrack(int[][] workers, int[][] bikes, int workerIndex, 
                                 Set<Integer> visited, int currentSum, int minDistance) {
        // Base case: All workers have been assigned bikes
        if (workerIndex == workers.length) {
            return Math.min(minDistance, currentSum);
        }

        // Prune: If the current sum exceeds the minimum found so far, stop exploring
        if (currentSum >= minDistance) {
            return minDistance;
        }

        // Try assigning each bike to the current worker
        for (int i = 0; i < bikes.length; i++) {
            if (!visited.contains(i)) {
                visited.add(i); // Mark this bike as used
                int distance = manhattanDistance(workers[workerIndex], bikes[i]);
                minDistance = backtrack(workers, bikes, workerIndex + 1, visited, 
                                        currentSum + distance, minDistance);
                visited.remove(i); // Backtrack
            }
        }

        return minDistance;
    }

    private static int manhattanDistance(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }
}
