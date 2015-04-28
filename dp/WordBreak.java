/*LeetCode OJ
Problems 
Pick One!
Submissions
Discuss
Book
Articles
  nshi
Word Break Total Accepted: 41832 Total Submissions: 186934 My Submissions Question Solution 

Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

Show Tags
Have you met this question in a real interview? Yes  No
Discuss */




public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if(s==null|| s.length()==0 || dict==null || dict.size()==0)
            return false;
            
        int len=s.length();
        boolean[] dp=new boolean[len+1];
        
        dp[0]=true;
      /* if(dict.contains(Character.toString(s.charAt(0))))
            dp[0]=true;
        else
            dp[0]=false; */
        for(int i=1; i<=len; i++)
        {
            dp[i]=false;
            for(int j=0; j<i;j++)
            {
               
                if(dp[j] && dict.contains(s.substring(j, i)))
                  {
                     dp[i]=true;
                     break;
                  }
            }
            
        }
        return dp[len];
    }
}
