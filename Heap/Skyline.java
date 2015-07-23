public class Solution {
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
    }
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result=new ArrayList<int[]>();
        if(buildings==null || buildings.length==0 || buildings[0].length==0)
            return result;
            
        List<Edge> edges = new ArrayList<Edge>();
        for(int i=0;i<buildings.length;i++)
        {
            Edge e1 = new Edge(buildings[i][0], buildings[i][2],true);
            Edge e2 = new Edge(buildings[i][1], buildings[i][2],false);
            edges.add(e1);
            edges.add(e2);
        }
        
        /* Sort edges, to dicide the processing order of each edge */
        Collections.sort(edges, new Comparator<Edge>(){
            //Override
            public int compare(Edge e1, Edge e2)
            {
                if(e1.x!=e2.x)
                    return Integer.compare(e1.x, e2.x);
                if(e1.isStart && e2.isStart)
                    return Integer.compare(e2.h, e1.h);
                if(!e1.isStart && !e2.isStart)
                    return Integer.compare(e1.h, e2.h);
                    
                return (e1.isStart)? -1:1;
            }
        }
        );
        
        /* The Collections.reverseOrder() provides a Comparator that would sort the elements in the PriorityQueue in a the oposite order to their natural order in this case. */
        PriorityQueue<Integer> heap = new PriorityQueue<Integer> (10, Collections.reverseOrder());
        for(Edge e:edges)
        {
            if(e.isStart)
            {
                if(heap.isEmpty() || heap.peek()<e.h)
                    result.add(new int[] {e.x,e.h});
                heap.add(e.h);
            }
            else
            {
                heap.remove(e.h);
                if(heap.isEmpty())
                    result.add(new int[]{e.x, 0});
                else if(e.h>heap.peek())
                    result.add(new int[]{e.x, heap.peek()});
            }
        }
        
        return result;
    }
}
