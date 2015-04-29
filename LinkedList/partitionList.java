/* Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5. */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode (Integer.MIN_VALUE);
        dummy.next=head;
        ListNode cur=dummy;
        ListNode pivot=dummy;
        
        while(cur.next!=null && pivot.next!=null)
        {
            if(cur.next.val<x && cur!=pivot)
            {
                ListNode p= cur.next;
                cur.next=p.next;
                p.next=pivot.next;
                pivot.next=p;
                pivot=pivot.next;
            }
            else if(cur.next.val>=x)
            {
                //pivot=pivot.next;
                 cur=cur.next;
            }
            else if(cur.next.val<x && cur==pivot)
            {
                cur=cur.next;
                pivot=pivot.next;
                
            }
        }
        
        return dummy.next;
    }
}
