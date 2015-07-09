/* Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory? */


public class Solution {
    public int singleNumber(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        
        int num=0;
        for(int i=0;i<nums.length;i++)
            num^=nums[i];
        
        return num;
    }
}

public class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0; i<nums.length;i++)
        {
            if(!map.containsKey(nums[i]))
                map.put(nums[i],1);
            else
            {
                map.remove(nums[i]);
            }
        }
        //if(!map.isEmpty())
            return map.keySet().iterator().next();
    }
}
