//{ Driver Code Starts
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}


class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
                
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void deletetree( Node root)
{
    if(root == null)
    return;
    deletetree(root.left);
    deletetree(root.right);
    root.left=null;
    root.right=null;
}
    static void printInorder(Node root){
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException {
	        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
	        while(t-- > 0){
	            String s= br.readLine();
	            Node root = buildTree(s);
	            
	            Tree tr=new Tree();
	            ArrayList<Integer> A=new ArrayList<Integer>();
	            tr.serialize(root, A);
	            deletetree(root);
	            root = null;
	            
	            Node getRoot=tr.deSerialize(A);
	            printInorder(getRoot);
	            System.out.println();
	        }
	}
}
// } Driver Code Ends


/*Complete the given function
Node is as follows:
class Tree{
	int data;
	Tree left,right;
	Tree(int d){
		data=d;
		left=right=null;
	}
}*/
class Tree 
{
    //Function to serialize a tree and return a list containing nodes of tree.
	public void serialize(Node root, ArrayList<Integer> arr) 
	{
	    //code here
	    Queue<Node> q = new LinkedList<>();
	    q.add(root);
	    while(!q.isEmpty()){
	        Node tmp = q.poll();
	        arr.add(tmp.data);
	        if(tmp.data==-1){
	            continue;
	        }
	        if(tmp.left==null){
	            q.add(new Node(-1));
	        }
	        else{
	            q.add(tmp.left);
	        }
	       if(tmp.right==null)
	            q.add(new Node(-1));
	        else
	            q.add(tmp.right);
	    }
	    
	}
	
	//Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> arr)
    {
        //code here
        Node root=new Node(arr.get(0)) ;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        for(int i=1;i<arr.size();i++){
            Node pr = q.poll();
            if(arr.get(i)!=-1){
                pr.left = new Node(arr.get(i));
                q.add(pr.left);
            }
            if(arr.get(++i)!=-1){
                pr.right = new Node(arr.get(i));
                q.add(pr.right);
            }

            
        }
        return root;
        
    }
};