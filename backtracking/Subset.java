/*Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
] */


public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(S==null || S.length==0)
            return result;
        
        Arrays.sort(S);
        subHelper(result, new ArrayList<Integer>(), S, 0);
        return result;
    }
    
    private void subHelper(List<List<Integer>> result, List<Integer> list, int[] S, int pos)
    {
        result.add(new ArrayList<Integer>(list));
        for(int i =pos; i<S.length;i++)
        {
            list.add(S[i]);
            subHelper(result, list, S, i+1);
            list.remove(list.size()-1);
        }
    }
}


/*public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(S==null || S.length==0)
            return result;
        
        Arrays.sort(S);
        subHelper(result, new ArrayList<Integer>(), S, 0);
        return result;
    }
    
    private void subHelper(List<List<Integer>> result, List<Integer> list, int[] S, int pos)
    {
        result.add(new ArrayList<Integer>(list));
        for(int i =pos; i<S.length;i++)
        {
            list.add(S[i]);
            subHelper(result, list, S, i+1);
            list.remove(list.size()-1);
        }
    }
} */

public class Solution{
    public List<List<Integer>> subsets(int [] S)
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(S==null || S.length==0)
            return result;
        
         Arrays.sort(S);
         result.add(new ArrayList<Integer>());
         for(int i=0; i<S.length;i++){
            List<List<Integer>> list = new ArrayList<List<Integer>> ();
            for(List<Integer> l:result)
                list.add(new ArrayList<Integer>(l));
           // list.addAll(result);  //cannot use list.addAll. this is not a copy, just append the reference
            for(List<Integer> l:result)
                l.add(S[i]);
            list.addAll(result);
        
            result=list;
         }
        return result;
    }
    
  
}
