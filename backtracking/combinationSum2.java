Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if(i>pos && candidates[i-1]==candidates[i])
                continue;
            
            list.add(candidates[i]);
            subHelper(result,list, candidates, target-candidates[i],i+1);
            list.remove(list.size()-1);
        }
    }
}
