//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {
    /* Function to print nodes in a given linked list */
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    // Driver program to test the above functions
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            List<Node> arr = new ArrayList<>();
            List<Integer> nums = new ArrayList<>();
            String input = sc.nextLine();

            Scanner ss = new Scanner(input);
            while (ss.hasNextInt()) {
                nums.add(ss.nextInt());
            }
            int ind = 0;
            int N = nums.size();

            while (ind < N) {
                int n = nums.get(ind++);
                int x = nums.get(ind++);
                Node head = new Node(x);
                Node curr = head;
                n--;

                for (int i = 0; i < n; i++) {
                    x = nums.get(ind++);
                    Node temp = new Node(x);
                    curr.next = temp;
                    curr = temp;
                }
                arr.add(head);
            }

            Solution obj = new Solution();
            Node res = obj.mergeKLists(arr);
            printList(res);
        }
        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java
/*class Node
{
    int data;
    Node next;

    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

// arr is an array of Nodes of the heads of linked lists

class Solution {
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

    Node mergeKLists(List<Node> arr) {
        
        while(arr.size()!=1){
            Node x = arr.remove(0);
            Node y = arr.remove(0);
            arr.add(merge(x,y));
        }
        return arr.get(0);
    }
}