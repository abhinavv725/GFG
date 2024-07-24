//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    private void dfs(int row,int col,char[][] grid, boolean[][] vis){
        vis[row][col]=true;
        int n=grid.length;
        int m= grid[0].length;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int nrow = row+i;
                int ncol = col+j;
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m 
                && !vis[nrow][ncol] && grid[nrow][ncol]=='1')
                    dfs(nrow,ncol,grid,vis);
            }
        }
        
    }
    
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m= grid[0].length;
        
        boolean[][] vis = new boolean[n][m];
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    ans++;
                    dfs(i,j,grid,vis);
                }
            }
        }
        return ans;
    }
}