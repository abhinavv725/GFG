//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to return the total number of possible unique BST.
    static int numTrees(int n) {
        
        int[] dp = new int[n+1];
        dp[0]=dp[1]=1;
        
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String args[]) {
        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // taking n
            int n = sc.nextInt();

            // creating an object of class Solution
            Solution ob = new Solution();

            // calling method numTrees() of
            // class Solution
            System.out.println(ob.numTrees(n));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends