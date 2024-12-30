//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            
            int [][] grid = new int[n][m];
            for(int i=0; i<n; i++)
            {
                String S1[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                {
                    grid[i][j] = Integer.parseInt(S1[j]);
                }
            }

            Solution ob = new Solution();
            System.out.println(ob.uniquePaths(n,m,grid));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int uniquePaths(int n, int m, int[][] grid) {
        int[][] dp = grid;
        int mod = (int) Math.pow(10, 9)+7;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(dp[i][j]==0)
                    dp[i][j]=-1;
                else
                    dp[i][j]=0;
            }
        }
        
        for(int i=0;i<n;i++){
            if(dp[i][0]==-1)break;
            dp[i][0]=1;
        }
        
        for(int i=0;i<m;i++){
            if(dp[0][i]==-1)break;
            dp[0][i]=1;
        }
        
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(dp[i][j]==-1)
                    continue;
                if(dp[i-1][j]!=-1)
                    dp[i][j]=(dp[i][j]+dp[i-1][j])%mod;
                
                if(dp[i][j-1]!=-1)
                    dp[i][j]=(dp[i][j]+dp[i][j-1])%mod;
                
            }
        }
        return dp[n-1][m-1]==-1 ? 0: dp[n-1][m-1];
    }
};