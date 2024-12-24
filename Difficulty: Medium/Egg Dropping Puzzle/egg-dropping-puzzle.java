//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GfG {

    public static void main(String[] args) throws IOException {

        // Reading input using BufferedReader class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Reading total test cases
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {

            // Reading number of eggs from a separate line
            int n = Integer.parseInt(br.readLine().trim());

            // Reading number of floors from a separate line
            int k = Integer.parseInt(br.readLine().trim());

            // Calling eggDrop() method of class Solution
            System.out.println(new Solution().eggDrop(n, k));
        }
    }
}

// } Driver Code Ends


class Solution {
    private static int solveMem(int e, int f,int[][] dp){
        if(e==1) return f;
        if(f<=1)return f;
        if(dp[e][f]!=-1)return dp[e][f];
        
        int min = Integer.MAX_VALUE;
        for(int k=1;k<=f;k++){
            
            int temp = 1+ Math.max(solveMem(e-1, k-1,dp), 
                                    solveMem(e, f-k,dp));
            min=Math.min(min, temp);
            
        }
        return dp[e][f]=min;
    }
    
    
    static int eggDrop(int n, int k) {
        int[][] dp = new int[n+1][k+1];
        for(int[]r : dp){
            Arrays.fill(r,-1);
        }
        return solveMem(n,k,dp);
    }
}