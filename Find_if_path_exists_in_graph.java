class Solution {
    public void dfs(ArrayList<ArrayList<Integer>> adj, int[] vis, int node){
        vis[node] = 1;

        for(int it : adj.get(node)){
            if(vis[it] == 0){
                dfs(adj, vis, it);
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] vis = new int[n];
        dfs(adj,vis,source);

        if(vis[destination] == 0){
            return false;
        }

        return true;
    }
}
