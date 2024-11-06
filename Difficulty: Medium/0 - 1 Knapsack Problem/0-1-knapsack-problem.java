//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            // Read capacity
            int capacity = Integer.parseInt(br.readLine());

            // Read values
            String[] valInput = br.readLine().split(" ");
            int[] val = new int[valInput.length];
            for (int i = 0; i < valInput.length; i++) {
                val[i] = Integer.parseInt(valInput[i]);
            }

            // Read weights
            String[] wtInput = br.readLine().split(" ");
            int[] wt = new int[wtInput.length];
            for (int i = 0; i < wtInput.length; i++) {
                wt[i] = Integer.parseInt(wtInput[i]);
            }

            // Call the knapSack function and print the result
            System.out.println(Solution.knapSack(capacity, val, wt));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    
    static int solve(int capacity, int[] val, int[] wt, int n){
        if(n==0 || capacity ==0)return 0;
        
        if(wt[n-1]>capacity)
            return solve(capacity,val,wt,n-1);
        else{
            return Math.max(
                val[n-1]+solve(capacity-wt[n-1],val,wt,n-1),
                
                solve(capacity,val,wt,n-1)
                );
        }
        
    }
    
    static int knapSack(int capacity, int val[], int wt[]) {
        int n= val.length;
        
        return solve(capacity, val,wt,n);
        
    }
}
