
/* Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again). */




public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length<=1)
            return 0;
            
        int size=prices.length;
        int [] profit = new int[size];
        int [] profit1 = new int[size];
        
        int min=prices[0];
        int max=prices[size-1];
        profit[0]=0;
        profit1[size-1]=0;
        int result=0;
        for(int i=1, j=size-2; i<size && j>=0; i++,j--)
        {
            min=Math.min(min, prices[i-1]);
            profit[i]=Math.max(profit[i-1], prices[i]-min);
            
            max=Math.max(max,prices[j+1]);
            profit1[j]=Math.max(profit1[j+1], max-prices[j]);
        }
        
        
        for(int i=0; i<size;i++)
            result=Math.max(result, profit[i]+profit1[i]);
        
        return result;
    }
}
