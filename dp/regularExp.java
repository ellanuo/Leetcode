Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true


Analysis:
http://bangbingsyb.blogspot.com/2014/11/leetcode-regular-expression-matching.html
状态：和Mininum Edit Distance这类题目一样。
dp[i][j]表示s[0:i-1]/s[0,i) 是否能和p[0:j-1]/p[0,j)匹配。

递推公式：由于只有p中会含有regular expression，所以以p[j-1]来进行分类。
p[j-1] != '.' && p[j-1] != '*'：dp[i][j] = dp[i-1][j-1] && (s[i-1] == p[j-1]) // match letter
p[j-1] == '.'：dp[i][j] = dp[i-1][j-1]

而关键的难点在于 p[j-1] = '*'。由于星号可以匹配0，1，乃至多个p[j-2]。
1. 匹配0个元素，即消去p[j-2]，此时p[0: j-1] = p[0: j-3]
dp[i][j] = dp[i][j-2]

2. 匹配1个元素，此时p[0: j-1] = p[0: j-2]
dp[i][j] = dp[i][j-1]

3. 匹配多个元素，此时p[0: j-1] = { p[0: j-2], p[j-2], ... , p[j-2] }
dp[i][j] = dp[i-1][j] && (p[j-2]=='.' || s[i-1]==p[j-2])

public class Solution {
    public boolean isMatch(String s, String p) {
        if(s==null  || p==null)
            return false;
            
        int m=s.length();
        int n=p.length();
        
        boolean [][] dp=new boolean[m+1][n+1];
        
        dp[0][0]=true;
       // if(n>=2 && p.charAt(1)=='*')
         //   dp[0][2]=true;
       
       
       
        for(int i=0;i<=m;i++)
        {
            for(int j=1; j<=n; j++)
            {
                /* Match letter */
                if(p.charAt(j-1)!='*' && p.charAt(j-1)!='.')
                {
                    if(i>0 && dp[i-1][j-1] && p.charAt(j-1)==s.charAt(i-1))
                        dp[i][j]=true;
                }
                
                /* '.' Matches any single character. */
                else if (p.charAt(j-1)=='.')
                {
                    if(i>0 && dp[i-1][j-1])
                        dp[i][j]=true;
                }
                
                /* '*' matches zero or more of preceding ,but '*'' cannot be the first char */
                else if(j>=2 && p.charAt(j-1)=='*')
                {
                    
                    
                    if(dp[i][j-2] || dp[i][j-1])
                        dp[i][j]=true;
                    
                    if(i>0 && dp[i-1][j] && (p.charAt(j-2)=='.'||p.charAt(j-2)==s.charAt(i-1)))
                        dp[i][j]=true;
                }
                
            }
        }
        
        
        return dp[m][n];
        
    }
    
    
   
    
}


Attention:
1. for loop, i start from 0, not 1
   case: s="" p="a*
   case: s="" p="a*c*"
2. '*' match multiple char 
    dp[i][j]=dp[i-1][j] && (p[j-2]=='.' || p[j-2]==s[i-1])
    not dp[i][j]=dp[i-1][j-1] && (p[j-2]=='.' || p[j-2]==s[i-1])
    case: s="aaa" p=".*"
3. j>2 '*' cannot be the first char in p


 Method 2: resursion
    http://articles.leetcode.com/2011/09/regular-expression-matching.html
