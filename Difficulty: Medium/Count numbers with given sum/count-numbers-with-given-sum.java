//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String in_line[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(in_line[0]);
            int Sum = Integer.parseInt(in_line[1]);

            Solution ob = new Solution();
            System.out.println(ob.countWays(n, Sum));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
     static final int MOD = 1000000007;
    static long countWays(int n, int sum) {
        long[][] dp = new long[n+1][sum+1];
        dp[0][0]=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                for (int digit = 0; digit <= Math.min(j,9); digit++) {
                    if (j >= digit) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - digit]) % MOD;
                    }
                }
            }
        }
        return dp[n][sum]==0?-1:dp[n][sum];
    }
}