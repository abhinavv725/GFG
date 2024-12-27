//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s1 = read.readLine();
            String s2 = read.readLine();
            String s3 = read.readLine();
            Solution obj = new Solution();
            System.out.println(obj.LCSof3(s1, s2, s3));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    private int LCS(String s1, String s2, String s3){
        int n = s1.length();
        int m = s2.length();
        int t = s3.length();
        int[][][] dp = new int[n+1][m+1][t+1];
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                for(int k=1;k<=t;k++){
                    if(s1.charAt(i-1)==s2.charAt(j-1) 
                        && s2.charAt(j-1)==s3.charAt(k-1)){
                            
                        dp[i][j][k]=1+dp[i-1][j-1][k-1];
                        
                    }else{
                        dp[i][j][k]=Math.max(dp[i-1][j][k],
                                Math.max(dp[i][j-1][k], dp[i][j][k-1]));
                    }
                }
            }
        }
        return dp[n][m][t];
    }
    
    int LCSof3(String s1, String s2, String s3) {
        return LCS(s1,s2,s3);
    }
}