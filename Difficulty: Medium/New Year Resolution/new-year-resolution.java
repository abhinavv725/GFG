//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[] coins = IntArray.input(br, N);
            
            Solution obj = new Solution();
            boolean res = obj.isPossible(N, coins);
            
            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends



class Solution {
    private static boolean solve(int N, int[] coins,int sum){
        if(sum!=0 && (sum==2024 || sum%24==0 || sum%20 ==0))return true;
        
        if(N<0 || sum>2024) return false;
        
        boolean take = solve(N-1, coins, sum+coins[N]);
        boolean notTake = solve(N-1, coins, sum);
        
        return take || notTake;
    }
    private static boolean tab(int N, int[] coins, int sum){
        boolean[][] dp = new boolean[N+1][sum+1];
        
        dp[0][0] = true; // A sum of 0 can always be formed with an empty set.
        
        for(int i=1;i<=N;i++){
            for(int j=0;j<=sum;j++){
                
                boolean take = (j >= coins[i - 1]) && dp[i - 1][j - coins[i - 1]];
                boolean notTake = dp[i-1][j];
                
                dp[i][j]=take || notTake;
            }
        }
        for(int j=1;j<=sum;j++){
            if(dp[N][j] && (j==2024 || j%24==0 || j%20 ==0))
                return true;
        }
        
        return false;
    }
    public static boolean isPossible(int N, int[] coins) {
        int sum = 0;
        for(int x:coins){
            sum+=x;
        }
        return tab(N, coins, sum);
    }
}
        
