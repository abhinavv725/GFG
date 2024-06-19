#User function Template for python3

class Solution:
    def findSubArraySum(self, a, N, k):
        map,cnt,su={},0,0
        for i in a:
            su+=i
            if(su==k):cnt+=1
            
            temp=su-k
            cnt+=map.get(temp,0)
                 
            map[su]=map.get(su,0) + 1
        
        return cnt
            
        # code here


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    t = int(input())
    for _ in range (t):
        N = int(input())
        Arr = input().split()
        for itr in range(N):
            Arr[itr] = int(Arr[itr])
        k = int(input())
        ob = Solution()
        print(ob.findSubArraySum(Arr, N, k))
# } Driver Code Ends