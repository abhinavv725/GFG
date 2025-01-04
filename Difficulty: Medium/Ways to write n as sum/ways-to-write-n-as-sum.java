//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            int n = Integer.parseInt(read.readLine());

            int res = new Solution().countWays(n);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends




class Solution {
    int mod = (int) Math.pow(10,9)+7;
    private int solve(int n, int k){
        if(n==0)return 1;
        
        
        if(n<0 || k<=0)return 0;
        int include = solve(n-k,k);
        int exclude= solve(n, k-1);
        return (include+exclude)%mod;
    }
    
    private int tab(int n){
        int[][] dp = new int[n+1][n+1];
        
        for(int i=0;i<=n;i++){
            dp[0][i]=1;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                int exclude = 0, include=0;
    
                exclude = dp[i][j-1];
                if(i-j>=0)
                    include = dp[i-j][j];
                
                dp[i][j]=(include+exclude)%mod;
            }
        }
        
        return dp[n][n-1];
    }
    int countWays(int n) {
        
        return tab(n);
    }
}
