//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if(ans)
                System.out.println("1");
            else 
                System.out.println("0");
        }
    }
}
// } Driver Code Ends



class Solution
{
    private boolean dfs(int row,int col,int[][] grid,boolean[][] vis){
        int n=grid.length;
        int m=grid[0].length;
        vis[row][col]=true;
        if(grid[row][col]==2)
            return true;
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        
        for(int i=0;i<4;i++){
            int nrow=row+drow[i];
            int ncol=col+dcol[i];
            if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && 
            !vis[nrow][ncol] && (grid[nrow][ncol] == 2 || grid[nrow][ncol] == 3)){
                if(dfs(nrow,ncol,grid,vis)==true)
                    return true;
            }
        }
        
        return false;
    }
    public boolean is_Possible(int[][] grid)
    {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis= new boolean[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    return dfs(i,j,grid,vis);
                }
            }
        return false;
    }
}