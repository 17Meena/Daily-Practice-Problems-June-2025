class Pair{
    int row;
    int col;
    int steps;

    public Pair(int r, int c, int s){
        this.row = r;
        this.col = c;
        this.steps = s;
    }
}

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;

        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(entrance[0],entrance[1],0));
        vis[entrance[0]][entrance[1]] = 1;

        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int steps = q.peek().steps;
            q.remove();

            // if((row == 0 || row == n-1 || col == 0 || col == m-1) && (row != entrance[0] && col != entrance[1])){
            //     return steps;
            // }

            int[] dRow = {-1,0,1,0};
            int[] dCol = {0,1,0,-1};

            for(int i=0; i<4; i++){
                int nrow = row + dRow[i];
                int ncol = col + dCol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && maze[nrow][ncol] == '.'){
                    if (nrow == 0 || ncol == 0 || nrow == n - 1 || ncol == m - 1) {
                        return steps + 1;
                    }                   
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow,ncol,steps+1));
                }
            }
        }

        return -1;

    }
}
