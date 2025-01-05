//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    
    private static int solve(int[] arr, int i, int n){
        if(i+2>=n)
            return 0;
        
        int a = arr[i] + solve(arr, i+1,n);
        int b = arr[i+1]+solve(arr, i+2,n);
        int c = arr[i+2] + solve(arr,i+3,n);
        
        return Math.min(a, Math.min(b,c));
    }
    
    private static int tab(int[] arr, int n){
        if(n<=2)
            return 0;
        
        int[] dp = new int[n];
        dp[0]=arr[0];
        dp[1]=arr[1];
        dp[2]=arr[2];
        for(int i=3;i<n;i++){
            dp[i]=arr[i]+ Math.min(dp[i-1], 
                            Math.min(dp[i-2], dp[i-3]));
        }
        
        
        return Math.min(dp[n-1], Math.min(dp[n-2],dp[n-3]));
    }

    public static int minSum(int arr[]) {
        return tab(arr, arr.length);
    }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // int k = Integer.parseInt(br.readLine());
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
            int ans = obj.minSum(arr);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends