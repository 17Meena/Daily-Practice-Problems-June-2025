/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public void dfs(Node original, Node cloned_node, Node[] cloned){
        for(Node n : original.neighbors){
            if(cloned[n.val] == null){
                Node newNode = new Node(n.val);
                cloned_node.neighbors.add(newNode);
                cloned[newNode.val] = newNode;
                dfs(n, newNode, cloned);
            }
            else{
                cloned_node.neighbors.add(cloned[n.val]);
            }
        }
    }
    public Node cloneGraph(Node node) {
       if(node == null) return null;

       Node cloned_node = new Node(node.val);

       Node[] cloned = new Node[101]; //to keep track of nodes already made
       Arrays.fill(cloned,null);
       cloned[node.val] = cloned_node;

       dfs(node, cloned_node, cloned); 

       return cloned_node;
    }
}
