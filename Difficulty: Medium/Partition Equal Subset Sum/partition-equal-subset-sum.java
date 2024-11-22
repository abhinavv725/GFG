//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution ob = new Solution();

            if (ob.equalPartition(arr))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    static boolean solve(int[] arr, int ind, int target,Boolean[][] dp){
        if(target==0)return true;
        if(target<0 || ind<0)return false;
        if(dp[ind][target]!=null)return dp[ind][target];
        boolean take = solve(arr, ind-1, target-arr[ind],dp);
        boolean notTake = solve(arr, ind-1,target,dp);
        
        return dp[ind][target] = take || notTake;
    }
    
    static boolean equalPartition(int arr[]) {
        int s=0;
        for(int i:arr){
            s+=i;
        }
        if(s%2!=0)return false;
        Boolean[][] dp = new Boolean[arr.length+1][(s/2)+1];
        
        return solve(arr, arr.length-1, s/2,dp);
    }
}