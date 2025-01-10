//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.HashMap;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());

            ArrayList<Integer> ans = new Solution().countDistinct(arr, k);

            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            t--;
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for(int i=0;i<k && i<n;i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        ans.add(map.size());
        
        for(int i=1;i<=n-k;i++){
            int x = map.get(arr[i-1]);
            if(x==1)
                map.remove(arr[i-1]);
            else
                map.put(arr[i-1], map.get(arr[i-1])-1);
                
            map.put(arr[i+k-1], map.getOrDefault(arr[i+k-1],0)+1);
            ans.add(map.size());
            
        }
        
        
        
        return ans;
        // code here
    }
}
