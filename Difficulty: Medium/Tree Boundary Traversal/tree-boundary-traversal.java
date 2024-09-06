//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


class Solution
{
    boolean isLeaf(Node root){
        if(root.left==null && root.right==null)return true;
        return false;
    }
    void addLeft(Node root, ArrayList<Integer> ans){
        while(root!=null){
            if(!isLeaf(root))
                ans.add(root.data);
            root = root.left!=null?root.left:root.right;
        }
    }
    void addLeafs(Node root, ArrayList<Integer> ans){
        if(root!=null){
            if(isLeaf(root))ans.add(root.data);
            addLeafs(root.left,ans);
            addLeafs(root.right,ans);
        }
    }
    void addRight(Node root, ArrayList<Integer> ans){
        Stack<Integer> s = new Stack<>();
        while(root!=null){
            if(!isLeaf(root))
                s.push(root.data);
            root = root.right!=null?root.right:root.left;
        }
        while(!s.isEmpty()){
            ans.add(s.pop());
        }
    }
	ArrayList <Integer> boundary(Node root)
	{
	    ArrayList<Integer> ans = new ArrayList<>();
	    if(root==null)return ans;
	    if(!isLeaf(root))ans.add(root.data);
	    if(root.left!=null)addLeft(root.left, ans);
	    addLeafs(root, ans);
	    if(root.right!=null)addRight(root.right,ans);
	    return ans;
	    
	}
}
