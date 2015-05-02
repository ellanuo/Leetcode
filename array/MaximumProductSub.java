/* Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/

//Pay attention to product==0, so the product needs to be compared with num[i]

public class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null || nums.length==0 )
            return 0;
            
        int maxEndHere=nums[0];
        int minEndHere=nums[0];
        int maxValue=nums[0];
        
        for(int i=1;i<nums.length;i++)
        {
            int tmp=maxEndHere;
            maxEndHere=Math.max(Math.max(maxEndHere* nums[i], minEndHere*nums[i]),nums[i]);
            minEndHere=Math.min(Math.min(tmp*nums[i], minEndHere*nums[i]),nums[i]);
            maxValue=Math.max(maxValue,maxEndHere);
        }
        
        return maxValue;
        
    }
}
