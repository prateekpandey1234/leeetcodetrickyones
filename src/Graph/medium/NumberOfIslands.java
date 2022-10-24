package Graph.medium;

import java.util.LinkedList;
//Good question to start with DFS/BFS
public class NumberOfIslands {
    //DFS method
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfsFill(grid,i,j);
                    count++;
                }
            }
        return count;
    }
    private void dfsFill(char[][] grid,int i, int j){
        if(i>=0 && j>=0 && i<grid.length && j<grid[0].length && grid[i][j]=='1'){
            grid[i][j]='0';//this condition here will save our time as we don't need to revisit the same place
            //we need to visit all the neighbours here as they are always 4 of them
            dfsFill(grid, i + 1, j);
            dfsFill(grid, i - 1, j);
            dfsFill(grid, i, j + 1);
            dfsFill(grid, i, j - 1);
        }
    }
//BFS Method
    public int numIslands2(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++){
                //it will allow us to search for every different group as we're converting the 1's to 0's in bfsfill method
                if(grid[i][j]=='1'){
                    bfsFill(grid,i,j);
                    count++;
                }
            }
        return count;
    }
    private void bfsFill(char[][] grid,int x, int y){
        grid[x][y]='0';
        int n = grid.length;
        int m = grid[0].length;
        LinkedList<Integer> queue = new LinkedList<>();
        //good method of avoiding using of external class such as pair
        int code = x*m+y;
        queue.offer(code);
        while(!queue.isEmpty())
        {
            code = queue.poll();
            int i = code/m;
            int j = code%m;
            if(i>0 && grid[i-1][j]=='1')    //search upward and mark adjacent '1's as '0'.
            {
                queue.offer((i-1)*m+j);
                grid[i-1][j]='0';
            }
            if(i<n-1 && grid[i+1][j]=='1')  //down
            {
                queue.offer((i+1)*m+j);
                grid[i+1][j]='0';
            }
            if(j>0 && grid[i][j-1]=='1')  //left
            {
                queue.offer(i*m+j-1);
                grid[i][j-1]='0';
            }
            if(j<m-1 && grid[i][j+1]=='1')  //right
            {
                queue.offer(i*m+j+1);
                grid[i][j+1]='0';
            }
        }
    }
}
