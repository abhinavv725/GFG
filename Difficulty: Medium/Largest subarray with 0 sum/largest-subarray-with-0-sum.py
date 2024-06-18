#Your task is to complete this function
#Your should return the required output
class Solution:
    def maxLen(self, n, a):
        temp=0
        map={}
        ans=0
        for i in range(n):
            temp+=a[i]
            if(temp==0):
                ans=max(ans,i+1)
            else:
                if(temp in map):
                    ans=max(ans,i-map[temp])
                else:
                    map[temp]=i
        
        # print(a)
        return ans
        #Code here


#{ 
 # Driver Code Starts
if __name__=='__main__':
    t= int(input())
    for i in range(t):
        n = int(input())
        arr = list(map(int, input().strip().split()))
        ob = Solution()
        print(ob.maxLen(n ,arr))
# Contributed by: Harshit Sidhwa
# } Driver Code Ends