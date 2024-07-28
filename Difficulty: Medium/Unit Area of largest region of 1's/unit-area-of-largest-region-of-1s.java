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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.findMaxArea(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    private void dfs(int row,int col,int[][] grid,boolean[][] vis,int[] temp_max){
        int n=grid.length;
        int m=grid[0].length;
        temp_max[0]+=1;
        vis[row][col]=true;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int nrow=row+i;
                int ncol=col+j;
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && 
                grid[nrow][ncol]==1 && !vis[nrow][ncol])
                    dfs(nrow,ncol,grid,vis,temp_max);
            }
        }
    }
    //Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] grid)
    {
        int n=grid.length;
        int m=grid[0].length;
        int max=0;
        int[] temp_max={0};
        boolean[][] vis = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    dfs(i,j,grid,vis,temp_max);
                    max=Math.max(max,temp_max[0]);
                    temp_max[0]=0;
                }
            }
        }
        return max;  
    }
}