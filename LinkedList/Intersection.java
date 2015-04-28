/* Write a program to find the node at which the intersection of two singly linked lists begins.
For example, the following two linked lists:
A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.
Notes:
If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory. */



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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null)
            return null;
        int a=1;
        int b=1;
        
        ListNode p=headA;
        while(p.next!=null)
        {
            p=p.next;
            a++;
        }
        ListNode q=headB;
        while(q.next!=null)
        {
            q=q.next;
            b++;
        }
        if(p!=q)
            return null;
        //if(a==b)
            //return headA;
        p=(a>=b)? headA:headB;
        q=(a<b)? headA:headB;
        for(int i=0; i<Math.abs(a-b); i++)
        {
            p=p.next;
        }
        
        while(p!=q)
        {
            p=p.next;
            q=q.next;
        }
        return p;
        
    }
}


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null)
            return null;
       
       ListNode curA=headA;
       ListNode curB=headB;
       
       while(curA!=curB)
       {
           curA=(curA==null)?headB:curA.next;
           curB=(curB==null)?headA:curB.next;
       }
        return curA;
    }
}
