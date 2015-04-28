/* Reverse a linked list from position m to n. Do it in-place and in one-pass.
For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,
return 1->4->3->2->5->NULL.
Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list. */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null || head.next==null || m==n)
            return head;
        
        ListNode dummy = new ListNode (Integer.MIN_VALUE);
        dummy.next = head;
        int i=1;
        ListNode prev=dummy;
        ListNode cur=head;
        while(i<m && cur!=null)
        {
            prev=cur;
            cur=cur.next;
            i++;
        }  //prev points to the pervious node to mth node
        
        if(cur==null)
            return head;
            
        ListNode result =null;
        //ListNode cur=prev.next;
        //i++;
        while(i<=n && cur!=null)
        {
            ListNode tmp = cur.next;
            cur.next=result;
            result=cur;
            cur=tmp;
            i++;
            
        }
         
        if(prev!=null && prev.next!=null)
            {
                prev.next.next=cur;   
                prev.next=result;
            }
        
        
        return dummy.next;
        
    }
}
