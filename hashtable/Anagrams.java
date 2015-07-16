/* Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case. */

public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
        HashMap<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
        for(int i=0; i<strs.length; i++)
        {
            String key=sort(strs[i]);
            LinkedList<String> strings = map.get(key);
            if(strings==null)
            {
                strings=new LinkedList<String>();
                map.put(key,strings);
            }
            strings.add(strs[i]);
        }
        
        for(LinkedList<String> strList:map.values())
        {
            if(strList.size()>1)
                result.addAll(strList);
                
        }
        return result;
    }
    
    private String sort(String str)
    {
        char [] s = str.toCharArray();
        Arrays.sort(s);
        return new String(s);
    }
}



//Method2: Assign a prime number for a to z, and then multiply all prime numbers together to form a hash value.
Time complexityO(M*N);


public class Solution {
    
    private static final int[] PRIMES = new int[]{2, 3, 5, 7, 11 ,13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 107};

    public List<String> anagrams(String[] strs) {
        
        List<String> result = new ArrayList<String>();
        HashMap<Integer, LinkedList<String>> map = new HashMap<Integer, LinkedList<String>>();
        for(int i=0; i<strs.length; i++)
        {
            //String key=sort(strs[i]);
            int key=1;
            for(int j=0; j<strs[i].length();j++)
            {
                key*=PRIMES[strs[i].charAt(j)-'a'];
            }
            LinkedList<String> strings = map.get(key);
            if(strings==null)
            {
                strings=new LinkedList<String>();
                map.put(key,strings);
            }
            strings.add(strs[i]);
        }
        
        for(LinkedList<String> strList:map.values())
        {
            if(strList.size()>1)
                result.addAll(strList);
                
        }
        return result;
    }
    
  /*  private String sort(String str)
    {
        char [] s = str.toCharArray();
        Arrays.sort(s);
        return new String(s);
    } */
}
