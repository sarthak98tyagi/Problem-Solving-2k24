//{ Driver Code Starts
import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}
// } Driver Code Ends


class Solution
{
    public static Node build(int[] pre, int ps, int pe, int[] ino, int ins, int ine){
        if(ps>pe || ins>ine)
            return null;
        int el = pre[ps];
        int idx =-1;
        for(int i=ins;i<=ine;i++){
            if(ino[i]==el){
                idx=i;
                break;
            }
        }
        int count = idx-ins;
        Node root = new Node(el);
        root.left = build(pre,ps+1,ps+count,ino,ins,idx-1);
        root.right = build(pre,ps+count+1,pe,ino,idx+1,ine);
        return root;
    }
    public static Node buildTree(int ino[], int pre[], int n)
    {
        // code here 
        Node root = build(pre,0,pre.length-1,ino,0,ino.length-1);
        return root;
    }
}
