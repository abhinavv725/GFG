//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            int ans = new Solution().countStrings(n);

            System.out.println(ans);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int countStrings(int n) {
        if(n==0)return 0;
        int[] dp = new int[n+1];
        if(n<3){
            return n+1;
        }
        dp[0] = 1;
        dp[1]=2;
        dp[2]=3;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        
        return dp[n];
    }
}