//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the Integer values
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into Integer values and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            // Convert ArrayList to array
            Integer[] arr = new Integer[array.size()];
            array.toArray(arr);

            int ans = new Solution().lengthOfLongestAP(arr);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int lengthOfLongestAP(Integer[] arr) {
       // code here
            int n = arr.length;

        // If there are less than 3 elements, 
        // return the size
        if (n <= 2) {
            return n;
        }

        int ans = 0;

        HashMap<Integer, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }

        // Iterate through all pairs of elements as 
        // possible first two terms
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {

                // Calculate the common difference
                int diff = arr[i] - arr[j];

                // Check if this difference was seen before
                int length = dp[j].getOrDefault(diff, 1);

                // Update the length of the AP ending at index `i`
                dp[i].put(diff, length + 1);

                // Update the global maximum length
                ans = Math.max(ans, dp[i].get(diff));
            }
        }

        return ans;


    }
}
