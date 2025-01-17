//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob = new Solution();
            int[] ans = new int[n];
            ans = ob.productExceptSelf(arr);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            System.out.println("~");
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int[] productExceptSelf(int arr[]) {
        int prod=1, zero=0, n=arr.length;
        
        for(int r:arr){
            if(r==0)
                zero++;
            else
                prod*=r;
        }
        int[] ans = new int[n];
        if(zero>=2)
            return ans;
        for(int i=0;i<n;i++ ){
            if(zero==0){
                ans[i]=prod/arr[i];
            }else{
                if(arr[i]==0){
                    ans[i]=prod;
                }else{
                    ans[i]=0;
                }
            }
        }
        return ans;
    }
}
