//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maximumPath(int n, int matrix[][])
    {
        int[][] dp = new int[n][n];
        for(int j=0;j<n;j++){
            dp[0][j]=matrix[0][j];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
               int back = dp[i-1][j];
               int leftDi = 0;
               
               if(j-1>=0)leftDi = dp[i-1][j-1];
               else leftDi = Integer.MIN_VALUE;
               
               int rightDi =0;
               if(j+1<n)rightDi = dp[i-1][j+1];
               else rightDi = Integer.MIN_VALUE;
               
               dp[i][j] = matrix[i][j]+ Math.max(
                   back, Math.max(leftDi, rightDi)
                   );
                    
            }
        }
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            ans=Math.max(ans, dp[n-1][i]);
        }
        return ans;
    }
}