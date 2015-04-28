/*Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/




public class Solution {
    public int threeSumClosest(int[] num, int target) {
        //int result=Integer.MAX_VALUE;
        //if(num==null || num.length==0)
          //  return result;
          
        int result=num[0]+num[1]+num[num.length-1];
            
        Arrays.sort(num);
        for(int i=0; i<num.length; i++)
        {
            if(i==0 || (i>0) && num[i-1]!=num[i])
            {
                int low=i+1;
                int high=num.length-1;
                
                while(low<high)
                {
                    if(num[i]+num[low]+num[high]==target)
                        return target;
                    
                    if(Math.abs(result-target)>Math.abs(num[i]+num[low]+num[high]-target))
                        result=num[i]+num[low]+num[high];
                    
                     if(num[i]+num[low]+num[high]<target) 
                    {
                        while(low<high && num[low]==num[low+1]) 
                            low++;
                        low++;
                    }
                    else 
                    {
                        while(low<high && num[high]==num[high-1]) 
                            high--;
                        high--;
                    }
                }
            }
        }
        
        return result;
        
    }
}
