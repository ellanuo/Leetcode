/*
Given an array of integers and an integer k, find out whether there there are two distinct indices i and j 
in the array such that nums[i] = nums[j] and the difference between i and j is at most k. */

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums==null || nums.length==0)
            return false;
        HashMap <Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++)
        {
            if(!map.containsKey(nums[i]))
                map.put(nums[i],i);
            else
            {
                int index=map.get(nums[i]);
                if((i-index)<=k)
                    return true;
                else
                {
                    map.put(nums[i],i);
                }
            }
        }
        return false;
    }
}
