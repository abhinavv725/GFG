//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int n = str.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            int res = sln.longestSubseq(arr);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    public static int longestSubseq(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        
        int ans=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(Math.abs(arr[i]-arr[j])==1){
                    dp[i]=Math.max(dp[i], 1+dp[j]);
                    ans=Math.max(dp[i], ans);
                }
            }
        }
        return ans;
    }
}
