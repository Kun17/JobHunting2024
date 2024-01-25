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
    private void dfs(Node oNode, Map<Integer, Node> newNodes) {
        Node nNode = newNodes.get(oNode.val);
        for (Node oNei : oNode.neighbors) {
            if (newNodes.containsKey(oNei.val)) {
                nNode.neighbors.add(newNodes.get(oNei.val));
                continue;
            }
            Node nNei = new Node(oNei.val);
            newNodes.put(nNei.val, nNei);
            nNode.neighbors.add(nNei);
            dfs(oNei, newNodes);
        }
    }
    
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node ans = new Node(1);
        Map<Integer, Node> newNodes = new HashMap<>();
        newNodes.put(1, ans);
        dfs(node, newNodes);
        return newNodes.get(1);
    }
}
