//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine())
                               .trim()
                               .split(" "); // Read the input for the current test case
            int arr[] = new int[str.length];
            // Convert input string into an integer array
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            // Call the solution method and print the result
            System.out.println(new Solution().longestSubsequence(arr));
        }
    }
}
// } Driver Code Ends




class Solution {
    private static int mem(int ind, int prev, int[] arr, int n, int[][] dp){
        if(ind==n)return 0;
        
        int len = 0+ mem(ind+1, prev, arr, n,dp);
        if(prev==-1 || arr[ind]> arr[prev]){
            int take = 1+ mem(ind+1, ind, arr, n,dp);
            len = Math.max(len, take);
        }
        return len;
    }
    // Function to find length of longest increasing subsequence.
    static int tab(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n+1][n+1];
        
        for(int ind = n-1;ind>=0;ind--){
            for(int prev = ind-1;prev>=-1;prev--){
                
                int len = 0+ dp[ind+1][prev+1];
                if(prev==-1 || arr[ind]> arr[prev]){
                    int take = 1+ dp[ind+1][ind+1];
                    len = Math.max(len, take);
                }
                
                dp[ind][prev+1]=len; 
            }
            
        }
        return dp[0][0];
        
    }
    static int longestSubsequence(int arr[]) {
        int n = arr.length;
        int[] next = new int[n+1];
        int[] curr = new int[n+1];
        
        for(int ind = n-1;ind>=0;ind--){
            for(int prev = ind-1;prev>=-1;prev--){
                
                int len = 0+ next[prev+1];
                if(prev==-1 || arr[ind]> arr[prev]){
                    int take = 1+ next[ind+1];
                    len = Math.max(len, take);
                }
                
                curr[prev+1]=len; 
            }
            next=curr;
        }
        return curr[0];
        
        // for(int[] r : dp)
        //     Arrays.fill(r, -1);
        // return mem(0, -1, arr, n, dp);
        // code here
    }
}