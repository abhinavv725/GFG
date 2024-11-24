//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int m = Integer.parseInt(input[0]); 
            int n = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.numberOfPaths(m,n));
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public long solve(int m, int n, int i, int j, long[][] dp){
        if(i<0 || j < 0 || i>=m || j>=n)return 0;
        if(i==m-1 && j==n-1)return 1;
        if(dp[i][j]!=-1)return dp[i][j];
        return dp[i][j]=(solve(m,n, i+1, j,dp)+ solve(m,n,i,j+1,dp))%1000000007;
    }
    long numberOfPaths(int m, int n)
    {
        
        long[][] dp = new long[m+1][n+1];
        for(long[] r: dp){
            Arrays.fill(r,-1);
        }
        return solve(m,n,0,0,dp);
    }
}