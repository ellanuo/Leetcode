/* Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array. */

public class Solution {
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return -1;
        int lo=0;
        int hi=nums.length-1;
        
        while(lo<hi)
        {
            int mid=(lo+hi)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[lo]<nums[mid])
            {
                if(target<nums[mid] && target>nums[lo])
                    hi=mid-1;
                else
                    lo=mid+1;
            }
            else if(nums[mid]<nums[hi])
            {
                if(target>nums[mid] && target<nums[hi])
                    lo=mid+1;
                else
                    hi=mid-1;
            }
        }
        
        return nums[lo]==target? lo:-1;
        
    }
}

//Time exceed
//Why? Because even there is no duplicate element in the array, when the number of elements is <=2, lo,mid, hi might be same. 
//So we need to consider when nums[lo]==nums[mid]
//The following binary search, maintain at least 3 elements in the while loop, which will solve the problem

public class Solution {
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return -1;
        int lo=0;
        int hi=nums.length-1;
        
        while(lo+1<hi)
        {
            int mid=(lo+hi)/2;
            //if(nums[mid]==target)
              //  return mid;
            if(nums[lo]<nums[mid])
            {
                if(target<nums[mid] && target>=nums[lo])
                    hi=mid;
                else
                    lo=mid;
            }
            else if(nums[mid]<nums[hi])
            {
                if(target>nums[mid] && target<=nums[hi])
                    lo=mid;
                else
                    hi=mid;
            }
        }
        
        if(nums[lo]==target) return lo;
        else if(nums[hi]==target) return hi;
        else return -1;
        
    }
}
