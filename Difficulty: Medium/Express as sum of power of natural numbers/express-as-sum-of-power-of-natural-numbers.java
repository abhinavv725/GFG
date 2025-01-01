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
            int n = Integer.parseInt(input[0]); 
            int x = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.numOfWays(n, x));
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    static final int mod = (int) Math.pow(10, 9)+7;
    
    private static int solve(int i, int sum,int x){
        int pow = (int)Math.pow(i, x);
        if(sum==0)return 1;
        if(sum<0 || pow> sum)return 0;
        
        
        int include = solve(i+1, sum-pow, x);
        int exclude = solve(i+1, sum, x);
        
        return (include+exclude)%mod;
    }
    
    private static int tab(int n,int x){
        int base = (int)Math.pow(n, 1.0/x);
        int[][] dp = new int[base+1][n+1];
        
        for(int i=0;i<=base;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<=base;i++){
            int pow = (int) Math.pow(i,x);
            for(int j=1;j<=n;j++){
                // exclude the curr
                dp[i][j]=dp[i-1][j];
                if(j>=pow){
                    dp[i][j]=(dp[i][j]+dp[i-1][j-pow])%mod;
                }
            }
        }
        
        
        return dp[base][n];
    }
    
    static int numOfWays(int n, int x)
    {
        return tab(n,x);
    }
}