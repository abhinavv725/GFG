//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    //taking the String
		    String s=sc.nextLine();
		    Solution ob = new Solution();
		    //calling method sumSubstrings() 
		    System.out.println(ob.sumSubstrings(s));
		
System.out.println("~");
}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find sum of all possible substrings of the given string.
    public static long sumSubstrings(String s){
        int mod = (int) Math.pow(10,9)+7;
        int n=s.length();
        long[] dp = new long[n];
        
        dp[0] = s.charAt(0)-'0';
        long ans=dp[0];
        for(int i=1;i<n;i++){
            
            int curr = s.charAt(i)-'0';
            
            dp[i] =( (curr * (i+1)) %mod + (10*(dp[i-1])) %mod)%mod;
            ans+=dp[i]%mod;
            
            // dp[1] = 2+12
            // dp[2] = 3+23+123
            // 
        }
        return ans%mod;
    }
}