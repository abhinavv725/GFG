//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int N;
            N = Integer.parseInt(br.readLine());

            int K;
            K = Integer.parseInt(br.readLine());

            int target;
            target = Integer.parseInt(br.readLine());

            int[] coins = IntArray.input(br, N);

            Solution obj = new Solution();
            boolean res = obj.makeChanges(N, K, target, coins);

            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution {
    private static boolean solve(int N, int K, int target, int[] coins,Boolean[][][] dp){
        if(target==0 && K==0)return true;
        
        if(target<0 || K<0 || N<0)return false;
        if(dp[N][K][target]!=null)return dp[N][K][target];
        
        boolean take = solve(N, K-1, target-coins[N], coins,dp);
        boolean notTake = solve(N-1, K, target, coins,dp);
        
        return dp[N][K][target]=take || notTake;
        
    }
    // private static boolean tab(int N, int K, int target, int[] coins){
    //     if(target==0 && K==0)return true;
        
    //     if(target<0 || K<0 || N<0)return false;
        
    //     boolean take = solve(N, K-1, target-coins[N], coins);
    //     boolean notTake = solve(N-1, K, target, coins);
        
    //     return take || notTake;
        
    // }
    public static boolean makeChanges(int N, int K, int target, int[] coins) {
        Boolean[][][] dp = new Boolean[N][K+1][target+1];
        return solve(N-1, K, target,coins, dp);
    }
}
