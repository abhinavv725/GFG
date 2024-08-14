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


// } Driver Code Ends
/*
The structure of linked list is the following
*/


class Solution {
    
    private Node middle(Node head){
        Node slow=head;
        Node fast=head.next;
        while(fast !=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    
    private Node merge(Node l1, Node l2){
        Node dummy=new Node(-1);
        Node temp=dummy;
        while(l1!=null && l2!=null){
            if(l1.data>=l2.data){
                dummy.next=l2;
                l2=l2.next;
            }else{
                dummy.next=l1;
                l1=l1.next;
            }
            dummy=dummy.next;
        }
        if(l1!=null)dummy.next=l1;
        if(l2!=null)dummy.next=l2;
        return temp.next;
    }
    // Function to sort the given linked list using Merge Sort.
     Node mergeSort(Node head) {
        if(head==null || head.next==null)
            return head;
        
        Node middle = middle(head); 
        Node left=head;
        Node right=middle.next;
        middle.next=null;
        left = mergeSort(left);
        right=mergeSort(right);
        
        return merge(left,right);
    }
}


//{ Driver Code Starts.

class GFG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); i++) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            head = new Solution().mergeSort(head);
            printList(head);
        }
    }
}

// } Driver Code Ends