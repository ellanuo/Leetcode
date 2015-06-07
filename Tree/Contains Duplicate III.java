/ * Given an array of integers, find out whether there are two distinct indices i and j in the array such that 
the difference between nums[i] and nums[j] 
is at most t and the difference between i and j is at most k. */


/* 参考LeetCode Discuss：https://leetcode.com/discuss/38177/java-o-n-lg-k-solution

TreeSet数据结构（Java）使用红黑树实现，是平衡二叉树的一种。

该数据结构支持如下操作：

1. floor()方法返set中≤给定元素的最大元素；如果不存在这样的元素，则返回 null。

2. ceiling()方法返回set中≥给定元素的最小元素；如果不存在这样的元素，则返回 null。 */

红黑树，balanced height, 最长路径是至多是最短路径的二倍

O(nlgk)
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums==null || nums.length==0 || k<1 ||t<0)
            return false;
            
        TreeSet<Integer> set = new TreeSet<Integer>();
        
        for(int i=0; i<nums.length; i++)
        {
            int n=nums[i];
            if(set.floor(n)!=null &&((long) n- set.floor(n))<=t        // consider integer overflow [-1, Integer.MIN_VALUE], t=Integer.MIN_VALUE
                || set.ceiling(n)!=null &&( set.ceiling(n)-(long)n)<=t)
                    return true;
            
            set.add(n);
            if(i>=k)
                set.remove(nums[i-k]);
        }
        return false;
       
    }
}
