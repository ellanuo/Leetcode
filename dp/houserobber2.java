Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Credits:
Special thanks to @Freezen for adding this problem and creating all test cases.


public class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
            
        
        int len=nums.length;
        
        if(len==1)
            return nums[0];
        
        int dp[] = new int [len];  //count nums[0]-nums[len-2];
        int dp1[] = new int[len];  //count nums[1]-nums[len-1];
        
        dp[0]=0;
        dp[1]=nums[0];
        
        dp1[0]=0;
        dp1[1]=nums[1];
        
        for(int i=1; i<len-1; i++)
        {
            dp[i+1]=Math.max(dp[i], dp[i-1]+nums[i]);
            dp1[i+1]=Math.max(dp1[i], dp1[i-1]+nums[i+1]);
        }
        
        return Math.max(dp[len-1], dp1[len-1]);
    }
}
