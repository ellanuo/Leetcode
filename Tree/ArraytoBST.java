/*Given an array where elements are sorted in ascending order, convert it to a height balanced BST.*/


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
    public TreeNode sortedArrayToBST(int[] num) {   
        if(num==null || num.length==0)
            return null;
            
        TreeNode root = getTree(num, 0, num.length-1);
        
        return root;
    
    }
    
    private TreeNode getTree(int [] num, int start, int end)
    {
        if(start>end)
            return null;
            
        int mid=(start+end+1)/2;
        //if(mid<0 || mid>=num.length)
          //  return null;
        TreeNode node = new TreeNode(num[mid]);
        node.left=getTree(num, start, mid-1);
        node.right=getTree(num, mid+1, end);
        
        return node;
    }
}
