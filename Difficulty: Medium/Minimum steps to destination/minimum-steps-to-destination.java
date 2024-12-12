//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int d = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            System.out.println(ob.minSteps(d));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends




class Solution {
    static int minSteps(int d) {
        
        int steps=0;
        int sum=0;
        if(d==0)return 0;
        while(sum<d){
            sum+=steps;
            steps++;
            
        }
        while((sum-d)%2!=0){
            sum+=steps;
            steps++;
        }
        return steps-1;
    }
}