/* You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       /* if(l1==null)
            return l2;
        if(l2==null)
            return l1; */
        
        int carry=0;
        int a=0;
        int b=0;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next=null;
        ListNode p=dummy;
        int digit=0;
        while(carry!=0 || l1!=null  || l2!=null )
        {
            a=(l1==null)?0:l1.val;
            b=(l2==null)?0:l2.val;
            digit=a+b+carry;
            carry=(digit>=10)?1:0;
            p.next=new ListNode(digit%10);
            //cur.next=null;
            p=p.next;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
            
        }
        
        return dummy.next;
        
    }
}
