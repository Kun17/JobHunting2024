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
    private void dfs(Node oNode, Map<Integer, Node> newNodes, Set<Node> visited) {
        Node nNode = newNodes.get(oNode.val);
        for (Node oNei : oNode.neighbors) {
            if (newNodes.containsKey(oNei.val)) {
                nNode.neighbors.add(newNodes.get(oNei.val));
            } else {
                Node nNei = new Node(oNei.val);
                newNodes.put(nNei.val, nNei);
                nNode.neighbors.add(nNei);
            }
            if (visited.contains(oNei)) continue;
            visited.add(oNei);
            dfs(oNei, newNodes, visited);
        }
    }
    
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node ans = new Node(1);
        Map<Integer, Node> newNodes = new HashMap<>();
        newNodes.put(1, ans);
        Set<Node> visited = new HashSet<>();
        visited.add(node);
        dfs(node, newNodes, visited);
        return newNodes.get(1);
    }
}
