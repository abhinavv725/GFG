//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxCalories(Arr,n));
                }
        }
}    
// } Driver Code Ends




class Solution
{
	public int maxCalories(int arr[], int n)
	{
		int[] dp = new int[n];
		dp[0]=arr[0];
		if(n==1)
		    return dp[0];
		dp[1]=arr[0]+arr[1];
		if(n==2)
		    return dp[1];
		dp[2] = Math.max(dp[1], 
		        Math.max(arr[2]+arr[1], arr[2]+arr[0]));
		
		for(int i=3;i<n;i++){
		    int one = dp[i-1];
		    int two = arr[i]+arr[i-1]+dp[i-3];
		    int three = arr[i]+dp[i-2];
		    
		    dp[i]=Math.max(one, Math.max(two,three));
		}
		
	
		
		return dp[n-1];
	}
}