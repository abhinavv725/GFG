//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
class Solution {
    
    public int mem(int[] coins, int sum, int n){
        if(sum==0)return 0;
        if(sum<0)return Integer.MAX_VALUE;
        
        int mini = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(sum>=coins[i]){
                int ans = mem(coins, sum-coins[i],n);
                if(ans!=Integer.MAX_VALUE){
                    mini = Math.min(mini, 1+ans);
                }
            }
        }
        return mini;
    }
    
    public int tab(int[] coins, int sum, int n){
        
        int[] dp = new int[sum+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[0]=0;
        
        for(int i=1;i<=sum;i++){
            int mini = Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
                if(i>=coins[j]){
                    int ans = dp[i-coins[j]];
                    if(ans!=Integer.MAX_VALUE){
                        mini = Math.min(mini, 1+ans);
                    }
                }
            }
            dp[i]=mini;
        }
        
        
        
        return dp[sum];
    }

    public int minCoins(int coins[], int sum) {
        int n = coins.length;
        int ans=tab(coins, sum, n);
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
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
            int res = obj.minCoins(arr, k);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends