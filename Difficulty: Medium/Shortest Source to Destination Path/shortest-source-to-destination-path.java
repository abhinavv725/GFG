//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int row,col,length;
    Pair(int row,int col,int length){
        this.row=row;
        this.col=col;
        this.length=length;
        
    }
}
class Solution {
    int shortestDistance(int n, int m, int a[][], int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        if(a[0][0]==0)return -1;
        if(x==0 && y==0)return 0;
        q.add(new Pair(0,0,0));
        boolean[][] vis = new boolean[n][m];
        int[] drow={-1,0,1,0};
        int[] dcol = {0,-1,0,1};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int row=p.row;
            int col = p.col;
            int length=p.length;
            
            
            for(int i=0;i<4;i++){
                int nrow=row+drow[i];
                int ncol=col+dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && a[nrow][ncol]==1 && !vis[nrow][ncol]){
                    vis[nrow][ncol]=true;
                    if(nrow==x && ncol==y)
                        return length+1;
                    q.add(new Pair(nrow,ncol,length+1));
                }
            }
        }
        return -1;
    }
};