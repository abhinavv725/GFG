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
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends

class Pair{
    int row,col,steps;
    Pair(int row,int col,int steps){
        this.row=row;
        this.col=col;
        this.steps=steps;
    }
}

class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int n)
    {
        int[] drow = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] dcol = {1, -1, 1, -1, 2, -2, 2, -2};
        Queue<Pair> q =new LinkedList<>();
        boolean[][] vis = new boolean[n+1][n+1];
        int srow=KnightPos[0];
        int scol=KnightPos[1];
        int trow=TargetPos[0];
        int tcol=TargetPos[1];
        vis[srow][scol]=true;
        q.add(new Pair(srow,scol,0));
        if(srow==trow && scol==tcol)return 0;
        while(!q.isEmpty()){
            Pair p=q.poll();
            int row=p.row;
            int col=p.col;
            int steps=p.steps;
            for(int i=0;i<8;i++){
                int nrow=row+drow[i];
                int ncol=col+dcol[i];
                if(nrow>=1 && ncol>=1 && nrow<=n && ncol<=n && !vis[nrow][ncol]){
                    if(nrow==trow && ncol==tcol)return steps+1;
                    vis[nrow][ncol]=true;
                    q.add(new Pair(nrow,ncol,steps+1));
                }
            }
        }
        return -1;
    }
}