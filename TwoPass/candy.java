There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

public class Solution {
    public int candy(int[] ratings) {
        int len=ratings.length;
        int [] count = new int[len];
        
        for(int i=0; i<len;i++)
        {
            if(i>0 && ratings[i]>ratings[i-1])
                count[i]=count[i-1]+1;
            else
                count[i]=1;
        }
        
        for(int i=len-2; i>=0;i--)
        {
            if(i>0 && ratings[i-1]<ratings[i] && ratings[i]>ratings[i+1])
                count[i]=Math.max(count[i],count[i+1]+1);
            
            else if(ratings[i]>ratings[i+1])
                count[i]=count[i+1]+1;
            
        }
        
        int sum=0;
        for(int i=0;i<len;i++)
            sum+=count[i];
            
        return sum;
        
    }
}
