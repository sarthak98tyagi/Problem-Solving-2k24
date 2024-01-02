//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine().trim();
            String[] S1 = s1.split(" ");
            int n = Integer.parseInt(S1[0]);
            int k = Integer.parseInt(S1[1]);
            String s2 = br.readLine().trim();
            String[] S2 = s2.split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(S2[i]);
            }
            Solution ob = new Solution();
            boolean ans = ob.canPair(nums, k);
            if (ans)
                System.out.println("True");
            else
                System.out.println("False");
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    public boolean canPair(int[] arr, int k) {
        // Code here
        int n = arr.length;
        if(n%2!=0)
            return false;
        for(int i=0;i<n;i++){
            arr[i]=arr[i]%k;
        }
        Map<Integer,Integer> st = new HashMap<>();
        for(int el : arr){
            int d = (k-el)%k;
            if(st.containsKey(d) && st.get(d)>0){
                int f = st.get(d);
                f=f-1;
                if(f==0)
                    st.remove(d);
                else
                    st.put(d,f);
                
            }
            else{
                st.put(el,st.getOrDefault(el,0)+1);
            }
        }
        return st.size()==0?true:false;
    }
}