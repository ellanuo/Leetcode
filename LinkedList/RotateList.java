/* Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL. */

// Pay attention to the special cases, the linkedList does not need to be changed


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0)
            return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next=head;
        
        ListNode p=dummy;
        int len=0;
        
        while(p.next!=null)
        {
            len++;
            p=p.next;
        }
        if(k%len==0)
            return head;
        int step = len-k%len;
        ListNode prev=dummy;
        ListNode cur=dummy.next;
        for(int i=0; i<step; i++)
        {
            prev=cur;
            cur=cur.next;
        }
        p.next=dummy.next;
        dummy.next=cur;
        prev.next=null;
        
        
        
        return dummy.next;
    }
}
