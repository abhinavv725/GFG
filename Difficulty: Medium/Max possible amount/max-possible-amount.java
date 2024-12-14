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
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxAmount(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    private int solve(int l, int r, int[] arr,int[][] dp){
        if(l>r)return 0;
        if(l==r)return arr[l];
        
        if(dp[l][r]!=-1)return dp[l][r];
        int pickFirst = arr[l]+Math.min(
                solve(l+2,r,arr,dp),
                solve(l+1,r-1,arr,dp)
            );
        int pickLast = arr[r]+Math.min(
                solve(l,r-2,arr,dp),
                solve(l+1,r-1,arr,dp)
            );
        
        return dp[l][r]=Math.max(pickFirst,pickLast);
    }
    int maxAmount(int arr[] , int n){
        int[][] dp = new int[n][n];
        
        for(int[] r: dp){
            Arrays.fill(r,-1);
        }
        
        
        return solve(0,n-1,arr,dp);
        
    }
}