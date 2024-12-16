//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();

            Solution obj = new Solution();

            System.out.println(obj.CountPs(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private int solve(int l, int r, int n, String s){
        int count=0;
        while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
            if(r-l+1>=2)count++;
            l--;r++;
            
        }
        return count;
    }
    public int CountPs(String s) {
        int count =0;
        int n = s.length();
        
        for(int i=0;i<n;i++){
            int solveOdd= solve(i,i,n,s);
            int solveEven = solve(i, i+1, n,s);
            count+=solveOdd;
            count+=solveEven;
        }
        return count;
    }
}