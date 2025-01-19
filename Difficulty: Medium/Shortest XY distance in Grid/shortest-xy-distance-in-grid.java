//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");

            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);

            ArrayList<ArrayList<Character>> grid = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                ArrayList<Character> col = new ArrayList<>();
                String S1[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    col.add(S1[j].charAt(0));
                }
                grid.add(col);
            }

            Solution ob = new Solution();
            System.out.println(ob.shortestXYDist(grid, N, M));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java



class Solution {
    static class Pair {
        int i,j;
        Pair(int i, int j){
            this.i=i;
            this.j=j;
        }
    }
    static int shortestXYDist(ArrayList<ArrayList<Character>> grid, int N,
                              int M) {
        
        ArrayList<Pair> x = new ArrayList<>();
        ArrayList<Pair> y = new ArrayList<>();
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(grid.get(i).get(j)=='X'){
                    x.add(new Pair(i,j));
                }else if(grid.get(i).get(j)=='Y'){
                    y.add(new Pair(i,j));
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for(Pair a: x){
            for(Pair b: y){
                min=Math.min(min, Math.abs(a.i-b.i)+Math.abs(a.j-b.j));
            }
        }
        return min;
        
    }
};