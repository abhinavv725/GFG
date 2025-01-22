//{ Driver Code Starts
// driver

import java.io.*;
import java.util.*;


// } Driver Code Ends


class Solution {
    private static Node reverse(Node head){
        Node prev=null;
        while(head!=null){
            Node temp = head.next;
            head.next=prev;
            prev=head;
            head=temp;
        }
        return prev;
    }
    private static Node remove(Node head){
        while(head.data==0){
            head=head.next;
        }
        return head;
    }
    static Node addTwoLists(Node num1, Node num2) {
        Node rev1 = reverse(num1);
        Node rev2 = reverse(num2);
        int carry=0;
        Node ans = new Node(-1);
        Node curr=ans;
         
        while(rev1!=null || rev2!=null || carry==1){
            int sum=carry;
            if(rev1!=null){
                sum+=rev1.data;
                rev1=rev1.next;
            }
            if(rev2!=null){
                sum+=rev2.data;
                rev2=rev2.next;
            }
            if(sum>=10){
                sum-=10;
                carry=1;
            }else{
                carry=0;
            }
            curr.next = new Node(sum);
            curr=curr.next;
        }
        
        return remove(reverse(ans.next));
    }
}

//{ Driver Code Starts.

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG {

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine());
        while (T-- > 0) {

            String str[] = read.readLine().trim().split(" ");
            int n = str.length;

            Node num1 = new Node(Integer.parseInt(str[0]));
            Node tail = num1;
            for (int i = 1; i < n; i++) {
                int val = Integer.parseInt(str[i]);
                tail.next = new Node(val);
                tail = tail.next;
            }

            String str2[] = read.readLine().trim().split(" ");
            int m = str2.length;

            Node num2 = new Node(Integer.parseInt(str2[0]));
            tail = num2;
            for (int i = 1; i < m; i++) {

                tail.next = new Node(Integer.parseInt(str2[i]));
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends