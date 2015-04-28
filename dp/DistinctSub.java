/*Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.*/



public class Solution {
    public int numDistinct(String S, String T) {
        if(S==null || T==null || S.length()==0 || T.length()==0)
            return 0;
            
        int m=S.length();
        int n=T.length();
        
        int [][] dp= new int[m][n];
        
        if(S.charAt(0)==T.charAt(0))
            dp[0][0]=1;
        else 
            dp[0][0]=0;
            
        for(int i=1; i<m;i++)
        {
            if(T.charAt(0)==S.charAt(i))
                dp[i][0]=dp[i-1][0]+1;
            else
                dp[i][0]=dp[i-1][0];
        }
        
        for(int i=1; i<n; i++)
        {
            dp[0][i]=0;
        }
        
        for(int i=1; i<m; i++)
        {
            for(int j=1; j<n ;j++)
            {
                if(S.charAt(i)==T.charAt(j))
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                    
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        
        return dp[m-1][n-1];
        
    }
}
