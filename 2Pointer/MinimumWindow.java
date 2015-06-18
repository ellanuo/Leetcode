/* Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S. */

Best solution:
The best solution, is in fact simpler. This best approach is suggested by someone who called stormrage .

Notice how complicated the above solution is. It uses a hash table, a queue, and a sorted map. During an interview, the problems tend to be short and the solution usually can be coded in about 50 lines of code. So be sure that you say out loud what you are thinking and keep communication opened with the interviewer. Check if your approach is unnecessary complex, he/she might be able to give you guidance. The last thing you want to do is to get stuck in a corner and keep silent.

To help illustrate this approach, I use a different example: S = “acbbaca” and T = “aba“. The idea is mainly based on the help of two pointers (begin and end position of the window) and two tables (needToFind and hasFound) while traversing S. needToFind stores the total count of a character in T and hasFound stores the total count of a character met so far. We also use a count variable to store the total characters in T that’s met so far (not counting characters where hasFound[x] exceeds needToFind[x]). When count equals T‘s length, we know a valid window is found.

Each time we advance the end pointer (pointing to an element x), we increment hasFound[x] by one. We also increment count by one if hasFound[x] is less than or equal to needToFind[x]. Why? When the constraint is met (that is, count equals to T‘s size), we immediately advance begin pointer as far right as possible while maintaining the constraint.

How do we check if it is maintaining the constraint? Assume that begin points to an element x, we check if hasFound[x] is greater than needToFind[x]. If it is, we can decrement hasFound[x] by one and advancing begin pointer without breaking the constraint. On the other hand, if it is not, we stop immediately as advancing begin pointer breaks the window constraint.

Finally, we check if the minimum window length is less than the current minimum. Update the current minimum if a new minimum is found.

Essentially, the algorithm finds the first window that satisfies the constraint, then continue maintaining the constraint throughout.




public class Solution {
    public String minWindow(String s, String t) {
        if(s==null || s.length()==0 || t==null || t.length()==0 )
            return null;
            
        //int i=0;  //start of window
       // int j=0; // end of window
        int found=0;
        
        int[] needtofind = new int [256];
        int [] hasfound = new int[256];
        
        int len=Integer.MAX_VALUE;
        String result="";
        
        for(int l=0; l<t.length();l++)
            needtofind[t.charAt(l)]++;
        
        for(int i=0, j=0; j<s.length(); j++)
        {
           // if(needtofind[s.charAt(j)]==0)
             //   continue;
           
            if(needtofind[s.charAt(j)]>hasfound[s.charAt(j)])
            {
                found++;
            }
             hasfound[s.charAt(j)]++;
             
            if(found==t.length())
            {
                while(hasfound[s.charAt(i)]==0 || hasfound[s.charAt(i)]>needtofind[s.charAt(i)])
                {
                    if(hasfound[s.charAt(i)]>0)
                        hasfound[s.charAt(i)]--;
                    i++;
                }
                
                if(j+1-i<len)
                {
                    len=j+1-i;
                    result=s.substring(i,j+1);
                }
                
            }
            
        }
      
        
        return result;
    
        
    }
}

http://articles.leetcode.com/2010/11/finding-minimum-window-in-s-which.html





