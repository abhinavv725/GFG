//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Pair {
    int i, j, t;
    Pair(int i,int j, int t){
        this.i=i;
        this.j=j;
        this.t=t;
    }
}
class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis = new boolean[n][m];
        
        int time=0;
        int[][] ans = grid;
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=true;
                    
                }
            }
        }
        
        while(!q.isEmpty()){
            Pair p= q.poll();
            int i=p.i, j=p.j, t=p.t;
            int[] drow={-1,0,1,0};
            int[] dcol ={0,1,0,-1};
            for(int x=0;x<4;x++){
                int nrow=i+drow[x];
                int ncol = j+dcol[x];
                if(nrow>=0 && nrow<n && ncol>=0 && 
                        ncol<m && !vis[nrow][ncol] && grid[nrow][ncol]==1){
                    q.add(new Pair(nrow,ncol,t+1));
                    time = Math.max(time,t+1);
                    ans[nrow][ncol]=2;
                    vis[nrow][ncol]=true;
                }
            }
            
        }
        
        
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(ans[i][j]==1)
                    return -1;
            }
        }
        return time;
    }
}