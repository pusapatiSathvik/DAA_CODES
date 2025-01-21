import java.util.*;

public class DistinctIslandsBFS{
    public int numDistinctIslands(int[][] grid){

        Set<Set<String>> distinct = new HashSet<>();
        int row= grid.length,col = grid[0].length;


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    Set<String> shape = new HashSet<>();
                    bfs(grid,i,j,shape,i,j);
                    distinct.add(shape);

                }
            }
        }

        return distinct.size();

    }

    public void bfs(int[][] grid,int x,int y,Set<String> shape,int basex,int basey){

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        grid[x][y] = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int cx = curr[0],cy = curr[1];

            shape.add((cx-basex)+","+(cy-basey));


            for(int i=0;i<4;i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == 1) {
                    q.add(new int[]{nx, ny});
                    grid[nx][ny] = 0; // Mark as visited
                }

            }
        }
    }

    public static void main(String[] args) {

        DistinctIslandsBFS solution = new DistinctIslandsBFS();

        int[][] grid1 = {
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 1}
        };
        System.out.println("Number of distinct islands: " + solution.numDistinctIslands(grid1)); // Output: 1

        int[][] grid2 = {
            {1, 1, 0, 1, 1},
            {1, 0, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {1, 1, 0, 1, 1}
        };
        System.out.println("Number of distinct islands: " + solution.numDistinctIslands(grid2)); // Output: 3
    }
}
