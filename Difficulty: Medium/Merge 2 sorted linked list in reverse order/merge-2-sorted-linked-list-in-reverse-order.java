//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}


public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0)
        {
            int N = scanner.nextInt();
            int M = scanner.nextInt();

            Node node1 = null;
            Node temp1 = null;
            for (int i = 0; i < N; i++) {
                int value = scanner.nextInt();
                Node newNode = new Node(value);
                if (node1 == null) {
                    node1 = newNode;
                    temp1 = node1;
                } else {
                    temp1.next = newNode;
                    temp1 = temp1.next;
                }
            }
    
            Node node2 = null;
            Node temp2 = null;
            for (int i = 0; i < M; i++) {
                int value = scanner.nextInt();
                Node newNode = new Node(value);
                if (node2 == null) {
                    node2 = newNode;
                    temp2 = node2;
                } else {
                    temp2.next = newNode;
                    temp2 = temp2.next;
                }
            }
    
            GfG gfg = new GfG();
            Node result = gfg.mergeResult(node1, node2);
    
            printList(result);
        }
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends


/* Structure of the node*/
/* class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
} */

class GfG
{
    Node reverse(Node head){
        Node prev=null;
        while(head!=null){
            Node nxt=head.next;
            head.next=prev;
            prev=head;
            head=nxt;
        }
        return prev;
    }
    Node merge(Node a, Node b){
        Node dummy = new Node(-1);
        Node ans = dummy;
        
        while(a!=null && b!=null){
            if(a.data>=b.data){
                dummy.next=b;
                b=b.next;
            }else{
                dummy.next=a;
                a=a.next;
            }
            dummy=dummy.next;
        }
        if(a!=null)dummy.next=a;
        if(b!=null)dummy.next=b;
        
        return ans.next;
    }
    Node mergeResult(Node node1, Node node2)
    {
	    return reverse(merge(node1,node2)); 	
    }
}
