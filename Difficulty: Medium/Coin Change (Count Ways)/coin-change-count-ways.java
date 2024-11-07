//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String inputLine[] = read.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int sum = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.count(arr, sum));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    public long solve(int ind, int sum, int[] coins,long[][] dp){
        if(sum==0)return 1;
        
        if(sum<0 || ind<0)return 0;
        if(dp[ind][sum]!=-1)return dp[ind][sum];
        long notTake = solve(ind-1, sum, coins,dp);
        long take = solve(ind, sum-coins[ind],coins,dp);
        
        return dp[ind][sum]=notTake+take;
        // return notTake+take;
        
        
        
    }
    
    public long count(int coins[], int sum) {
        
        long[][] dp = new long[coins.length][sum+1];
        
        for(long[] row : dp) Arrays.fill(row,-1);
        return solve(coins.length-1, sum, coins,dp);
    }
}