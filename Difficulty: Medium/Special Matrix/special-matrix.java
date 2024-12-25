//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int k = Integer.parseInt(s[2]);
            int[][] blocked_cells = new int[k][2];
            for (int i = 0; i < k; i++) {
                String[] s1 = br.readLine().trim().split(" ");
                for (int j = 0; j < 2; j++) {
                    blocked_cells[i][j] = Integer.parseInt(s1[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.FindWays(n, m, blocked_cells);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int  mod = 1000000007;
    private int solve(int i, int j, int[][] b){
        if(i==0 && j==0)return 1;
        
        else if(i<0 || j < 0) return 0;
        
        return solve(i-1,j,b)+solve(i,j-1,b);
    }
    private int tab(int n, int m, int[][] b){
        int[][] dp = new int[n][m];
        
        for(int i=0;i<b.length;i++){
            int x = b[i][0]-1;
            int y = b[i][1]-1;
            dp[x][y]=-1;
        }
        for (int i = 0; i < n; i++) {
            if(dp[i][0]==-1)break;
          
            dp[i][0] = 1;
        }
        for (int j = 0; j < m; j++) {
            if(dp[0][j]==-1)break;
            dp[0][j] = 1;
        }
    
        // Fill the DP table
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(dp[i][j]==-1)continue;
                
                if(dp[i-1][j]!=-1)
                    dp[i][j] = (dp[i][j]+dp[i - 1][j])%mod;
                if(dp[i][j - 1]!=-1)
                     dp[i][j] = (dp[i][j]+dp[i][j - 1])%mod;
            }
        }

    // The result is stored in dp[n][m]
       return (dp[n-1][m-1]%mod==-1?0:dp[n-1][m-1]%mod);
    }
    public int FindWays(int n, int m, int[][] blocked_cells) {
        return tab(n,m, blocked_cells);
    }
}