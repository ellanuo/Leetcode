The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.


public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        if(n<0)
            return result;
        result.add(0);
        subHelper(result, n);
        return result;
        
    }
    
    private boolean subHelper(List<Integer> result, int n)
    {
        if(result.size()==Math.pow(2,n))
            return true;
        
        for(int i=0; i<n; i++ )
        {
            int num=result.get(result.size()-1);
            int nextnum=changeBit(num, i);
            if(result.contains(nextnum))
                continue;
            result.add(nextnum);
            if(subHelper(result, n))
                return true;
            result.remove(result.size()-1);
        }
        return false;
    }
    
    private int changeBit(int num, int bit)
    {
        return (num ^ 1<<bit);
    }
}
