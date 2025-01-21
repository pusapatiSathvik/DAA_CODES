public class RatInMazeDFS {
    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };

        solveMaze(maze);
    }

    public static boolean solveMaze(int[][] maze){
        int n = maze.length;
        int[][] sol = new int[n][n];

        return dfs(maze,0,0,sol);
    }

    private static boolean dfs(int [][] maze,int x,int y,int[][] sol){
        int n = maze.length;

        // bc

        if (x==n-1 && y==n-1 && maze[x][y]==1) {
            sol[x][y] = 1;
            return true;
        }


        // valid pos..

        if (x>=0 && x<n && y>=0 && y<n && maze[x][y]==1) {
            
            sol[x][y] = 1;

            // move right..
            if(dfs(maze, x, y+1, sol)){
                return true;
            }

            // move down..
            if(dfs(maze, x+1, y, sol)){
                return true;
            }


            // backtrack 
            sol[x][y] = 0;


        }

        return false;
    } 
}