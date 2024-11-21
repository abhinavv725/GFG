//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();

        while (t-- > 0) {

            // taking count of stairs
            int m = sc.nextInt();

            // creating an object of class DynamicProgramming
            Solution obj = new Solution();

            // calling method countWays() of class
            // DynamicProgramming
            System.out.println(obj.countWays(m));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    
    int solve(int n){
        if(n==0)return 1;
        if(n<0)return 0;
        
        return solve(n-1)+solve(n-2);
    }
    
    // Function to count number of ways to reach the nth stair.
    int countWays(int n) {
        int[] dp = new int[n+1];
        
        return solve(n);
    }
}
