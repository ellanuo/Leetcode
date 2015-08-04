Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> lists = new ArrayList<String>();
        if(nums==null || nums.length==0)
            return lists;
        int start=0;    
        for(int i=0;i<nums.length;i++)
        {
            if(i==0 || nums[i]!=nums[i-1]+1)
                 start =i;
            
            if(i==nums.length-1|| nums[i]+1!=nums[i+1])
            {
                if(start==i)
                    lists.add(Integer.toString(nums[i]));
                else
                    lists.add(nums[start]+"->"+ nums[i]);
            }
                 
        }
        return lists;
    }
}
