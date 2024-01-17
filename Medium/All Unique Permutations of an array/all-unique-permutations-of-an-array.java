//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            ArrayList<Integer> arr = new ArrayList<>();
            
            for(int i=0; i<n; i++)
                arr.add(Integer.parseInt(S[i]));

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> res = ob.uniquePerms(arr,n);
            for(int i=0; i<res.size(); i++)
            {
                for(int j=0; j<n; j++)
                {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution {
    static void fun(int i, ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> li, Set<Integer> st){
        if(li.size()==arr.size()){
            ans.add(new ArrayList<>(li));
            return;
        }
        for(int j=0;j<arr.size();j++){
            if(j==i || st.contains(j) || (j>0 && arr.get(j)==arr.get(j-1) && !st.contains(j-1)))
                continue;
            li.add(arr.get(j));
            st.add(j);
            fun(j,arr,ans,li,st);
            li.remove(li.size()-1);
            st.remove(j);
        }
    }
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        // code here
        Collections.sort(arr);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i>0 && arr.get(i)==arr.get(i-1))
                continue;
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(arr.get(i));
            Set<Integer> st = new HashSet<>();
            st.add(i);
            fun(i,arr,ans,tmp,st);
        }
        return ans;
    }
}