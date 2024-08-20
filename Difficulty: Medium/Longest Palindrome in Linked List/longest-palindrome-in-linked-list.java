//{ Driver Code Starts
import java.io.*;
import java.lang.Math;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class PalindromeLL {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] input = br.readLine().trim().split("\\s+");
            Node head = new Node(Integer.parseInt(input[0]));
            Node tail = head;
            for (int i = 1; i < input.length; i++) {
                tail.next = new Node(Integer.parseInt(input[i]));
                tail = tail.next;
            }
            Solution ob = new Solution();
            System.out.println(ob.maxPalindrome(head));
        }
    }

    public static Node insert(Node head, int val) {
        if (head == null) return new Node(val);
        head.next = insert(head.next, val);
        return head;
    }

    /*public static void print(Node head){
        while(head!=null){
            System.out.println(head.data);
            head=head.next;
        }
    }*/
}
// } Driver Code Ends


class Solution {
    static int count(Node first,Node second){
        Node a=first,b=second;
        int cnt=0;
        while(a!=null && b!=null){
            if(a.data==b.data){
                a=a.next;
                b=b.next;
                cnt++;
            }else{
                break;
            }
        }
        return cnt;
    }
    public static int maxPalindrome(Node head) {
        Node curr=head,prev=null;
        int ans=0;
        while(curr!=null){
            Node nxt = curr.next;
            curr.next=prev;
            ans=Math.max(ans,2*count(prev,nxt)+1);//Odd case
            ans = Math.max(ans,2*count(curr,nxt));//Even case
            
            prev=curr;
            curr=nxt;
        }
        return ans;
    }
}