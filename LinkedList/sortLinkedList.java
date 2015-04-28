//Sort a linked list in O(n log n) time using constant space complexity.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
            
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast.next!=null  && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode newHead=slow.next;
        slow.next=null;
        
        return merge(sortList(head), sortList(newHead));
        
    }
    
    private ListNode merge(ListNode h1, ListNode h2)
    {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next=null;
        ListNode p=dummy;
        while(h1!=null && h2!=null)
        {
            if(h1.val<=h2.val)
            {
                p.next=h1;
                h1=h1.next;
            }
            else
            {
                p.next=h2;
                h2=h2.next;
            }
            p=p.next;
        }
        if(h1==null)
        {
            p.next=h2;
        }
        else if(h2==null)
        {
            p.next=h1;
        }
        
        return dummy.next;
    }
}
