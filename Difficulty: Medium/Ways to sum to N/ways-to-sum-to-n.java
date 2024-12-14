//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int m = sc.nextInt();
                    int N = sc.nextInt();
                    int Arr[] = new int[m];
                    for(int i = 0;i<m;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.countWays(Arr,m,N));
                
System.out.println("~");
}
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    private static final int MOD = 1000000007;
    public int countWays(int arr[], int m, int N) 
    { 
       int[] dp = new int[N+1];
       dp[0]=1;
       
       for(int tar =1;tar<=N;tar++){
           for(int i=0;i<m;i++){
               if(tar-arr[i]>=0)
                dp[tar]=(dp[tar]+dp[tar-arr[i]])%MOD;
           }
       }
       return dp[N]%MOD;
    } 
}