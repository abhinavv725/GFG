//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    int countWays(int n, int k) {
        if (n == 0) return 0;
        
        // If there's only one post, we can paint it in k ways
        if (n == 1) return k;
        
        // If there are two posts, we can paint them in k * k ways
        if (n == 2) return k * k;
        
        // Initialize dp array
        int dp1 = k, dp2 = k * k;
        
        // Fill dp for i >= 3
        for (int i = 3; i <= n; i++) {
            int dp = (k - 1) * (dp1 + dp2);
            dp1 = dp2;
            dp2 = dp;
        }
        
        return dp2;
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int k = Integer.parseInt(br.readLine());

            Solution ob = new Solution();
            // ArrayList<Long> ans=ob.smallestDifferenceTriplet(a,b,c,n);
            int ans = ob.countWays(n, k);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends