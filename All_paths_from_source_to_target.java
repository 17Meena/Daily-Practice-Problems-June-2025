class Solution {
    //Time complexity is :  O(2^n).
    // Let's take an example as  the worst case scenario:
    // Suppose we have n nodes, labeled 0 to n-1.
    // Think of it as an array: [0, 1, 2, 3, 4, 5, 6, ..., n-1]

    // Now, we want to calculate how many paths there are from the 0th node to the (n-1)th node.
    // Well, notice that each path of length k corresponds to some choice of (k - 1) nodes between 0 and (n-1).
    // For example, here are two paths of length 2:
    // 0->3->(n-1)
    // 0->5->(n-1)
    // Here is a path of length 3:
    // 0->1->5->(n-1)
    // How many paths of length k are there? The answer is (n-2 choose k-1) because we pick (k - 1) nodes between 0 and (n - 1).

    // The total number of paths is the sum of (n-2 choose k-1) for k = 1, 2, ..., (n-1).
    // Using the binomial theorem, this sum is equal to 2^(n-2) which is O(2^n).

    // Credit goes to @pmcspmcspmcs
    public void dfs(int[][] graph, int u, int target, List<List<Integer>> result, List<Integer> temp){
        temp.add(u);

        if(u == target){
            result.add(new ArrayList<>(temp));
        }
        else{
            for(int g : graph[u]){
                dfs(graph,g,target,result,temp);
            }
        }

        temp.remove(temp.size()-1);
    }
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        dfs(graph,0,n-1,result,temp);

        return result;
    }
}