//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int coeff;
    int pow;
    Node next;

    Node(int c, int p) {
        this.coeff = c;
        this.pow = p;
        this.next = null;
    }
}

class PolynomialUtils {

    // Method to append a new node to the linked list
    public static void append(Node[] head_ref, Node[] tail_ref, int new_data,
                              int new_data1) {
        Node new_node = new Node(new_data, new_data1);

        if (head_ref[0] == null) {
            head_ref[0] = new_node;
        } else {
            tail_ref[0].next = new_node;
        }
        tail_ref[0] = new_node;
    }

    // Method to print the polynomial
    public static void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.coeff + "x^" + temp.pow);
            if (temp.next != null) {
                System.out.print(" + ");
            }
            temp = temp.next;
        }
        System.out.println();
    }
}

public class PolynomialAddition {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            Node[] poly1Head = {null};
            Node[] poly1Tail = {null};

            String[] input1 = br.readLine().trim().split(" ");
            for (int i = 0; i < input1.length; i += 2) {
                int coeff = Integer.parseInt(input1[i]);
                int pow = Integer.parseInt(input1[i + 1]);
                PolynomialUtils.append(poly1Head, poly1Tail, coeff, pow);
            }

            Node[] poly2Head = {null};
            Node[] poly2Tail = {null};

            String[] input2 = br.readLine().trim().split(" ");
            for (int i = 0; i < input2.length; i += 2) {
                int coeff = Integer.parseInt(input2[i]);
                int pow = Integer.parseInt(input2[i + 1]);
                PolynomialUtils.append(poly2Head, poly2Tail, coeff, pow);
            }

            Solution obj = new Solution();
            Node sum = obj.addPolynomial(poly1Head[0], poly2Head[0]);

            PolynomialUtils.printList(sum);
        }
    }
}

// } Driver Code Ends


/*class Node{
    int coeff;
    int pow;
    Node next;
    Node(int a,int b)
    {
        coeff=a;
        pow=b;
        next=null;
    }
}*/

// Print the polynomial formed by adding both LL in the function itself.
class Solution {
    public static Node addPolynomial(Node h1, Node h2) {
        Node dummy = new Node(-1,-1);
        Node temp=dummy;
        dummy.next=h1;
        while(h1!=null && h2!=null){
            if(h1.pow==h2.pow){
                dummy.next=h1;
                h1.coeff+=h2.coeff;
                h1=h1.next;
                h2=h2.next;
            }else if(h1.pow>h2.pow){
                dummy.next=h1;
                h1=h1.next;
            }else{
                dummy.next=h2;
                h2=h2.next;
            }
            dummy=dummy.next;
        }
        if(h1 !=null){
            dummy.next=h1;
        }
        if(h2!=null)dummy.next=h2;
        
        return temp.next;
        
    }
}