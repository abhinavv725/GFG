//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            long res = obj.findMaxSum(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    private int solve(int[] arr, int n){
        if(n==0)return arr[0];
        
        if(n==1)return arr[1]+arr[0];
        
        if(n==2)return Math.max(arr[0]+arr[1], Math.max(arr[1]+arr[2], arr[0]+arr[2]));
        
        int exclude = solve(arr, n-1);
        int include1 = arr[n]+solve(arr, n-2);
        int include2 = arr[n]+arr[n-1]+solve(arr,n-3);
        return Math.max(exclude, Math.max(include1, include2));
    }
    private int tab(int[] arr, int n){
        int[] dp = new int[n];
        dp[0] = arr[0];
        if(n==1)return arr[0];
        
        dp[1]=arr[0]+arr[1];
        if(n==2)return arr[1]+arr[0];
        dp[2] = Math.max(arr[0]+arr[1], Math.max(arr[1]+arr[2], arr[0]+arr[2]));
        if(n==3)return dp[2];
        
        for(int i=3;i<n;i++){
            int exclude = dp[i-1];
            int include1 = arr[i]+dp[i-2];
            int include2 = arr[i]+arr[i-1]+dp[i-3];
            
            dp[i]=Math.max(exclude, Math.max(include1, include2));
        }
        
        return dp[n-1];
    }
    public int findMaxSum(int arr[]) {
        return tab(arr, arr.length);
    }
}