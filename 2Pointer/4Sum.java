/*Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
*/






public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num==null || num.length==0)
            return result;
            
        
        Arrays.sort(num);
        for(int i=0; i<num.length;i++)
        {
            if(i==0 || (i>0) && num[i-1]!=num[i])
            {
                for(int j=i+1; j<num.length;j++)
                {
                    if(j==i+1 || (j>i+1)&&num[j-1]!=num[j])
                    {
                        int sum=target-num[i]-num[j];
                        int high=num.length-1;
                        int low=j+1;
                        while(low<high)
                        {
                            if(num[low]+num[high]==sum)
                            {
                                result.add(Arrays.asList(num[i],num[j],num[low],num[high]));
                                while(low<high && num[low]==num[low+1]) low++;
                                while(low<high && num[high]==num[high-1])  high--;
                                
                                low++;
                                high--;
                            }
                            else if(num[low]+num[high]<sum)
                                low++;
                            else
                                high--;
                        }
                    }
                }
            }
        }
        
        return result;
        
    }
}
