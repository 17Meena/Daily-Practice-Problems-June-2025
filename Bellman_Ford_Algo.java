import java.util.*;

class Solution{
    //TC -- O(V x E)
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S){
        int[] dist = new int[V];
        for(int i=0; i<V; i++){
            dist[i] = (int)(1e8);
        }
        dist[S] = 0;

        for(int i=0; i<V-1; i++){
            for(ArrayList<Integer> it : edges){
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);

                if(dist[u] != 1e8 && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }

        //Nth relaxation to check negative cycle
        for(ArrayList<Integer> it : edges){
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);

            if(dist[u] != 1e8 && dist[u] + wt < dist[v]){
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }

        return dist;

    }
}
