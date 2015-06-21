Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3

//BFS
public class Solution {
    private class IslandNode
    {
        int i;
        int j;
        
        IslandNode(int i, int j)
        {
            this.i=i;
            this.j=j;
        }
    }
    public int numIslands(char[][] grid) {
        if(grid==null|| grid.length==0||grid[0].length==0)
            return 0;
        
        int m=grid.length;
        int n=grid[0].length;
        
        
        int num=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j]=='1')
                {
                    num++;
                    markIsland(grid, i, j);
                }
            }
        }
        return num;
    }
    
    private void markIsland(char[][] grid, int i, int j)
    {
        IslandNode node = new IslandNode(i,j);
        Queue<IslandNode> queue = new LinkedList<IslandNode>();
        queue.add(node);
        
        while(!queue.isEmpty())
        {
            IslandNode center = queue.remove();
            int row=center.i;
            int col=center.j;
            
            if(checkIsland(grid, row-1, col))
            {
                grid[row-1][col]='2';
                queue.add(new IslandNode(row-1,col));
            }
            if(checkIsland(grid, row+1, col))
            {
                grid[row+1][col]='2';
                queue.add(new IslandNode(row+1,col));
            }
            if(checkIsland(grid, row, col+1))
            {
                grid[row][col+1]='2';
                queue.add(new IslandNode(row,col+1));
            }
            if(checkIsland(grid, row, col-1))
            {
                grid[row][col-1]='2';
                queue.add(new IslandNode(row, col-1));
            }
        }
        
    }
    
    private boolean checkIsland(char [][] grid, int i, int j)
    {
        if(i<0||j<0||i>=grid.length||j>=grid[0].length)
            return false;
        if(grid[i][j]=='1')
            return true;
        else
            return false;
    }
    
}

//Dfs

public class Solution {
   
    public int numIslands(char[][] grid) {
        if(grid==null|| grid.length==0||grid[0].length==0)
            return 0;
        
        int m=grid.length;
        int n=grid[0].length;
        
        
        int num=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j]=='1')
                {
                    num++;
                    markIsland(grid, i, j);
                }
            }
        }
        return num;
    }
    
    private void markIsland(char[][] grid, int i, int j)
    {
       grid[i][j]='2';
       if(checkIsland(grid, i-1, j))
       {
           markIsland(grid, i-1, j);
       }
       if(checkIsland(grid, i+1, j))
       {
           markIsland(grid,i+1, j);
       }
       if(checkIsland(grid, i, j+1))
        {
            markIsland(grid, i, j+1);
        }
        if(checkIsland(grid, i, j-1))
        {
            markIsland(grid, i, j-1);
        }
    }
    
    private boolean checkIsland(char [][] grid, int i, int j)
    {
        if(i>=0 && j>=0 && i<grid.length && j<grid[0].length && grid[i][j]=='1')
            return true;
        return false;
    }
   
    
}
