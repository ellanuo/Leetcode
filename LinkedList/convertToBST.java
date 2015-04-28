/*Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
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
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;
        
        ListNode prev=null;   
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null)
        {
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        
        TreeNode root = new TreeNode (slow.val);
        if(prev==null)
            root.left=null;
        else
        {
            prev.next=null;
            root.left=sortedListToBST(head);
            root.right=sortedListToBST(slow.next);
        }
        return root;
        
    }
}
