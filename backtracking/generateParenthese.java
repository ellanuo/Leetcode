/*Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()" */


public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if(n<=0)
            return result;
        
        int ll=n;
        int rr=n;
        subHelper(result, new StringBuilder(), ll, rr);
        
        return result;
        
    }
    
    private void subHelper(List<String> result, StringBuilder sb, int ll, int rr)
    {
        if(ll==0 && rr==0)
        {
            result.add(new String(sb));
            return ;
        }
        
        if(ll>0)
        {
            sb.append('(');
            //ll--;
            subHelper(result,sb, ll-1, rr);
            sb.setLength(sb.length()-1);
        }
        if(rr>ll)
        {
            sb.append(')');
            subHelper(result, sb, ll, rr-1);
            sb.setLength(sb.length()-1);
        }
        
        
    }
}
