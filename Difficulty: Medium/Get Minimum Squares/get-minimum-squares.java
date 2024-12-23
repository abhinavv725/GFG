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
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.MinSquares(n);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int solve(int n) {
        if(n==0)return 0;
        
        int ans = n;
        
        for(int i=1;i*i<=n;i++){
            ans=Math.min(ans, 1+solve(n-(i*i)));
        }
        return ans;
    }
    
    public int tab(int n) {
        int[] dp = new int[n+1];
        dp[0]=0;
        
        
        
        
        for(int j=1;j<=n;j++){
            int ans = j;
            for(int i=1;i*i<=j;i++){
                if(j-(i*i)>=0)
                ans=Math.min(ans, 1+dp[j-i*i]);
            }
            dp[j]=ans;
        }
        
        
        return dp[n];
    }
    
    public int MinSquares(int n) {
        return tab(n);
    }
}