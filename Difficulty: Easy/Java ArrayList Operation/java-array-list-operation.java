//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.ArrayList;

// Driver class with driver code
class GFG {
    // Driver code
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // Declaring ArrayList
            ArrayList<Character> clist = new ArrayList<Character>();

            String q = br.readLine();

            // Looping for queries
            for (int i = 0; i < q.length(); i += 4) {
                char ch = q.charAt(i);
                Geeks obj = new Geeks();

                if (ch == 'i') {
                    char c = q.charAt(i + 2);
                    obj.insert(clist, c);
                }

                if (ch == 'f') {
                    char c = q.charAt(i + 2);
                    obj.freq(clist, c);
                }
            }
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// Geeks class with functions insert and freq
// insert : to insert element into ArrayList
// freq : function to count frequency of element
class Geeks {
    // Function to insert element
    public static void insert(ArrayList<Character> clist, char c) {
        clist.add(c);
        // your code
    }

    // Function to count frequency of element
    public static void freq(ArrayList<Character> clist, char c) {
        if(clist.contains(c)){
            System.out.println(Collections.frequency(clist,c));
        }else{
            System.out.println("-1");
        }
    }
}
