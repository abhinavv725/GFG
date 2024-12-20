//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            int  k = Integer.parseInt(read.readLine());
            int  n = Integer.parseInt(read.readLine());
            int arr[][] = new int[n][n];
            String input_line1[] = read.readLine().trim().split("\\s+");
            int c = 0;
            for(int i=0;i<n;i++){
                for(int j = 0;j<n;j++){
                    arr[i][j] = Integer.parseInt(input_line1[c]);
                    c++;
                }
            }
            Solution obj = new Solution();
            System.out.println(obj.numberOfPath(n, k, arr));
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    private long solve(int i, int j, int n, int k, int[][] arr) {
        // if(k<0) return 0;
        if(k==arr[i][j] && i==0 && j==0)return 1;
        
        int ans=0;
        if(i>0 && k - arr[i][j]>=0)
            ans+=solve(i-1, j, n , k - arr[i][j] , arr);
        
        if(j>0 && k - arr[i][j]>=0)
            ans+=solve(i, j-1, n , k - arr[i][j] , arr);
        
        return ans;
        
    }
    long numberOfPath(int n, int k, int [][]arr) {
        return solve(n-1,n-1,n,k,arr);
    }
}