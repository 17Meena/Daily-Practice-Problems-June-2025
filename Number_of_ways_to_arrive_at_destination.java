 class Pair {
    int next;
    long distance;

    Pair(int next, long distance) {
        this.next = next;
        this.distance = distance;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        
        // Create an adjacency list to represent the graph
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        // Initialize the adjacency list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Populate the adjacency list with road information
        for (int[] road: roads) {
            adj.get(road[0]).add(new Pair(road[1], road[2]));
            adj.get(road[1]).add(new Pair(road[0], road[2]));
        }

        // Create a priority queue for Dijkstra's algorithm
        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair1, Pair2) -> Long.compare(Pair1.distance, Pair2.distance));

        // Initialize arrays for distances and ways
        long dist[] = new long[n];
        long ways[] = new long[n];
        long mod = (int)(1e9 + 7);

        // Initialize distance and ways arrays
        for (int i = 0; i < n; i++) {
            dist[i] = Long.MAX_VALUE;
            ways[i] = 0;
        }

        // Starting node has distance 0 and one way to reach it
        dist[0] = 0;
        ways[0] = 1;

        pq.add(new Pair(0, 0));

        while (pq.size() != 0) {
            int node = pq.peek().next;
            long dis = pq.peek().distance;
            pq.remove();

            // Explore neighboring nodes
            for (Pair it : adj.get(node)) {
                int adjNode = it.next;
                long edW = it.distance;

                // If a shorter path is found, update distance and ways
                if (dis + edW < dist[adjNode]) {
                    dist[adjNode] = dis + edW;
                    pq.add(new Pair(adjNode, dis + edW));
                    ways[adjNode] = ways[node];
                } else if (dis + edW == dist[adjNode]) {
                    // If multiple paths with the same length are found, add their ways
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }

        // Return the number of ways to reach the last node modulo mod
        return (int)(ways[n - 1] % mod);
    }
}
