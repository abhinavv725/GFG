//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int X = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.nodeLevel(V,list,X));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/
class Pair {
    int level,node;
    Pair(int node,int level){
        this.node=node;
        this.level=level;
    }
}
class Solution
{
    
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
        Queue<Pair> q= new LinkedList<>();
        boolean[] vis= new boolean[V];
        q.add(new Pair(0,0));
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int node = p.node;
            int level=p.level;
            if(node==X)return level;
            vis[node]=true;
            for(Integer it: adj.get(node)){
                if(!vis[it]){
                    q.add(new Pair(it,level+1));
                }
            }
        }
        return -1;
    }
}