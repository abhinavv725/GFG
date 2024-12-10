//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String temp[] = sc.nextLine().trim().split(" ");
            int n = temp.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(temp[i]);
            Solution ob = new Solution();
            System.out.println(ob.maxSumIS(arr));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maxSumIS(int arr[]) {
        int n = arr.length;
        int[] dp =  new int[n];
        
        for(int i=0;i<n;i++){
           dp[i]=arr[i];
        }
        int ans=dp[0];
        
        for(int i=0;i<n;i++){
            
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    dp[i]=Math.max(dp[i], arr[i]+dp[j]);
                }
            }
            ans=Math.max(ans, dp[i]);
        }
        return ans;
    }
}