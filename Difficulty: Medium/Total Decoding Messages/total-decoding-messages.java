//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.countWays(s);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    private int rec(String s, int n){
        if(n==0 || n==1)
            return 1;
        
        int cnt=0;
        char curr = s.charAt(n-1);
        char prev= s.charAt(n-2);
        
        if(curr >='1' && curr <='9'){
            cnt+=rec(s, n-1);
        }
        if(prev=='1' || prev == '2' && curr<='6'){
            cnt+=rec(s, n-2);
        }
        return cnt;
    }
    public int countWays(String s) {
        return rec(s, s.length());
    }
}