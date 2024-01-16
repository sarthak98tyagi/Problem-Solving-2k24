//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int m = Integer.parseInt(input_line[0]);
            int n = Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.numberSequence(m, n));
        }
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution{
    static int ans;
    static void fun(int m, int n, int c){
        if(c==n){
            ans++;
            return;
        }
        for(int i=m;i>=1;i--){
            fun(i/2,n,c+1);
        }
        return;
    }
    static int numberSequence(int m, int n)
    {
        // code here
        ans=0;
        fun(m,n,0);
        return ans;
    }
}