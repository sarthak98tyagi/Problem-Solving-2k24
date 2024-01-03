//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    public int smallestSubstring(String s) {
        // Code here
        if(s.length()<3)
            return -1;
        int l=0, r=0;
        Map<Character,Integer> mp = new HashMap<>();
        int mn = Integer.MAX_VALUE;
        while(r<s.length()){
            Character ch = s.charAt(r);
            if(r<3){
                mp.put(ch,mp.getOrDefault(ch,0)+1);
                if(mp.size()==3)
                    mn=Math.min(mn,3);
            }
            else{
                mp.put(ch,mp.getOrDefault(ch,0)+1);
                if(mp.size()==3){
                    while(l<=(r-2) && mp.size()==3){
                        mn=Math.min(mn,r-l+1);
                        Character x = s.charAt(l);
                        int f = mp.get(x)-1;
                        if(f==0)
                            mp.remove(x);
                        else
                            mp.put(x,f);
                        l++;
                        
                    }
                }
            }
            r++;
        }
        return mn==Integer.MAX_VALUE?-1:mn;
        
    }
}
