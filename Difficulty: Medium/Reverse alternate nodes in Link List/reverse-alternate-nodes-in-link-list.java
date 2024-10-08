//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Rearr
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                temp.next = new Node(a);
                temp = temp.next;
            }
            
            Solution ob = new Solution();
            ob.rearrange(head);
            printLast(head);
            System.out.println();
        }
    }
    
    public static void printLast(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/
class Solution
{
    private static Node reverse(Node head){
        Node prev=null,curr=head;
        while(curr!=null){
            Node nxt = curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
        }
        return prev;
    }
    public static void rearrange(Node odd)
    {
        if(odd==null || odd.next==null)return;
        
        Node dumm = new Node(-1);
        Node temp = dumm, curr=odd;
        
        while(curr!=null && curr.next!=null){
            Node nxt=curr.next;
            curr.next=curr.next.next;
            temp.next=nxt;
            temp=temp.next;
            curr=curr.next;
            
        }
        temp.next=null;
        
        curr=odd;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=reverse(dumm.next);
    }
}
