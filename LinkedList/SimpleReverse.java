/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode result=null;
        ListNode cur=head;
        
        while(cur!=null)
        {
            ListNode tmp= cur.next;
            cur.next=result;
            result=cur;
            cur=tmp;
        }
        return result;
        
    }
}


public class Solution {
    public ListNode reverseList(ListNode head) {
       if(head==null || head.next==null)
       {
           return head;
       }
       
       ListNode rest=head.next;
       head.next=null;
       
       ListNode secondHead=reverseList(rest);
       rest.next=head;
       
       return secondHead;
        
    }
}
