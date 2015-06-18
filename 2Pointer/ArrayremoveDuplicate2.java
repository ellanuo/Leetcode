/* Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3]. */





public class Solution {
    public int removeDuplicates(int[] A) {
        if(A==null || A.length==0)
            return 0;
            
        int count=1;
        int i=1;
        for(int j=1; j<A.length; j++)
        {
            if(A[j-1]==A[j] && count>=2)
                continue;
            
            else
            {
                if(A[j-1]!=A[j])
                {
                    count=1;
                    
                }
                else
                {
                    count++; //count is 2
                }
                A[i++]=A[j];   // cannot move element before check count, since it may change the content of array
            }
            
        }
        
        return i;
    }
}
