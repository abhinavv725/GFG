//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestPalindrome(String s){
        int n = s.length();
        String ans="";
        int res=0;
        
        for(int i=0;i<n;i++){
            int l=i,r=i;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                if(r-l+1>res){
                    res=r-l+1;
                    ans=s.substring(l,r+1);
                }
                l--;
                r++;
            }
            l=i;r=i+1;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                if(r-l+1>res){
                    res=r-l+1;
                    ans=s.substring(l,r+1);
                }
                l--;
                r++;
            }
        }
        return ans;
    }
}