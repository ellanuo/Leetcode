public class Solution {
    public int romanToInt(String s) {
       // if(s==null || s.length()==0)
         //   return 0;
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int num=0;
        int n=0;
        for(int i=0; i<s.length();i++)
        {
            if(!map.containsKey(s.charAt(i)))
                return 0;
            else if(i==0 || (i>0 && map.get(s.charAt(i))<=map.get(s.charAt(i-1))))
            {
                num+=n;
                n=map.get(s.charAt(i));
            }
            else 
                n=map.get(s.charAt(i))-n;
                
        }
        num+=n;
        return num;
    }
}
