import java.util.ArrayList;

class Pair{
    int first; //distance
    int second; //node

    public Pair(int d, int n){
        this.first = d;
        this.second = n;
    }
}

class Solution{
    public static List<Integer> shortestPath(int n, int m, int[][] edges){
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){ 
            adj.get(edges[i][0]).add(new Pair(edges[i][1]), edges[i][2]);
            adj.get(edges[i][1]).add(new Pair(edges[i][0]), edges[i][2]);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.first-b.first);
        int[] dist = new int[n];
        int[] parent = new int[n];
        for(int i=1; i<=n; i++){
            dist[i] = (int)(1e9);
            parent[i] = i;
        }

        pq.add(new Pair(0,1));
        dist[1] = 1;

        while(!pq.isEmpty()){
            int distance = pq.peek().first;
            int node = pq.peek().second;
            pq.remove();

            for(Pair it : adj.get(node)){
                int wt = it.first;
                int adjNode = it.second;
                if(dist[adjNode] < distance + wt){
                    dist[adjNode] = distance + wt;
                    pq.add(new Pair(distance + wt,adjNode));
                    parent[adjNode] = node;
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        if(dist[n] == -1){
            path.add(-1);
            return path;
        }

        int node = n;
        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(1);

        Collections.reverse(path);

        return path;

    }
}
