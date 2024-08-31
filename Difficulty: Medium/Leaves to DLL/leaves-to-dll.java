//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GFG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution g = new Solution();
            Node head = g.convertToDLL(root);
            printInorder(root);
            System.out.println();
            Node curr = head;
            Node last = head;
            while (curr != null) {
                System.out.print(curr.data + " ");
                last = curr;
                curr = curr.right;
            }
            System.out.println();
            curr = last;
            while (curr != null) {
                System.out.print(curr.data + " ");
                curr = curr.left;
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private Node helper(Node root, Node[] ans){
        if(root==null)return null;
        
        if(root.left==null && root.right==null){
            if(ans[0]==null){
                ans[0]=root;
                ans[1]=root;
            }else{
                ans[1].right=root;
                root.left=ans[1];
                ans[1]=root;
            }
            return null;
        }
        root.left = helper(root.left, ans);
        root.right=helper(root.right,ans);
        return root;
    }
    
    public Node convertToDLL(Node root) {
        Node[] ans = new Node[2];
        helper(root, ans);
        return ans[0];
    }
}
