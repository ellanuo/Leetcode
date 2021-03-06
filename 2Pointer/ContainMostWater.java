/* Given n non-negative integers a1, a2, ..., an, 
where each represents a point at coordinate (i, ai). 
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, 
which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container. */

public class Solution {
    public int maxArea(int[] nums) {
        if(nums==null|| nums.length==0)
            return 0;
        int area=0;
        
        int left=0;
        int right=nums.length-1;
        while(left<right)
        {
            area=Math.max(area, (right-left)*Math.min(nums[left],nums[right]));
            if(nums[left]<nums[right]) 
                left++;
            else
                right--;
        }
        
        return area;
    }
}
