class Solution {
    public void dfs(int ind, int[][] stones, int[] vis){
        vis[ind] = 1;

        int r = stones[ind][0];
        int c = stones[ind][1];

        for(int i=0; i<stones.length; i++){
            if((vis[i] == 0) && (stones[i][0] == r || stones[i][1] == c)){
                dfs(i, stones, vis);
            }
        }
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;

        int[] vis = new int[n];
        int group = 0;

        for(int i=0; i<n; i++){
            if(vis[i] == 0){
                dfs(i,stones,vis);
                group++;
            }
        }

        return n-group;
    }
}