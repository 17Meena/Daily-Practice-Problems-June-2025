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
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        
        int[][] dist = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dist[i][j] = (int)(1e9);
            }
        }
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b) -> (a.first-b.first));
        dist[0][0] = 0;
        pq.add(new Tuple(0,0,0));

        int[] dRow = {-1,0,1,0};
        int[] dCol = {0,1,0,-1};
        while(!pq.isEmpty()){
            int diff = pq.peek().first;
            int r = pq.peek().second;
            int c = pq.peek().third;
            pq.poll();

            if(r == n-1 && c == m-1) return diff;

            for(int i=0; i<4; i++){
                int nrow = r + dRow[i];
                int ncol = c + dCol[i];

                if(nrow >=0 && nrow < n && ncol >=0 && ncol < m){
                    int newEffort = Math.max(Math.abs(heights[r][c] - heights[nrow][ncol]),diff);
                    if(newEffort < dist[nrow][ncol]){
                        dist[nrow][ncol] = newEffort;
                        pq.add(new Tuple(newEffort,nrow,ncol));
                    }
                }
            }
        }
        return 0;

    }
}
