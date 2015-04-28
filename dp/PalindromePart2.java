/*Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut. */






public class Solution {
    public int minCut(String s) {
        if(s==null || s.length()==0)
            return -1;
        int len=s.length();   
        boolean [][] map = new boolean[len][len];
        
        getMap(s,map);
        
        
        int []dp=new int[len];
        dp[0]=0;
        for(int i=1; i<len;i++)
        {
            dp[i]=Integer.MAX_VALUE;
            if(map[0][i])
            {
                dp[i]=0;
                continue;
            }
            for(int j=1; j<=i; j++)
            {
                if(map[j][i])
                    dp[i]=Math.min(dp[i], dp[j-1]+1);
            }
            
        }
        return dp[len-1];
    }
    
    
    private void getMap(String s, boolean[][] map)
    {
        int len=s.length();
        for(int i=len-1; i>=0; i--)
        {
            for(int j=0; j<len ; j++)
            {
                if(i>j)
                    continue;
                    
                if(i==j)
                    map[i][j]=true;
                
                else
                {
                    if(j==i+1)
                        map[i][j]=(s.charAt(i)==s.charAt(j));
                    else
                        map[i][j]=(map[i+1][j-1] && s.charAt(i)==s.charAt(j));
                }
            }
        }
    }
}
