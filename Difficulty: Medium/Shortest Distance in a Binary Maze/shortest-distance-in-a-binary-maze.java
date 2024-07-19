//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Pair{
    int first,second,third;
    Pair(int first,int second, int third){
        this.first=first;
        this.second=second;
        this.third=third;
    }
}

class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {
        Queue<Pair> q = new LinkedList<>();
        int n=grid.length;
        int m= grid[0].length;
        
        int[][] dist = new int[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                dist[i][j]=(int)1e9;
        //first = dist, second=row, third = col
        if(source[0]==destination[0] && source[1]==destination[1])
            return 0;
        q.add(new Pair(0,source[0],source[1]));
        dist[source[0]][source[1]]=0;
        int dr[]={-1,0,1,0};
        int dc[] = {0,1,0,-1};
        while(!q.isEmpty()){
            Pair it = q.poll();
            int distq = it.first;
            int row = it.second;
            int col = it.third;
            for(int i=0;i<4;i++){
                int pr= row+dr[i];
                int pc = col+dc[i];
                
                if(pr>=0 &&  pc>=0 && pr<n && pc<m && grid[pr][pc]==1 && 1+distq<dist[pr][pc]){
                    dist[pr][pc]=1+distq;
                    q.add(new Pair(1+distq,pr,pc));
                    if(pr==destination[0] && pc==destination[1])
                        return 1+distq;
                }
            }
            
        }
        return -1;
        
        
        
    }
}
