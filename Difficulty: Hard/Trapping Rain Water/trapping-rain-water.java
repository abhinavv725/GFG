//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().trappingWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int trappingWater(int arr[]) {
        int n = arr.length;
        
        int[] leftArr = new int[n];
        int[] rightArr = new int[n];
        
        leftArr[0]=arr[0];
        for(int i=1;i<n;i++){
            leftArr[i]=Math.max(leftArr[i-1],arr[i]);
        }
        
        rightArr[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            rightArr[i]=Math.max(rightArr[i+1],arr[i]);
        }
        
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=Math.min(leftArr[i],rightArr[i]) - arr[i];
        }
        return ans;
    }
}
