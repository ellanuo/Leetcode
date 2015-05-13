/* Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null ||k==1)
            return head;
        
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next=head;
        
        ListNode p=dummy.next;
        ListNode newHead=dummy;
        
        while(p!=null)
        {
            ListNode cur=p;
            ListNode result=null;
            int i=0;
            while(p!=null && i<k)
            {
                p=p.next;
                i++;
            }
            if(i<k)
                break;
                
            while(cur!=p)
            {
                ListNode tmp=cur.next;
                cur.next=result;
                result=cur;
                cur=tmp;
                
            }
            
            ListNode tmp=newHead.next;
            newHead.next=result;
            tmp.next=p;
            newHead=tmp;
        }
        return dummy.next;
    }
}


public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        ListNode tail = head;

        for (int i = 1; i < k; i ++) {
            tail = tail.next;

            if (tail == null) {
                return head;
            }
        }

        ListNode nextRoundHead = tail.next;

        ListNode second = head.next;
        ListNode first = head;

        //reserve the k node group
        for (int i = 1; i < k; i ++) {
            ListNode newSecond = second.next;
            second.next = first;

            first = second;
            second = newSecond;
        }

        head.next = reverseKGroup(nextRoundHead, k);

        return tail;
    }
}
