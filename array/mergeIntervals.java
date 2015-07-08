/* Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18]. */


/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        if(intervals==null || intervals.size()==0)
            return result;
            
        for(int i=0; i<intervals.size();i++)
            insert(result, intervals.get(i));
        
        return result;
    }
    
    private void insert(List<Interval> intervals, Interval newInterval)
    {
         if(intervals.size()==0 || newInterval==null)
        {
            intervals.add(newInterval);
            return ;
        }
            
        for(int i=0; i<intervals.size();)
        {
            Interval first = intervals.get(i);
            if(newInterval.end<first.start)
            {
                intervals.add(i,newInterval);
                return ;
            }
            else if(newInterval.start>first.end)
            {
                i++;
            }
            else
            {
                int start=Math.min(first.start, newInterval.start);
                int end=Math.max(first.end, newInterval.end);
                newInterval=new Interval(start,end);
                intervals.remove(i);
            }
        }
        intervals.add(newInterval);
        
        return;
    }
}
