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
                    int n = sc.nextInt();
                    int i = sc.nextInt();
                    int d = sc.nextInt();
                    int c = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.minTimeForWritingChars(n, i, d, c));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    private int max = (int) Math.pow(10,9);
    private int tab(int N ,int I, int D, int C){
        int[] dp = new int[N+1];
        dp[0]=0;
        dp[1]=I;
        for(int i=2;i<=N;i++){
            int a=max, b= max, c= max;
            if(i%2==0){
                a = dp[i-1]+I;
                b = dp[i/2]+C;
            }else{
                a = dp[i-1]+I;
                b = dp[i/2]+C+I;
                c = dp[(i+1)/2]+C+D;
            }
            
            
            dp[i]=Math.min(a, Math.min(b,c));
        }
        
        
        return dp[N];
        
    }
	public int minTimeForWritingChars(int N, int I, int D, int C) 
	{ 
	    return tab(N,I, D, C);
	} 
}
