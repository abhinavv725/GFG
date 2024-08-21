//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class Absolute_List_Sort {
    Node head;

    /* Function to print linked list */
    void printList(Node head, PrintWriter out) {
        Node temp = head;
        while (temp != null) {
            out.print(temp.data + " ");
            temp = temp.next;
        }
        out.println();
    }

    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) {

        if (head == null)
            head = node;
        else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;

            temp.next = node;
        }
    }

    /* Drier program to test above functions */
    public static void main(String args[]) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());

        while (t > 0) {

            Absolute_List_Sort llist = new Absolute_List_Sort();
            // int n=Integer.parseInt(br.readLine());
            // 			int a1=sc.nextInt();
            String s[] = in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node temp = head;
            for (int i = 1; i < s.length; i++) {
                // int a = sc.nextInt();
                int a = Integer.parseInt(s[i]);
                temp.next = new Node(a);
                temp = temp.next;
            }

            Solution gfgobj = new Solution();
            llist.head = gfgobj.sortList(head);
            llist.printList(llist.head, out);

            t--;
        }
        out.close();
    }
}
// } Driver Code Ends



class Solution {
    Node reverse(Node head){
        Node prev=null;
        while(head!=null){
            Node nxt = head.next;
            head.next=prev;
            prev=head;
            head=nxt;
        }
        return prev;
    }
    Node sortList(Node head) {
        if(head==null || head.next==null){
            return head;
        }
        Node neg_dum=new Node(-1);
        Node pos_dum=new Node(-1);
        Node neg_temp=neg_dum;
        Node pos_temp=pos_dum;
        Node curr=head;
        while(curr!=null){
            if(curr.data<0){
                neg_temp.next=curr;
                neg_temp=neg_temp.next;
            }else{
                pos_temp.next=curr;
                pos_temp=pos_temp.next;
            }
            curr=curr.next;
        }
        pos_temp.next=null;
        neg_temp.next=null;
        Node rev= reverse(neg_dum.next);
         curr=rev;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=pos_dum.next;
        return rev;
    }
}