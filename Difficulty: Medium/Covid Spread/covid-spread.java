//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        while(t-- > 0)
        {
            
            
            int R = sc.nextInt();
            
            int C = sc.nextInt();
            
           
            
            int hospital[][] = new int[R][C];
            
            int cnt=0;
            for(int i = 0; i < R; i++)
                {
                    for(int j=0; j < C; j++)
                {
                    hospital[i][j] = sc.nextInt();
                }
                    
                }
            
            Solution ob = new Solution();
            System.out.println(ob.helpaterp(hospital));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Pair {
    int row,col,time;
    Pair(int row,int col, int time){
        this.row=row;
        this.col=col;
        this.time=time;
    }
}

class Solution{
     public int helpaterp(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int ans=0;
        int[][] group=new int[n][m];
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        int[] drow= {-1,0,1,0};
        int[] dcol= {0,1,0,-1};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=true;
                }
            }
        }
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int row=p.row;
            int col = p.col;
            int time=p.time;
            ans=Math.max(ans,time);
            for(int i=0;i<4;i++){
                int nrow=row+drow[i];
                int ncol=col+dcol[i];
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m 
                && !vis[nrow][ncol] && grid[nrow][ncol]==1){
                    q.add(new Pair(nrow,ncol,time+1));
                    vis[nrow][ncol]=true;
                }
            }
        }
        
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !vis[i][j])
                    return -1;
            }
        }
        return ans;
    }
}
