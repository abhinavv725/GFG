//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private String toString(int row, int col) {
        return row + " " + col;
    }

    
    private void dfs(int row, int col, int[][] grid,boolean[][] vis,ArrayList<String> temp,
    int rbase,int cbase){
        vis[row][col]=true;
        temp.add(toString(row-rbase,col-cbase));
        int n=grid.length;
        int m=grid[0].length;
        int[] drow={-1,0,1,0};
        int[] dcol={0,-1,0,1};
        for(int i=0;i<4;i++){
            int nrow = row+drow[i];
            int ncol = col+dcol[i];
            
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && 
            vis[nrow][ncol]==false && grid[nrow][ncol]==1){
                dfs(nrow,ncol,grid,vis,temp,rbase,cbase);
            }
        }
    }

    int countDistinctIslands(int[][] grid) {
        Set<ArrayList<String>> ans = new HashSet<>();
        int n=grid.length;
        int m=grid[0].length;
        
        boolean[][] vis = new boolean[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    ArrayList<String> temp = new ArrayList<>();
                    dfs(i,j,grid,vis,temp,i,j);
                    ans.add(temp);
                }
            }
        }
        
        
        return ans.size();
        // Your Code here
    }
}
