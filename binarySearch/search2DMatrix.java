/* Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true. */



public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m=matrix.length;
        int n=matrix[0].length;
        
        int i=0;
        int j=n-1;
        
        while(i<m && j>=0)
        {
            if(matrix[i][j]==target)
                return true;
            
            else if(target>matrix[i][j])
                i++;
            
            else
                j--;
        }
        
        return false;
        
    }
}


public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m=matrix.length;
        int n=matrix[0].length;
        
        int start=0;
        int end=m*n-1;
        
        while(start<=end)
        {
            int mid=(start+end)/2;
            int i=mid/n;
            int j=mid%n;
            
            if(matrix[i][j]==target)
                return true;
            
            else if(matrix[i][j]<target)
                start=mid+1;
            
            else
                end=mid-1;
        }

        return false;
        
        
    }
}
