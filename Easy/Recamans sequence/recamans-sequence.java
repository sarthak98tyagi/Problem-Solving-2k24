//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.recamanSequence(n);
            for(int i = 0;i < n;i++)
                System.out.print(ans.get(i)+" ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<Integer> recamanSequence(int n){
        // code here
        Set<Integer> st = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int a = 0;
        st.add(0);
        ans.add(0);
        if(n==1)
            return ans;
        for(int i=1;i<n;i++){
            int x = a - i;
            if(x>0 && !st.contains(x)){
                a=x;
            }
            else{
                x= a+i;
                a=x;
            }
            ans.add(a);
            st.add(a);
        }
        return ans;
    }
}