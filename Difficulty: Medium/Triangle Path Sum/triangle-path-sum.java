//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            ArrayList<ArrayList<Integer> > triangle =
                new ArrayList<ArrayList<Integer> >(n);
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                for (int j = 0; j <= i; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                triangle.add(temp);
            }
            Solution obj = new Solution();
            int ans = obj.minPathSum(triangle);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private int solve(ArrayList<ArrayList<Integer>> t){
        
        for(int row=t.size()-2;row>=0;row--){
            for(int col=0;col<t.get(row).size();col++){
                
                int curr = t.get(row).get(col);
                int below = t.get(row+1).get(col);
                int belowRight = t.get(row+1).get(col+1);
                
                t.get(row).set(col, curr+Math.min(below, belowRight));
            }

        }
        
        return t.get(0).get(0);
    }
    public int minPathSum(ArrayList<ArrayList<Integer>> triangle) {
        ArrayList<ArrayList<Integer>> t = triangle;
        return solve(t);
    }
}