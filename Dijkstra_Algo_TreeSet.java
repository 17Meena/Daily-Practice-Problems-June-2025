import java.util.*;
//Dijkstara's algo using Treeset(set method) -- not faster then pq method because the time saved in reducing some iterations is overtaken by 
//the time taken to remove from set(of logn order)
class Pair{
    int dist;
    int node;
    public Pair(int d, int n){
        this.dist = d;
        this.node = n;
    }
}

class Solution{
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S){
        TreeSet<Pair> set = new TreeSet<>((a,b) -> (a.dist ==  b.dist) ? (a.node - b.node) : (a.dist-b.dist));
        int[] dist = new int[V];
        Arrays.fill(dist,(int)1e9);
        dist[S] = 0;

        set.add(new Pair(0,S));

        while(!set.isEmpty()){
            Pair curr = set.pollFirst();

            for(Pair p : adj.get(curr.node)){
                int wt = p.dist;
                int n = p.node;
                int newDist = curr.dist + wt;
                if(newDist < dist[n]){
                    set.add(new Pair(newDist,n));
                }
                if(dist[n] < 1e9){
                    set.remove(new Pair(dist[n],n));
                }

                dist[n] = newDist;
            }
        }


        return dist;


    }
}
