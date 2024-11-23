//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int m = Integer.parseInt(inputLine[0]);
            int n = Integer.parseInt(inputLine[1]);
            Solution ob = new Solution();
            System.out.println(ob.numberOfPaths(m, n));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int solve(int m, int n, int i, int j, int[][] dp){
        if(i<0 || j < 0 || i>=m || j>=n)return 0;
        if(i==m-1 && j==n-1)return 1;
        if(dp[i][j]!=-1)return dp[i][j];
        return dp[i][j]=solve(m,n, i+1, j,dp)+ solve(m,n,i,j+1,dp);
    }
    public int numberOfPaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int[] r: dp){
            Arrays.fill(r,-1);
        }
        return solve(m,n,0,0,dp);
    }
}