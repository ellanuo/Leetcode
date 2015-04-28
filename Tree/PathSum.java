/* Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22. */


//Pay attention to the definition of leaf ndoe




/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
       if(root==null)
            return false;
        
        return subHelper(root, sum);
        
    }
    
    private boolean subHelper(TreeNode root, int sum)
    {
        if(root.left==null && root.right==null )
           return root.val==sum;
        
        boolean left=false;
        boolean right=false;
        
        if(root.left!=null) 
            left=subHelper(root.left, sum-root.val);
        if(root.right!=null)
            right=subHelper(root.right, sum-root.val);
            
        return left||right;
        
    }
}
