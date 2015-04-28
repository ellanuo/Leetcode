/*
Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
*/




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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)
            return true;
            
        if((p==null && q!=null) ||(p!=null && q==null) || (p.val!=q.val))
            return false;
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        
    }
}


//Interation
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)
            return true;
        if((p==null && q!=null) || (p!=null && q==null) || (p.val!=q.val))
            return false;
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(p);
        stack2.push(q);
        
        while(!stack1.isEmpty() && !stack2.isEmpty())
        {
            TreeNode m = stack1.pop();
            TreeNode n = stack2.pop();
            if(m.val!=n.val)
                return false;
            if(m.right!=null) stack1.push(m.right);
            if(n.right!=null) stack2.push(n.right);
            
            if(stack1.size()!=stack2.size())
                return false;
              
            if(m.left!=null) stack1.push(m.left);
            if(n.left!=null) stack2.push(n.left);
            
            if(stack1.size()!=stack2.size())
                return false;
        }
        
        return stack1.size()==stack2.size();
        
        
    }
}
