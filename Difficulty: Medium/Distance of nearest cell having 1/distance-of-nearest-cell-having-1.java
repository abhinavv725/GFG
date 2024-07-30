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
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends

class Pair {
    int row,col,steps;
    Pair(int row, int col, int steps){
        this.row=row;
        this.col=col;
        this.steps=steps;
    }
}
class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] ans = new int[n][m];
        boolean[][] vis = new boolean[n][m];
            
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    ans[i][j]=0;
                    vis[i][j]=true;
                    q.add(new Pair(i,j,0));
                }
            }
        
        while(!q.isEmpty()){
            Pair node = q.poll();
            int row=node.row;
            int col=node.col;
            int steps=node.steps;
            
            int[] drow={-1,0,1,0};
            int[] dcol={0,1,0,-1};
            
            for(int i=0;i<4;i++){
                int nrow=row+drow[i];
                int ncol=col+dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && !vis[nrow][ncol] && grid[nrow][ncol]==0){
                    vis[nrow][ncol]=true;
                    ans[nrow][ncol]=steps+1;
                    q.add(new Pair(nrow,ncol,steps+1));
                }
            }
            
        }
        return ans;
    }
}










