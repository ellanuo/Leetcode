Insert Interval Total Accepted: 35491 Total Submissions: 165273 My Submissions Question Solution 
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].


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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
       // List<Interval> result = new ArrayList<Interval>();
        if(intervals.size()==0 || newInterval==null)
        {
            intervals.add(newInterval);
            return intervals;
        }
            
        for(int i=0; i<intervals.size();)
        {
            Interval first = intervals.get(i);
            if(newInterval.end<first.start)
            {
                intervals.add(i,newInterval);
                return intervals;
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
        
        return intervals;
        
    }
}
