Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

public class Solution {
    public int majorityElement(int[] nums) {
        //if(nums==null || nums.length==0)
          //  return 
        
       int candidate=0;
       int count=0;
       
       for(int i=0;i<nums.length;i++)
       {
           if(candidate==nums[i])
           {
               count++;
           }
           else if(count==0)
           {
               candidate=nums[i];
               count++;
           }
           else
           {
               count--;
           }
       }
       
       count=0;
       for(int i=0;i<nums.length;i++ )
       {
           if(nums[i]==candidate)
            count++;
       }
       
       return (count>nums.length/2)? candidate:-1;
    }
}
