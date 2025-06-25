class Solution {
    public void dfs(int node, int[] vis, List<List<Integer>> adj){
        vis[node] = 1;

        for(int it : adj.get(node)){
            if(vis[it] == 0){
                dfs(it,vis,adj);
            }
        }
    }

    public boolean isSimilar(String s1, String s2){
        int diff = 0;

        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                diff++;
            }
        }

        return diff == 2 || diff == 0;
    }

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(isSimilar(strs[i], strs[j])){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int[] vis = new int[n];
        int cntOfGroup = 0;
        
        for(int i=0; i<n; i++){
            if(vis[i] == 0){
                cntOfGroup++;
                dfs(i,vis,adj);
            }
        }

        return cntOfGroup;
    }
}
