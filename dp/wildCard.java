Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false


public class Solution {
    public boolean isMatch(String s, String p) {
        if(s==null || p==null)
            return false;
        
        int m=s.length();
        int n=p.length();
        
        boolean [][] dp =new boolean[m+1][n+1];
        dp[0][0]=true;
        
        for(int i=0; i<=m;i++)
        {
            for(int j=1; j<=n;j++)
            {
                if(p.charAt(j-1)!='?' && p.charAt(j-1)!='*')
                {
                    if(i>0 && p.charAt(j-1)==s.charAt(i-1) && dp[i-1][j-1])
                        dp[i][j]=true;
                }
                else if(p.charAt(j-1)=='?')
                {
                    if(i>0 && dp[i-1][j-1])
                        dp[i][j]=true;
                }
                else if(p.charAt(j-1)=='*')
                {
                    if(dp[i][j-1]) //match empty sequence
                        dp[i][j]=true;
                    if(i>0 && dp[i-1][j])  //match any not empty sequence
                        dp[i][j]=true;
                }
                
            }
        }
        
        return dp[m][n];
    }
}
