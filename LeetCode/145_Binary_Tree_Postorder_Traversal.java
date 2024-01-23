class Solution {
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     List<Integer> res = new LinkedList<Integer>();
    //     if (root == null) return res;
    //     res.addAll(postorderTraversal(root.left));
    //     res.addAll(postorderTraversal(root.right));
    //     res.add(root.val);  
    //     return res;
    // }
    
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode preNode = null;
        while (!stack.empty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode cur = stack.peek();
                if (cur.right == null || cur.right == preNode) {
                    res.add(cur.val);
                    preNode = cur;
                    stack.pop();
                } else {
                    root = cur.right;
                }
            }
        }
        return res;
    }
}
