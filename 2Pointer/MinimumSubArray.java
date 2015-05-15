/ * Given an array of n positive integers and a positive integer s, 
find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint. */

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
       
       int left=0;
       int right=0;
       int sum=0;
       int len=Integer.MAX_VALUE;
       for(;right<nums.length;right++)
       {
           sum+=nums[right];
           while(sum>=s && left<=right)
           {
               len=Math.min(len, right-left+1);
               sum-=nums[left++];
           }
       }
       
       return len==Integer.MAX_VALUE? 0:len;
       
        
    }
}
