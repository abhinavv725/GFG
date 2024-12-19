//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int W = Integer.parseInt(in.readLine().trim());
            String line2[] = in.readLine().trim().split(" ");
            int N = line2.length;
            int val[] = new int[N];
            for (int i = 0; i < N; i++) val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split(" ");
            int wt[] = new int[N];
            for (int i = 0; i < N; i++) wt[i] = Integer.parseInt(line3[i]);

            Solution ob = new Solution();
            System.out.println(ob.knapSack(val, wt, W));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private static int solve(int ind,int val[], int wt[], int w){
        if(ind==0){
            return ((int) (w/wt[0]))*val[0];
        }
        int notTake = solve(ind-1, val, wt, w);
        
        int take = 0;
        if(wt[ind]<=w){
            take = val[ind]+solve(ind, val, wt, w-wt[ind]);
        }
        return Math.max(notTake, take);
    }
    
    private static int tab(int val[], int wt[], int w){
        int n = val.length;
        int[][] dp = new int[n][w+1];
        
        for(int i=0;i<=w;i++){
            dp[0][i]=((int) (i/wt[0]))*val[0];
        }
        
        for(int i=1;i<n;i++){
            for(int j=0;j<=w;j++){
                int notTake = dp[i-1][j];
        
                int take = 0;
                if(wt[i]<=j){
                    take = val[i]+dp[i][j-wt[i]];
                }
                dp[i][j]= Math.max(notTake, take);
            }
        }
        return dp[n-1][w];
        
    }
    static int knapSack(int val[], int wt[], int capacity) {
        
        return tab(val, wt, capacity);
    }
}