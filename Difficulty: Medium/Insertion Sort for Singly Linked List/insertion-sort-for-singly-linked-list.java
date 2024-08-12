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
// User function Template for Java

/*class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    */
class Solution {
    public static Node insertionSort(Node head) {
        Node dummy=new Node(-1);
        dummy.next=head;
        Node prev=head;
        Node curr=head.next;
        
        while(curr!=null){
            if(curr.data>=prev.data){
                prev=curr;
            }else{
                Node tmp = dummy;
                while(curr.data>tmp.next.data){
                    tmp=tmp.next;
                }
                
                prev.next=curr.next;
                curr.next=tmp.next;
                tmp.next=curr;
            }
            
            curr=prev.next;
        }
        return dummy.next;
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
            head = new Solution().insertionSort(head);
            printList(head);
        }
    }
}

// } Driver Code Ends