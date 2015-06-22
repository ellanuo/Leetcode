/* Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome. */

public class Solution {
    public boolean isPalindrome(String s) {
        if(s==null || s.length()==0)
            return true;
        
        s=s.trim();
        int i=0;
        int j=s.length()-1;
        
        while(i<j)
        {
            if(!validChar(s.charAt(i)))
            {
                i++;
                continue;
            }
            if(!validChar(s.charAt(j)))
            {
                j--;
                continue;
            }
            
            if(s.charAt(i)!=s.charAt(j) && Math.abs(s.charAt(i)-s.charAt(j))!='a'-'A')
                return false;
            
            i++;
            j--;
        }
        
        return true;
        
    }
    
    private boolean validChar(char a)
    {
        if(a>='0' && a<='9')
            return true;
        if(a>='a' && a<='z')
            return true;
        if(a>='A' && a<='Z')
            return true;
        
        else
            return false;
    }
    
}
