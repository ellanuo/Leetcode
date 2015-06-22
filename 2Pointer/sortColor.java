/* Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem. */


// <l '0'   (0, l)
// >r '2'    (l, size-1]
//>=l && <cur '1'  [l, cur)
// >=cur && <=r unsort  [cur, r]

public class Solution {
    public void sortColors(int[] nums) {
        if(nums==null || nums.length<=1)
            return;
            
       int l=0;
       int r=nums.length-1;
      // int cur=0;
       
       for(int cur=0; cur<=r;)
       {
           if(nums[cur]==0)
            {
                swap(nums, l, cur);
                cur++;
                l++;
            }
            else if(nums[cur]==2)
            {
                swap(nums, r, cur);
                r--;
            }
            else
                cur++;
       }
       
    }
    private void swap(int [] nums, int i, int j)
    {
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
        
    }
}
