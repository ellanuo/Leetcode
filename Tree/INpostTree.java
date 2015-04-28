/*Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree. */





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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || postorder==null || inorder.length==0 || postorder.length==0)
            return null;
        
        int len=postorder.length-1;    
        TreeNode root=new TreeNode(postorder[len]);
        int index=getIndex(inorder, postorder[len]);
        
        if(index>=0 && index<inorder.length)
        {   
            root.left=getNode(inorder, 0, index-1, postorder, index-1);
            root.right=getNode(inorder, index+1, inorder.length-1, postorder, len-1);
        }
        return root;
        
    }
    
    private int getIndex(int[] inorder, int val)
    {
        for (int i=0; i<inorder.length; i++)
        {
            if(inorder[i]==val)
                return i;
        }
        return inorder.length;
    }
    
    private TreeNode getNode(int [] inorder, int start, int end, int [] postorder, int pos)
    {
        if(start>end || pos<0)
            return null;
            
        TreeNode root = new TreeNode(postorder[pos]);
        int index=getIndex(inorder, postorder[pos]);
        root.left=getNode(inorder, start, index-1, postorder, pos-(end-index)-1);
        root.right=getNode(inorder, index+1, end, postorder, pos-1);
        
        return root;
            
    }
}
