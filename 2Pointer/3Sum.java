/*Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2) */


/*
Hi guys!

The idea is to sort an input array and then run through all indices of a possible first element of a triplet. 
For each possible first element we make a standard bi-directional 2Sum sweep of the remaining part of the array. 
Also we want to skip equal elements to avoid duplicates in the answer without making a set or smth like that.
*/

//bi-directional search

public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num==null || num.length==0)
            return result;
            
        Arrays.sort(num);
        for(int i=0; i<num.length;i++)
        {
            if(i==0 || (i>0)&&num[i-1]!=num[i])
            
            {
                int low= i+1; 
                int high=num.length-1;
                int sum=0-num[i];
                while(low<high)
                {
                    
                
                    if(num[low]+num[high]==sum)
                    {
                        result.add(Arrays.asList(num[i],num[low],num[high]));
                
                        while(low<high && num[low]==num[low+1]) low++;
                        while(low<high && num[high]==num[high-1]) high--;
                
                        low++;
                        high--;
                    }
                    else if(num[low]+num[high]<sum)
                    {
                        while(low<high && num[low]==num[low+1]) low++;
                        low++;
                    }
                    else
                    {
                        while(low<high && num[high]==num[high-1]) high--;
                        high--;
                    }
                    
                }
            }
        }
            
        return result;
        
    }
}
