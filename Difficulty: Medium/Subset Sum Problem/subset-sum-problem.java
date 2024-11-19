//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
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
    
    static Boolean solve(int[] arr, int target,int ind,Boolean[][] dp){
        if(target==0)return true;
        if(target<0 || ind<0)return false;
        
        if(dp[ind][target]!=null)return dp[ind][target];
        
        Boolean take = solve(arr, target-arr[ind],ind-1,dp);
        Boolean noTake = solve(arr,target, ind-1,dp);

        return dp[ind][target]=take || noTake;
    }

    static Boolean isSubsetSum(int arr[], int target) {
        Boolean[][] dp = new Boolean[arr.length+1][target+1];
        return solve(arr,target,arr.length-1,dp);
    }
}