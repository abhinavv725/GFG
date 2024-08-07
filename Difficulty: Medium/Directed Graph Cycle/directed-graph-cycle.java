//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    
    private boolean checkForCycle(int node, boolean[] pathVisit,ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        vis[node]=true;
        pathVisit[node]=true;
        
        for(Integer it: adj.get(node)){
            if(vis[it]==false){
                if(checkForCycle(it,pathVisit,adj,vis))
                    return true;
            }else{
                if(pathVisit[it]){
                    return true;
                }
            }
        }
        pathVisit[node]=false;
        return false;
        
    }
    
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        boolean[] pathVisit = new boolean[V];
        
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                if(checkForCycle(i,pathVisit,adj,vis))
                    return true;
            }
        }
        return false;
    }
}