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
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void addressStore(Node[] arr, Node head) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            arr[i] = temp;
            i++;
            temp = temp.next;
        }
    }

    public static boolean check(Node[] before, Node[] after, int num, int k) {
        if (k > num) return true;

        for (int i = 0; i < num; i++) {
            if ((i == k - 1) || (i == num - k)) {
                if (!((before[k - 1] == after[num - k]) &&
                      (before[num - k] == after[k - 1]))) {
                    return false;
                }
            } else {
                if (before[i] != after[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = sc.nextLine();
            Scanner ss = new Scanner(input);

            // Read numbers from the input line
            while (ss.hasNextInt()) {
                arr.add(ss.nextInt());
            }

            int k = sc.nextInt();
            sc.nextLine(); // Consume the newline

            Node head = null;

            // Check if the array is empty
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); ++i) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }

            int num = arr.size();
            Node[] before = new Node[num];
            addressStore(before, head);

            Solution ob = new Solution();
            head = ob.swapKthNode(head, k);

            Node[] after = new Node[num];
            addressStore(after, head);

            if (check(before, after, num, k))
                System.out.println("true");
            else
                System.out.println("false");
        }

        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
     int length(Node head){
        int count=0;
        while(head!=null){
            count++;
            head=head.next;
            
        }
        return count;
    }
     Node swapKthNode(Node head, int k) {
        int num=length(head);
       if(head==null || num<k)return head;
       Node x=head,y=head, prevX=null,prevY=null;
       
       for(int i=1;i<k;i++){
           prevX=x;
           x=x.next;
       }
       for(int i=1;i<num-k+1;i++){
           prevY=y;
           y=y.next;
       }
       if(prevX!=null){
           prevX.next=y;
       }
       if(prevY!=null){
           prevY.next=x;
       }
       Node temp = x.next;
       x.next=y.next;
       y.next=temp;
       if(k==1)head=y;
       if(k==num)head=x;
       return head;
    }
}