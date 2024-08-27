//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    public Node(int data) { this.data = data; }
}

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {

            String s[] = in.readLine().trim().split(" ");
            Node head = new Node(Integer.parseInt(s[0]));
            Node copy = head;
            for (int i = 1; i < s.length; i++) {
                Node temp = new Node(Integer.parseInt(s[i]));
                copy.next = temp;
                copy = copy.next;
            }
            Solution ob = new Solution();
            Node ans = ob.modifyTheList(head);
            while (ans != null) {
                out.print(ans.data + " ");
                ans = ans.next;
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    private static Node reverse(Node head){
        Node prev= null;
        while(head!=null){
            Node nxt = head.next;
            head.next=prev;
            prev=head;
            head=nxt;
        }
        return prev;
    }
    private static Node middle(Node head){
        Node fast=head.next,slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
        
    }
    public static Node modifyTheList(Node head) {
        if(head==null || head.next==null)return head;
        
        Node mid = middle(head);
        Node back = mid.next;
        mid.next=null;
        back = reverse(back);
        // return head;
        Node curr=head;
        Node prev_back=back;
        while(back!=null){
            int temp = curr.data;
            curr.data=back.data-curr.data;
            back.data=temp;
            curr=curr.next;
            back=back.next;
        }
        
        
        Node end = head;
        while(end.next!=null)end=end.next;
        end.next=reverse(prev_back);
        
        return head;
    }
}