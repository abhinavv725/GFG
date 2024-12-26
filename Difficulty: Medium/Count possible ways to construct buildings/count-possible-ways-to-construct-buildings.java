//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.TotalWays(N);
            System.out.println(ans);           
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int TotalWays(int N)
    {
        int mod = 1000000007;
        int[] dp = new int[N+1];
        dp[1]=2;
        if(N==1)return 4;
        dp[2]=3;
        
        for(int i=3;i<=N;i++){
            dp[i]=(dp[i-1]+dp[i-2])%mod;
        }
        long result = (long) dp[N] * dp[N] % mod; 
        // Use long to avoid overflow
        return (int) result;
    }
}