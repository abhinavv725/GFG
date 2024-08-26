//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class Partition {
    static Node head;

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            int x = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            Node res = ob.partition(head, x);
            printList(res);
            System.out.println();
        }
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


// User function Template for Java



class Solution {
    public static Node partition(Node head, int x) {
        Node curr=head;
        
        Node dumm_les = new Node(-1);
        Node dumm_equ = new Node(-1);
        Node dumm_gre = new Node(-1);
        Node prev_les=dumm_les, prev_equ=dumm_equ, prev_gre = dumm_gre;
        while(curr!=null){
            if(curr.data<x){
                prev_les.next=curr;
                prev_les=prev_les.next;
            }
            else if(curr.data==x){
                prev_equ.next=curr;
                prev_equ=prev_equ.next;
            }else{
                prev_gre.next=curr;
                prev_gre=prev_gre.next;
            }
            curr=curr.next;
        }
        prev_equ.next=null;
        prev_les.next=null;
        prev_gre.next=null;
        
        Node dummy= new Node(-1);
        Node prev=dummy;
        if(dumm_les.next!=null){
            prev.next=dumm_les.next;
            prev=prev_les;
        }
        if(dumm_equ.next!=null){
            prev.next=dumm_equ.next;
            prev=prev_equ;
        }
        if(dumm_gre.next!=null){
            prev.next=dumm_gre.next;
            prev=prev_gre;
        }
        
        return dummy.next;
    }
}