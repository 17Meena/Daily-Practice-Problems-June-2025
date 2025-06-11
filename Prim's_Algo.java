import java.util.*;

class Pair{
    int node;
    int dist;

    public Pair(int distance, int node){
        this.dist = distance;
        this.node = node;
    }
}

public class Solution {
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.dist-b.dist);
        int[] vis = new int[V];

        pq.add(new Pair(0,0));
        int sum = 0;

        while(!pq.isEmpty()){
            int wt = pq.peek().dist;
            int node = pq.peek().node;
            pq.remove();

            if(vis[node] == 1) continue;

            vis[node] = 1;
            sum += wt;

            for(int i=0; i<adj.get(node).size(); i--){
                int edWt = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);

                if(vis[adjNode] == 0){
                    pq.add(new Pair(edWt,adjNode));
                }

            }
        }

        return sum;
    }
}
