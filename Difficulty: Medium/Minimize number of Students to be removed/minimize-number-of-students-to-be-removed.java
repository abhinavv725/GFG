//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] H = new int[N];
            
            for(int i=0; i<N; i++)
                H[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            out.println(ob.removeStudents(H,N));
        
out.println("~");
}
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private int bs(int[] arr, int n){
        ArrayList<Integer> ans = new ArrayList<>();
        
        ans.add(0,arr[0]);
        int j=0;
        for(int i=1;i<n;i++){
            if(arr[i]>ans.get(j)){
                ++j;
                ans.add(j,arr[i]);
            }else{
                int ind = getBS(ans, arr[i]);
                ans.set(ind, arr[i]);
            }
        }
        return ans.size();
    }
    private int getBS(ArrayList<Integer> arr, int key){
        int low=0, high=arr.size();
        int mid;
        
        while(low<high){
            mid = low+(high-low)/2;
            if(key<=arr.get(mid))
                high=mid;
            else
                low=mid+1;
        }
        if(low<arr.size() && arr.get(low)<key){
            ++low;
        }
        return low;
        
    }
    public int removeStudents(int[] arr, int n) {
        return n - bs(arr,n);
    }
};