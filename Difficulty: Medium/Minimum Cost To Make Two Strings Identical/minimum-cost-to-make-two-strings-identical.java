//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String X = sc.next();
            String Y = sc.next();
            int costX = sc.nextInt();
            int costY = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.findMinCost(X, Y, costX, costY));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


class Solution {
    private int LIS(String x, String y){
        int n=x.length();
        int m = y.length();
        
        int[][] dp = new int[n+1][m+1];
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(x.charAt(i-1)==y.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    public int findMinCost(String x, String y, int costX, int costY) {
        int lis = LIS(x, y);
        int n = x.length() -lis;
        int m = y.length() -lis;
        return n*costX + m*costY;
    }
}
