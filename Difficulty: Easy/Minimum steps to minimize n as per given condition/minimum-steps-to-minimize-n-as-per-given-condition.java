//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minSteps(n));
                    
                }
        }
}    
// } Driver Code Ends


class Solution{
    public int solve(int n,int[] dp){
        if(n==1)return 0;
        if(n<1)return Integer.MAX_VALUE;
        if(dp[n]!=-1)return dp[n];
        
        int a= Integer.MAX_VALUE,b= Integer.MAX_VALUE,c= Integer.MAX_VALUE ;
        if(n%3==0) a = solve(n/3,dp);
        if(n%2==0) b=solve(n/2,dp);
        c = solve(n-1,dp);
        
        return dp[n]=1+Math.min(a,Math.min(b,c));
    }

	public int minSteps(int N) 
	{ 
	    int[] dp = new int[N+1];
	    Arrays.fill(dp,-1);
	    return solve(N,dp);
	} 
}
