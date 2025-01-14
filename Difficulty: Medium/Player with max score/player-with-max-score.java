//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            

            Solution ob = new Solution();
            if(ob.is1winner(N,arr))
            System.out.println("1");
            else
            System.out.println("0");
            
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution{
    static private int mem(int i, int j, int[] arr,int[][] dp){
        if(i>j)
            return 0;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int l = arr[i] + Math.min(
                            mem(i+2, j, arr,dp), mem(i+1,j-1,arr,dp));
                            
        int r = arr[j] + Math.min(mem(i+1, j-1, arr,dp), mem(i, j-2,arr,dp));
        return dp[i][j]=Math.max(l,r);
    }
    

    static Boolean is1winner(int N, int arr[]){
        int total =0;
        for(int i=0;i<N;i++){
            total+=arr[i];
        }
        int[][] dp = new int[N][N];
        for(int[]r:dp){
            Arrays.fill(r, -1);
        }
        int sum = mem(0, N-1 , arr,dp);
        return sum>=(total-sum);
    }
}