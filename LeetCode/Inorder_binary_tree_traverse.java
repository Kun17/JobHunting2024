/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> ans = new LinkedList<Integer>();
//         if (root == null) return ans;
//         ans.addAll(inorderTraversal(root.left));
//         ans.add(root.val);
//         ans.addAll(inorderTraversal(root.right));
//         return ans;
//     }
// }

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<Integer>();
        if (root == null) return ans;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.empty()) {
            TreeNode cur = stack.pop();
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if(!stack.empty()) cur = stack.pop();
            if(cur != null) {
                ans.add(cur.val);
                stack.push(cur.right);
            }
        }
        return ans;
    }
}
