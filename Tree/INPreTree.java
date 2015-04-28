/*Given preorder and inorder traversal of a tree, construct the binary tree.

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || inorder == null || preorder.length==0 || inorder.length==0)
            return null;
            
        TreeNode root=new TreeNode(preorder[0]);
        int index= getInorderIndex(inorder, preorder[0]);
        if(index>=0 && index<inorder.length)
        {
            root.left=getNode(inorder, 0, index-1, preorder, 1);
            root.right=getNode(inorder, index+1, inorder.length-1, preorder, index+1);
        }
        
        return root;
        
    }
    
    private TreeNode getNode(int[] inorder, int start, int end, int [] preorder, int pos)
    {
        if(start>end || pos>=preorder.length)
            return null;
            
        TreeNode node = new TreeNode(preorder[pos]);
        int index=getInorderIndex(inorder, preorder[pos]);
        node.left=getNode(inorder, start, index-1, preorder, pos+1);
        node.right=getNode(inorder, index+1, end, preorder, index-start+pos+1);
        
        return node;
    }
    
    
    private int getInorderIndex(int[] inorder, int val)
    {
        for(int i=0; i<inorder.length; i++)
        {
            if(inorder[i]==val)
                return i;
        }
        
        return inorder.length;
        
    }
}
