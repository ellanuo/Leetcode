/* Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6. */

public class Solution {
    public int trap(int[] height) {
        if(height==null || height.length==0)
            return 0;
        int len=height.length;
        if(len<2)
            return 0;
        
        int [] maxL=new int[len];
        int [] maxR = new int[len];
        int max=height[0];
        maxL[0]=0;
        for(int i=1; i<len; i++)
        {
            maxL[i]=max;
            if(height[i]>max)
                max=height[i];
        }
        max=height[len-1];
        maxR[len-1]=0;
        int sum=0;
        int water=0;
        for(int i=len-2; i>=0; i--)
        {
            maxR[i]=max;
            water=Math.min(maxR[i],maxL[i])-height[i];
            if(water >0)
                sum+=water;
            
            if(height[i]>max)
                max=height[i];
        }
        
        return sum;
        
        
        
    }
}
