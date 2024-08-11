//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
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
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        }
    }
}
// } Driver Code Ends


class Solution {
    private Node reverse(Node head){
        Node prev=null;
        while(head!=null){
            Node nxt = head.next;
            head.next=prev;
            prev=head;
            head=nxt;
        }
        return prev;
    }
    public Node addOne(Node head) {
        Node x = reverse(head);
        Node y = x;
        Node prev=null;
        int carry=1;
        while(x!=null){
            if(carry==1){
                x.data+=1;
                carry=0;
            }
            if(x.data>=10){
                carry=1;
                x.data-=10;
            }
            prev=x;
            x=x.next;
        }
        if(carry==1)
            prev.next=new Node(1);
        return reverse(y);
    }
}
