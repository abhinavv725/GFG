#User function Template for python3

class Solution:
	def NthRoot(self, n, m):
	    for i in range(1,m+1):
            if i**n==m:
                return i
            elif i**n>m:
                break
        return -1


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
	T=int(input())
	for i in range(T):
		n, m = input().split()
		n = int(n); m = int(m);
		ob = Solution()
		ans = ob.NthRoot(n, m)
		print(ans)
# } Driver Code Ends