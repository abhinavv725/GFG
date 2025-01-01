//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int w;
            w = Integer.parseInt(br.readLine());

            int[] cost = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.minimumCost(n, w, cost);

            System.out.println(res);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends



class Solution {
    static final int max= (int) Math.pow(10,9);
    
    public static int minimumCost(int n, int w, int[] cost) {
        int[] dp = new int[w+1];
        
        for(int i=1;i<=w;i++){
            dp[i]=max;
            for(int j=1;j<=n;j++){
                if(i-j<0)continue;
                
                if(dp[i-j]!=max && cost[j-1] !=-1){
                    dp[i]=Math.min(dp[i], cost[j-1]+dp[i-j]);
                }
            }
        }
        return dp[w] == max ? -1: dp[w];
    }
}
