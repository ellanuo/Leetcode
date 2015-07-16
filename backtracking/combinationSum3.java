Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]





public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        subHelper(result, new ArrayList<Integer>(), n, 1, k);
        return result;
        
    }
    
    private void subHelper(List<List<Integer>> result, List<Integer> list, int n, int num, int k)
    {
        if(n==0 && list.size()==k)
        {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        if(n<0 || list.size()>=k)
            return;
        
        for(int i=num; i<=9;i++)
        {
            list.add(i);
            subHelper(result, list, n-i, i+1, k);
            list.remove(list.size()-1);
        }
    }
}
