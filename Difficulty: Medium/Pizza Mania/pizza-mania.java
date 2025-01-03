//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String St[] = read.readLine().split(" ");
            
            int X = Integer.parseInt(St[0]);
            int S = Integer.parseInt(St[1]);
            int M = Integer.parseInt(St[2]);
            int L = Integer.parseInt(St[3]);
            int CS = Integer.parseInt(St[4]);
            int CM = Integer.parseInt(St[5]);
            int CL = Integer.parseInt(St[6]);

            Solution ob = new Solution();
            System.out.println(ob.getPizza(X,S,M,L,CS,CM,CL));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int max = (int) Math.pow(10,9);
    static int solve(int X, int S, int M, int L, int CS, int CM, int CL){
        if(X<=0)return 0;
        
        int one = CS+solve(X-S, S,M,L,CS,CM,CL);
        int two = CM+solve(X-M, S,M,L,CS,CM,CL);
        int three = CL+solve(X-L, S,M,L,CS,CM,CL);
        
        return Math.min(one, Math.min(two,three));
    }
    static int tab(int X, int s, int m, int l, int cs, int cm, int cl){
        int[]dp = new int[X+1];
        
        for(int i=1;i<=X;i++){
            
            if(i>s) 
                dp[i]=(cs+dp[i-s]);
            else 
                dp[i]=cs;
            if(i>m) 
                dp[i]=Math.min(cm+dp[i-m],dp[i]);
            else
                dp[i]=Math.min(cm,dp[i]);
            if(i>l) 
                dp[i]=Math.min(cl+dp[i-l],dp[i]);
            else
                dp[i] =Math.min(cl,dp[i]);
        }
        
        
        return dp[X];
    }
    static int getPizza(int X, int S, int M, int L, int CS, int CM, int CL) {
        return tab(X,S,M,L,CS,CM,CL);
    }
};