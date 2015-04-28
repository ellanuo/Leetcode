/* Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not. */



public class Solution {
    public boolean isValid(String s) {
        if(s==null || s.length()==0)
            return false;
        
        Stack<Character> stack = new Stack<Character>();
        HashMap<Character,Character> map = new HashMap<Character, Character>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        
        char[] a=s.toCharArray();
        for(int i=0; i<s.length();i++)
        {
            if(a[i]=='('||a[i]=='{' ||a[i]=='[')
                stack.push(a[i]);
            else
            {
                if(stack.isEmpty())
                    return false;
                    
                if(!map.containsKey(a[i]) || stack.peek()!=map.get(a[i]))
                    return false;
                
                stack.pop();
            }
        }
        
        if(stack.isEmpty())
            return true;
        
         else
            return false;
        
    }
}
