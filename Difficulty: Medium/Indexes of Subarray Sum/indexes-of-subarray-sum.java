//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int d = Integer.parseInt(read.readLine().trim());

            Solution ob = new Solution();
            ArrayList<Integer> result = ob.subarraySum(nums, d);
            // Print all elements in the result list
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println(); // Print a new line after the result
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int ans=0;
        int st=0, end=0;
        int n =arr.length;
        while(end<n){
            ans+=arr[end];
            if(ans==target){
                 ArrayList<Integer> result = new ArrayList<>();
                result.add(st + 1); // 1-based index
                result.add(end + 1);
                return result;
            }
            while(ans>target){
                ans-=arr[st];
                st++;
                if(ans==target){
                     ArrayList<Integer> result = new ArrayList<>();
                result.add(st + 1); // 1-based index
                result.add(end + 1);
                return result;
                }
            }
            end++;    
            
        }
         ArrayList<Integer> result = new ArrayList<>();
                result.add(-1);
                return result;
    }
}
