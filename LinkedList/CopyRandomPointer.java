Copy List with Random Pointer

/* A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list. */

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null)
            return null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode newHead = new RandomListNode(head.label);
        map.put(head,newHead);
        
        RandomListNode p=head.next;
        RandomListNode q=newHead;
        while(p!=null)
        {
            q.next= new RandomListNode(p.label);
            map.put(p, q.next);
            p=p.next;
            q=q.next;
        }
        
        p=head;
      //  q=newHead;
        
        while(p!=null)
        {
            if(p.random!=null)
                map.get(p).random=map.get(p.random);
            
            else
                 map.get(p).random=null;
            p=p.next;
        }
        return newHead;
    }
}

http://www.programcreek.com/2012/12/leetcode-copy-list-with-random-pointer/
http://www.geeksforgeeks.org/a-linked-list-with-next-and-arbit-pointer/
http://fisherlei.blogspot.com/2013/11/leetcode-copy-list-with-random-pointer.html
