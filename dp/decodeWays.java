/*A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.*/







public class Solution {
    public int numDecodings(String s) {
        if(s==null || s.length()==0)
            return 0;
        
        int len=s.length();
        int [] dp = new int [len];
        if(s.charAt(0)=='0')
            return 0;
        dp[0]=1;
        if(len>1)
        {
            if(s.charAt(1)=='0' && s.charAt(0)>'2')
                return 0;
            if(s.charAt(1)!='0' && Integer.parseInt(s.substring(0,2))<=26 && Integer.parseInt(s.substring(0,2))>=11)
                dp[1]=2;
            else 
                dp[1]=1;

        }
        
        for(int i=2; i<len; i++)
        {
            if(s.charAt(i)=='0' && s.charAt(i-1)>'2')
                return 0;
            
            int r1=Integer.parseInt(s.substring(i, i+1));
            int r2=Integer.parseInt(s.substring(i-1,i+1));
            if(r1>0)
                dp[i]+=dp[i-1];
            if(r2<=26 && r2>=10)
                dp[i]+=dp[i-2];
        }
        
        return dp[len-1];
    }
}


//better  dp 
public class Solution {
    public int numDecodings(String s) {
       if(s==null ||s.length()==0)  
            return 0;
        
        int [] dp =new int[s.length()+1];
        dp[0]=1;
        if(s.charAt(0)=='0')
            return 0;
        
        dp[1]=1;
        
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)>='1'&&s.charAt(i)<='9')
                dp[i+1]+=dp[i];
            
            if(s.charAt(i-1)=='1' || (s.charAt(i-1)=='2'&& s.charAt(i)>='0'&&s.charAt(i)<='6'))
                dp[i+1]+=dp[i-1];
            
            
                
        }
        
        return dp[s.length()];
    }
}
