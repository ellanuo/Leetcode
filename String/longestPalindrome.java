/*Longest Palindromic Substring 
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, 
and there exists one unique longest palindromic substring. */





public class Solution {
    public String longestPalindrome(String s) {
       if(s==null || s.length()<=1)
            return s;
            
        int [] max=new int[2]; //max[0] first index, max[1] maxLength
        max[0]=0;
        max[1]=1;
        
        for(int i=0; i<s.length();i++)
        {
            getMax(s, i, i, max);   //For odd substring
            getMax(s, i, i+1, max);  //For even substring
        }
        
        return s.substring(max[0], max[0]+max[1]);
    }
    
    private void getMax(String s, int i, int j, int [] max)
    {
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j))
        {
            if(max[1]<j-i+1)
            {
                max[0]=i;
                max[1]=j-i+1;
            }
            i--;
            j++;
        }
    }
}
