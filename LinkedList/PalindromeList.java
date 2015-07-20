Palindrome Linked List Total Accepted: 6657 Total Submissions: 29199 My Submissions Question Solution 
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)
            return true;
        
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode result=null;
        ListNode cur=slow;
        while(cur!=null)
        {
            ListNode tmp=cur.next;
            cur.next=result;
            result=cur;
            cur=tmp;
        }
        
        ListNode p=head;
        ListNode q=result;
        
        while(p!=null && q!=null)
        {
            if(p.val!=q.val)
                return false;
            p=p.next;
            q=q.next;
        }
        
        return true;
    }
}
