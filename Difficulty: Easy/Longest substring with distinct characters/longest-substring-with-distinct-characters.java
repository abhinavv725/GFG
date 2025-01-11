//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubstr(s));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestUniqueSubstr(String s) {
        int ans=0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        int st=0, end=0, n = s.length();
        
        while(end<n ){
            char x = s.charAt(end);
            if(map.containsKey(x) && map.get(x)>=st){
                st=map.get(x)+1;
            }
            map.put(x, end);
            ans = Math.max(ans,end-st+1);
            end++;
                
            
           
        }
        
        return ans;
    }
}