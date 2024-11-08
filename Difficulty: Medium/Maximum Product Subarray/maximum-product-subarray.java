//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int n = inputLine.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxProduct(arr));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        if(arr.length==0 || arr==null)return 0;
        
        int currMin=1, currMax=1, result = Integer.MIN_VALUE;
        
        for(int i=0;i<arr.length;i++){
            result=Math.max(result,arr[i]);
        }
        for(int i=0;i<arr.length;i++){
            int n=arr[i];
            if(n==0){
                currMin=1; currMax=1;
            }else{
                int tmp =currMax;
                currMax=Math.max(Math.max(currMax*n,currMin*n),n);
                currMin=Math.min(Math.min(tmp*n,currMin*n),n);
                
                result = Math.max(currMax,result);
            }
            
        }
        
        return result;
    }
}