import java.util.*;
class Pair{
    int first;
    int second;

    public Pair(int f, int s){
        this.first = f;
        this.second = s;
    }
}

class Solution{
private void topoSort(int node, ArrayList<ArrayList<Pair>> adj, int[] vis, 
Stack<Integer> st){
    vis[node] = 1;

    for(Pair it : adj.get(node)){
        int v = it.first;
        if(vis[v] == 0){
            topoSort(v, adj, vis, st);
        }
    }
    st.push(node);
}

public int[] shortestPath(int N, int M, int[][] edges){
    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

    for(int i=0; i<N; i++){
        adj.add(new ArrayList<Pair>());
    }

    for(int i=0; i<M; i++){
        int u = edges[i][0];
        int v = edges[i][1];
        int wt = edges[i][2];
        adj.get(u).add(new Pair(v,wt));
    }

    int[] vis = new int[N];
    Stack<Integer> st = new Stack<>();

    for(int i=0; i<N; i++){
        if(vis[i] == 0){
            topoSort(i,adj,vis,st);
        }
    }

    int[] dist = new int[N];
    for(int i=0; i<N; i++){
        dist[i] = (int)1e9;
    }
    dist[0] = 0 //is src is 0

    while(!st.isEmpty()){
        int node = st.peek();
        st.pop();

        for(Pair it : adj.get(node)){
            int v = it.first;
            int wt = it.second;

            if(dist[node] + wt < dist[v]){
                dist[v] = dist[node] + wt;
            }
        }
    }

    return dist;

}
}