/* Description:

Count the number of prime numbers less than a non-negative number, n */


public class Solution {
    public int countPrimes(int n) {
        if(n<=2)
            return 0;
        int count=0;
        boolean [] nums = new boolean[n];
        for(int i=2; i<n;i++)
        {
            if(!nums[i])
            {
                count++;
                for(int j=2*i;j<n;j=j+i)
                    nums[j]=true;
            }
        }
        
        return count;
    }
}
