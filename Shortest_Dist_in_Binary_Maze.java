class Tuple{
   int first;
   int second;
   int third;
   
   public Tuple(int f, int s, int t){
       this.first = f;
       this.second = s;
       this.third = t;
   }
}
//Plain BFS
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] == 1) return -1;
        if(n == 1) return 1;

        int[][] vis = new int[n][n];
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(1,0,0));
        vis[0][0] = 1;

        while(!q.isEmpty()){
            int dis = q.peek().first;
            int r = q.peek().second;
            int c = q.peek().third;
            q.poll();

            for(int delRow = -1; delRow <= 1; delRow++){
                for(int delCol = -1; delCol <= 1; delCol++){
                    if(delRow == 0 && delCol == 0) continue;

                    int nrow = r + delRow;
                    int ncol = c + delCol;

                    if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && grid[nrow][ncol] == 0 && vis[nrow][ncol] == 0){
                        vis[nrow][ncol] = 1;

                        if(nrow == n-1 && ncol == n-1) return dis + 1; //found the destination node
                        q.add(new Tuple(dis+1,nrow,ncol));
                    }
                }
            }
        }

        return -1;
    }
}