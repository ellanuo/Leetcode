/* Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]

Related problem: Reverse Words in a String II

Credits:
Special thanks to @Freezen for adding this problem and creating all test cases. */





public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums==null || nums.length==0 )
            return;
        
        int len=nums.length;
        k=k%len;
        if(k==0)
            return;
        reverse(nums, 0, len-1);
        reverse(nums, 0, k-1);
        reverse(nums,k, len-1);
        
    }
    
   // Method 3:( Normal way, O(n) time cost, O(k % nums.length) space cost)
    private void reverse(int [] nums, int start, int end)
    {
        while(start<end)
        {
            int tmp=nums[start];
            nums[start++]=nums[end];
            nums[end--]=tmp;
        }
    }
}


public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums==null || nums.length<=1 )
            return;
        
        k=k%nums.length;
        int len=nums.length;
        
       int [] tmp = new int[k];
       for(int i=0; i<k; i++)
       {
            tmp[i]=nums[len-k+i];
       }
       
        for(int i=len-1; i>=k; i--)
        {
            nums[i]=nums[i-k];
        }
        
        for(int i=0; i<k; i++)
        {
            nums[i]=tmp[i];
        }
            
        
       
    }
}
