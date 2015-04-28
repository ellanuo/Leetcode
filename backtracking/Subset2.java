/*Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]*/




public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num==null || num.length==0)
            return result;
            
        Arrays.sort(num);
        subHelper(result, new ArrayList<Integer>(), num, 0);
        
        return result;
    }
    
    private void subHelper(List<List<Integer>> result, List<Integer> list, int[] num, int pos)
    {
        result.add(new ArrayList(list));
        for(int i=pos;i<num.length;i++)
        {
            if(i==pos || (i>pos)&&num[i-1]!=num[i])
            {
                list.add(num[i]);
                subHelper(result,list, num, i+1);
                list.remove(list.size()-1);
            }
        }
    }
}
