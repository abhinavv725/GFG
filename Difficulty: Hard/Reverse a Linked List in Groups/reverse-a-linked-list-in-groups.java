//{ Driver Code Starts
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

class ReverseInSize {
    static Node head;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());

        while (t-- > 0) {

            String s[] = in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node tail = head;
            for (int i = 1; i < s.length; i++) {
                int a = Integer.parseInt(s[i]);
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail = tail.next;
            }

            int k = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            Node res = ob.reverse(head, k);
            printList(res, out);
            out.println();
        }
        out.close();
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
    }
}

// } Driver Code Ends



class Solution {
    
    private static Node reverse(Node head){
        Node prev=null;
        while(head!=null){
            Node nxt = head.next;
            head.next=prev;
            prev=head;
            head=nxt;
        }
        return prev;
    }
    private static Node getKth(Node head,int k){
        while(head!=null && k>1){
            head=head.next;
            k--;
        }
        return head;
    }
    public static Node reverse(Node node, int k) {
        Node dummy=new Node(-1),curr=node;
        dummy.next=node;
        Node temp=dummy,prev=dummy;
        
        while(curr!=null){
            
            Node kth= getKth(curr,k);
            if(kth==null){
                prev.next=reverse(curr);
                break;
            }else{
                Node nxt = kth.next;
                kth.next=null;
                
                prev.next=reverse(curr);
                curr.next=nxt;
                prev=curr;
                curr=nxt;
            }
            
        }
        
        return temp.next;
    }
}
