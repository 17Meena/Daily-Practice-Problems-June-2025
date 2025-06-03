import java.util.*;
//Dijkstra's algo using Priority Queue
class Pair{
    int distance;
    int node;
    public Pair(int d, int n){
        this.distance = d;
        this.node = n;
    }
}

class Solution{
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj,
    int S){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->(a.distance-b.distance));
        int[] dist = new int[V];

        for(int i=0; i<V; i++){
            dist[i] = (int)(1e9);
        }

        pq.add(new Pair(0,S));

        while(!pq.isEmpty()){
            int dis = pq.peek().distance;
            int node = pq.peek().node;

            for(Pair p : adj.get(node)){
                int edgeWeight = p.distance;
                int edgeNode = p.node;

                if(dist[node] + edgeWeight < dist[edgeNode]){
                    dist[edgeNode] = dist[node] + edgeWeight;
                    pq.add(new Pair(dist[edgeNode],edegNode));
                }
            }
        }

        return dist;
    }
}
