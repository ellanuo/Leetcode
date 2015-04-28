 /* Given a linked list, swap every two adjacent nodes and return its head.
For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.
Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed. */




/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next=head;
        
        ListNode p = dummy;
        while(p.next!=null && p.next.next!=null)
        {
            int tmp=p.next.val;
            p.next.val=p.next.next.val;
            p.next.next.val=tmp;
            
            
            p=p.next.next;
        }
        
        return dummy.next;
        
    }
}
