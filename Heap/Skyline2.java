//LintCode

public class Solution {
    /**
     * @param buildings: A list of lists of integers
     * @return: Find the outline of those buildings
     */
     
     private class Edge
     {
         int x;
         int h;
         boolean isStart;
         Edge(int x, int h, boolean isStart)
         {
             this.x=x;
             this.h=h;
             this.isStart=isStart;
         }
       /*  void updateEdge(int x)
         {
             this.x=x;
         } */
     }
     
     
     
     
    public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
        // write your code here
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(buildings==null || buildings.length==0||buildings[0].length==0)
            return result;
            
        ArrayList<Edge> edges = new ArrayList<Edge>();
        for(int i=0; i<buildings.length;i++)
        {
            Edge e1 = new Edge(buildings[i][0], buildings[i][2],true);
            edges.add(e1);
            Edge e2 = new Edge(buildings[i][1],buildings[i][2],false);
            edges.add(e2);
        }
        
        Collections.sort(edges, new Comparator<Edge>(){
            public int compare(Edge a, Edge b)
            {
                if(a.x!=b.x)
                    return Integer.compare(a.x, b.x);
                if(a.isStart && b.isStart)
                    return Integer.compare(b.h, a.h);
                if(!a.isStart && !b.isStart)
                    return Integer.compare(a.h, b.h);
                return (a.isStart)? -1:1;
            }
        }
        );
        
       /* Comparator<Edge> compareHeight = new Comparator<Edge>(){
            public int compare(Edge a, Edge b)
            {
                return Integer.compare(b.h, a.h);
            }
        } */
        
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(10, Collections.reverseOrder());
        int boudary = 0;
        for(Edge e:edges)
        {
            
            int pre=(heap.isEmpty())? 0:heap.peek();
            if(e.isStart)
            {
                heap.add(e.h);
                if( pre!=0 && pre!=heap.peek()){
                    result.add(new ArrayList<Integer>
                    (Arrays.asList(boudary, e.x, pre)));
                    // boudary=e.x;
                }
                    
            }
            else
            {
                heap.remove(e.h);
               /* if(!heap.isEmpty() && heap.peek().h!=pre.h)
                    heap.peek().updateEdge(e.x); */
                
                
                if(heap.isEmpty() || pre!=heap.peek())
                {
                    result.add(new ArrayList<Integer>
                    (Arrays.asList(boudary, e.x, pre)));
                     //boudary=e.x;
                }
                    
            }
            
            if(heap.isEmpty() || pre!=heap.peek())
                boudary=e.x;
        }
        
        return result;
    }
}
