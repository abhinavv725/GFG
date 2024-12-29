//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] grid = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.totalWays(N, M, grid);
            System.out.println(res);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int totalWays(int n, int m, int grid[][]) {
        int[][] dp = grid;
        int mod = (int) Math.pow(10,9)+7;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(dp[i][j]==1)dp[i][j]=-1;
            }
        }
        for(int i=0;i<n;i++){
            if(dp[i][0]==-1)break;
            dp[i][0]=1;
        }
        for(int j=0;j<m;j++){
            if(dp[0][j]==-1)break;
            dp[0][j]=1;
        }
        
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(dp[i][j]==-1)continue;
                
                if(dp[i-1][j]!=-1){
                    dp[i][j]= (dp[i][j]+dp[i-1][j])%mod;
                }
                if(dp[i][j-1]!=-1){
                    dp[i][j]= (dp[i][j]+dp[i][j-1])%mod;
                }
            }
        }
        return dp[n-1][m-1]==-1 ? 0: (dp[n-1][m-1])%mod;
    }
}