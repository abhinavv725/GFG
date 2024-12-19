//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine())
                               .trim()
                               .split(" "); // Read the input for the current test case
            int arr[] = new int[str.length];
            // Convert input string into an integer array
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            // Call the solution method and print the result
            System.out.println(new Solution().longestSubsequence(arr));
        }
    }
}
// } Driver Code Ends




class Solution {
 
    static int longestSubsequence(int arr[]) {
        int n = arr.length;
        int[] dp = new int[n];
        
        Arrays.fill(dp, 1);
        int ans=1;
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(arr[i]<arr[j]){
                    dp[i]=Math.max(dp[i], 1+dp[j]);
                    ans=Math.max(ans, dp[i]);
                }
                
            }
        }
        
        return ans;
    }
}