Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxPathSum(TreeNode root) {
        if(root==null)
            return 0;
        int [] max=new int [1];
        max[0]=Integer.MIN_VALUE;
        subHelper(root,max);
        return max[0];
    }
    
    private int subHelper(TreeNode root, int [] max)
    {
        if(root==null)
        {
            //if(max[0]<=0)
              //  max[0]=0;
            return 0;
        }
        
        int left= subHelper(root.left, max);
        int right=subHelper(root.right,max);
        
        left=(left<0)? 0: left;
        right=(right<0)? 0:right;
        
        if(left+right+root.val>max[0])
            max[0]=left+right+root.val;
        
        return Math.max(left, right)+root.val;
    }
}
