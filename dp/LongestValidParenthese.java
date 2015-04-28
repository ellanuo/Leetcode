/*Longest Valid Parentheses Total Accepted: 29426 Total Submissions: 143301 My Submissions Question Solution 
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/

public class Solution {
    public int longestValidParentheses(String s) {
        if(s==null || s.length()==0)
            return 0;
       int len=s.length();     
       int [] dp = new int [len];
       int max=0;
       for(int i=len-1; i>=0; i--)
       {
           if(i==len-1 || s.charAt(i)==')')
            {
                dp[i]=0;
                max=Math.max(max,dp[i]);
                continue;
            }
            
            else
            {
                int k=i+dp[i+1]+1;
                if(k<len && s.charAt(k)==')')
                {
                        dp[i]=dp[i+1]+2;
                        if(k+1<len && dp[k+1]>0)
                            dp[i]+=dp[k+1];
                            
                        max=Math.max(max,dp[i]);
                }
                else
                    dp[i]=0;
                
            }
           
       }
       
       return max;
    }
}
