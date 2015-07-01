public class LRUCache {
    private int capacity;
    private int size;
    
   
    private void setHead(ListNode node)
    {
        if(head==null && tail==null)
        {
            head=node;
            tail=node;
        }
        else
        {
            node.next=head;
            head.prev=node;
            head=node;
        }
    }
    
    
    private int removeTail()
    {
      //  ListNode node = tail;
      int key=tail.key;
        if(head==tail)
        {
            tail=null;
            head=null;
        }
        else
        {
            //if(node.prev!=null)
            tail.prev.next=null;
            
            tail=tail.prev;
        }
        
        //node.prev=null;
        //node.next=null;
        return key;
    }
    
    public LRUCache(int capacity) {
        this.capacity=capacity;
        size=0;
    HashMap<Integer, ListNode> map = new HashMap<Integer, ListNode>();
    ListNode head=null;
    ListNode tail=null;
    
    }
    
    public int get(int key) {
       if(map.isEmpty() || !map.containsKey(key)) 
            return -1;
        
        ListNode node = map.get(key);
        
        //if(head==tail)
          //  return node.key;
        if(node.next==null)
        {
            tail=node.prev;
           if(tail!=null) tail.next=null;
        }
           
        else
         {
             node.next.prev=node.prev;
         }
         if(node.prev==null)
         {
             head=node.next;
            if(head!=null) head.prev=null;
             //node.next.prev=null;
         }
         else
            node.prev.next=node.next;
        
        node.prev=null;
        node.next=null;
        
        setHead(node);
        
        
        return node.value;
    }
    
    public void set(int key, int value) {
        
        if(!map.isEmpty() && map.containsKey(key))
        {
            ListNode node = map.get(key);
            node.value=value;
            get(key);
        }
        
        else
        {
            ListNode node =new ListNode (key, value);
            if(size==capacity) 
            {
                int tailKey=removeTail();
                map.remove(tailKey);
                size--;
            }
            
            size++;
            map.put(key,node);
            setHead(node);
        }
        
    }
    
    class ListNode
    {
        int key;
        int value;
        ListNode prev;
        ListNode next;
       public ListNode(int key, int value)
        {
            this.key=key;
            this.value=value;
            prev=null;
            next=null;
        }
    }
}
