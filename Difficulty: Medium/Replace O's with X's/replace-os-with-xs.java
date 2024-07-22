//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    private static void dfs(boolean[][] vis, int row, int col, char[][] a){
        vis[row][col]=true;
        int[] drow ={-1,0,1,0};
        int[] dcol ={0,1,0,-1};
        int n= a.length;
        int m=a[0].length;
        for(int z=0;z<4;z++){
            int nrow = row+drow[z];
            int ncol = col + dcol[z];
            
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==false 
            && a[nrow][ncol]=='O'){
                dfs(vis,nrow,ncol,a);
            }
        }
    }
    static char[][] fill(int n, int m, char a[][])
    {
        boolean[][] vis = new boolean[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0 || j==0 || i==n-1 || j==m-1) && a[i][j]=='O' && vis[i][j]==false)
                    dfs(vis,i,j,a);
            }
        }
        char[][] b = new char[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==true)
                    b[i][j]='O';
                else
                    b[i][j]='X';
            }
        }
        return b;
    }
}