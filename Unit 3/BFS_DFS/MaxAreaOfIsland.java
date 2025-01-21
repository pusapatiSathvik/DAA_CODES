import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid){
        int max = 0;
        int row=grid.length , cols = grid[0].length;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for(int i=0;i<row;i++){
            for(int j=0;j<cols;j++){
                if (grid[i][j]==1) {
                    int area = 0;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i,j});
                    grid[i][j]=0;          //visited


                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        int x=curr[0],y=curr[1];
                        area++;

                        for(int k=0;k<4;k++){
                            int nx = x + dx[k];
                            int ny = y + dy[k];


                            // check valid

                            if (nx>=0 && nx<row && ny>=0 && ny<cols && grid[i][j]==1) {
                                q.add(new int[]{nx,ny});
                                grid[nx][ny] = 0;
                            }

                        }
                    }
                    max = Math.max(max, area);

                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        MaxAreaOfIsland solution = new MaxAreaOfIsland();
        int[][] grid = {
            {0, 0, 1, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 1, 0},
            {1, 1, 0, 0, 0}
        };
        System.out.println("Max Area of Island: " + solution.maxAreaOfIsland(grid)); // Output: 5
    }
}
