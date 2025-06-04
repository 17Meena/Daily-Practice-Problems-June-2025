class Pair{
    int first;
    int second;
    public Pair(int f, int s){
        this.first = f;
        this.second = s;
    }
}

class Tuple{
    int stops;
    int node;
    int cost;
    public Tuple(int s, int n, int c){
        this.stops = s;
        this.node = n;
        this.cost = c;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

         for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        

        for(int i=0; i<flights.length; i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }

        Queue<Tuple> q = new LinkedList<>();
        int[] dist = new int[n];
        for(int i=0; i<n; i++){
            dist[i] = (int)(1e9);
        }
        dist[src] = 0;
        q.add(new Tuple(0,src,0));

        while(!q.isEmpty()){
            int stops = q.peek().stops;
            int node = q.peek().node;
            int cost = q.peek().cost;
            q.poll();

            if(stops > k) continue;

            for(Pair it : adj.get(node)){
                int adjNode = it.first;
                int wt = it.second;

                if(cost + wt < dist[adjNode] && stops <= k){
                    dist[adjNode] = cost + wt;
                    q.add(new Tuple(stops+1, adjNode, cost+wt));
                }
            }
        }

        if(dist[dst] == (int)(1e9)) return -1;
        return dist[dst];
    }
}