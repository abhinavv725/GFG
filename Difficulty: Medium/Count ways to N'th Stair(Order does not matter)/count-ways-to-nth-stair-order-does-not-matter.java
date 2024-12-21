//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            long ans = ob.nthStair(n);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    private int solve(int n){
        if(n==0)return 1;
        if(n<0)return 0;
        
        return 1 + Math.min(solve(n-2),solve(n-1));
    }
    public int nthStair(int n) {
        int[] dp = new int[n+1];
        
        dp[0]=1;dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=1+Math.min(dp[i-1], dp[i-2]);
        }
        return dp[n];
    }
}