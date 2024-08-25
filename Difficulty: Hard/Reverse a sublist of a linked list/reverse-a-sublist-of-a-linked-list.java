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

class Main {
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] input1 = br.readLine().trim().split("\\s+");
            if (input1.length < 2) {
                System.out.println(-1);
                continue;
            }
            int a = Integer.parseInt(input1[0]);
            int b = Integer.parseInt(input1[1]);

            String[] input2 = br.readLine().trim().split("\\s+");
            if (input2.length == 0) {
                System.out.println(-1);
                continue;
            }

            Node head = new Node(Integer.parseInt(input2[0]));
            Node tail = head;
            for (int i = 1; i < input2.length; i++) {
                tail.next = new Node(Integer.parseInt(input2[i]));
                tail = tail.next;
            }

            Solution ob = new Solution();
            Node newHead = ob.reverseBetween(a, b, head);
            printList(newHead);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static Node reverseBetween(int a, int b, Node head) {
        
        int count=1;
        Node dummy=new Node(-1);
        dummy.next=head;
        Node prev_a=dummy;
        Node curr=head;
        for(int i=1;i<a;i++){
            prev_a=curr;
            curr=curr.next;
            
        }
        Node curr_a=curr;
        Node prev=null;
        
        for(int i=a;i<=b;i++){
            Node nxt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
        }
        prev_a.next=prev;
        curr_a.next=curr;
        
        
        return dummy.next;
        
        
    }
}