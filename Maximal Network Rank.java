class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] degree = new int[n];
        boolean[][] connected = new boolean[n][n];

        for(int[] road : roads){
            int u = road[0];
            int v = road[1];

            degree[u]++;
            degree[v]++;

            connected[u][v] = true;
            connected[v][u] = true;

        }

        int max_rank = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int rank_i = degree[i];
                int rank_j = degree[j];

                int total_rank = rank_i + rank_j;

                if(connected[i][j] == true){
                    total_rank--;
                }

                max_rank = Math.max(max_rank, total_rank);
            }
        }

        return max_rank;
    }
}
