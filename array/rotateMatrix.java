/* You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place? */


public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0]==null || matrix[0].length==0)
            return;
        
        
        int n=matrix.length;
        for(int i=0; i<n/2; i++)
        {
            int start=i;
            int end=n-1-i;
            for(int j=0; j<end-start; j++)
            {
                int tmp=matrix[start][j+start];
                matrix[start][j+start]=matrix[end-j][start];
                matrix[end-j][start]=matrix[end][end-j];
                matrix[end][end-j]=matrix[j+start][end];
                matrix[j+start][end]=tmp;
                
            }
        }
        
        
    }
}
