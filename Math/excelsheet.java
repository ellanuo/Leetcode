/*Given a positive integer, return its corresponding column title as appear in an Excel sheet.
For example:
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
*/




public class Solution {
    public String convertToTitle(int n) {
        if(n<=0)
            return null;
            
        StringBuilder sb = new StringBuilder();
        while(n>0)
        {
            sb.append((char)((n-1)%26+'A'));
            n=(n-1)/26;
        }
        StringBuilder result = new StringBuilder();
        for(int i= sb.length()-1; i>=0;i--)
            result.append(sb.charAt(i));
            
        return result.toString();
    }
}
