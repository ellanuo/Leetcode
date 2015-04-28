public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> result = new ArrayList<String> ();
        if(s==null || s.length()==0 || dict==null || dict.size()==0)
        {
            return result;
        }
        
        int len=s.length();
        boolean [] dp = new boolean[len+1];
        dp[0]=true;
        
        for(int i=1; i<=len; i++)
        {
            for(int j=0;j<i;j++)
            {
                if(dp[j] && dict.contains(s.substring(j,i)))
                {
                    dp[i]=true;
                    break;
                }
            }
        }
        
        if(dp[len])
            subHelper(result, new StringBuffer(), dp, s, dict,0);
        
        return result;
        
    }
    
    private void subHelper(List<String> result, StringBuffer sb, boolean[] dp, String s, Set<String> dict, int pos)
    {
        if(pos==s.length())
         {
             sb.setLength(sb.length()-1);
             result.add(new String(sb));
             sb.append(' ');
             return;
         }
         
         for(int i=pos; i<s.length();i++)
         {
             if(dp[pos] && dict.contains(s.substring(pos,i+1)))
                {
                    sb.append(s.substring(pos,i+1));
                    sb.append(' ');
                    subHelper(result, sb, dp, s, dict, i+1);
                    sb.setLength(sb.length()-(i+1-pos)-1);
                    
                }
         }
        
        
    }
    
    
}


/*
public class Solution {
public List<String> wordBreak(String s, Set<String> dict) {
    List<String> result = new ArrayList<String>();
    for(int j = s.length() - 1; j >= 0; j--){
        if(dict.contains(s.substring(j)))
            break;
        else{
            if(j == 0)
                return result;
        }
    }
    for(int i = 0; i < s.length()-1; i++)
    {
        if(dict.contains(s.substring(0,i+1)))
        {
            List<String> strs = wordBreak(s.substring(i+1,s.length()),dict);
            if(strs.size() != 0)
                for(Iterator<String> it = strs.iterator();it.hasNext();)
                {
                    result.add(s.substring(0,i+1)+" "+it.next());
                }
        }
    }
    if(dict.contains(s)) result.add(s);
    return result;
}
}
*/

/*
public class Solution {
public List<String> wordBreak(String s, Set<String> dict) {
    List<String> result = new ArrayList<String>();
    if(dict==null || dict.size()==0 || s==null || s.length()==0)
        return result;
    
        int len=s.length();
        
        boolean[][] dp= new boolean[len][len];
        
        for(int i=0; i<len; i++)
        {
            for(int j=0; j<len ; j++)
            {
                dp[i][j]=(i+j<len && dict.contains(s.substring(i, i+j+1)));
            }
        }
        
        subHelper(result, new StringBuffer(), dp, dict, s, 0);
        return result;
    }
    
    private void subHelper(List<String> result, StringBuffer sb, boolean[][] dp, Set<String> dict, String s, int pos)
    {
        if(pos==s.length())
        {
            sb.setLength(sb.length()-1);
            result.add(new String(sb));
            sb.append(' ');
            return;
        }
        
        for(int i=pos; i<s.length();i++)
        {
            if(dp[pos][i-pos])
            {
                sb.append(s.substring(pos, i+1));
                sb.append(' ');
                subHelper(result, sb, dp, dict, s, i+1);
                sb.setLength(sb.length()-(i-pos+1)-1);
                
            }
        }
        
    }
}
*/











