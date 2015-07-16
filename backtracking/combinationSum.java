Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 


public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(candidates==null || candidates.length==0)
            return result;
        
        Arrays.sort(candidates);
        subHelper(result,new ArrayList<Integer>(), candidates, target, 0);
        return result;
        
    }
    
    private void subHelper(List<List<Integer>> result, List<Integer> list, int []candidates, int target, int pos)
    {
        if(target==0)
        {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        if(target<0)
            return;
        
        for(int i=pos;i<candidates.length;i++)
        {
            list.add(candidates[i]);
            subHelper(result,list, candidates, target-candidates[i],i);
            list.remove(list.size()-1);
        }
    }
}
