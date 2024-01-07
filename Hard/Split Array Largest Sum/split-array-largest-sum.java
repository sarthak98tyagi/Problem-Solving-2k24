//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    
    static int check(int[] arr, int n, int k, int m){
        int sm =0, c=1;
        for(int i=0;i<n;i++){
            if((sm+arr[i])<=m){
                sm+=arr[i];
            }
            else{
                c++;
                sm=arr[i];
            }
        }
        return c;
    }
    
    static int splitArray(int[] arr , int n, int k) {
        // code here
        int sm = 0, mx =0 ;
        for(int el : arr)
        {    
            sm+=el;
            mx=Math.max(mx,el);
        }
        int l =mx, r=sm;
        int ans = 0;
        while(l<=r){
            int m = l+(r-l)/2;
            int x = check(arr,n,k,m);
            if(x<=k){
                r=m-1;
            }
            else{
                l=m+1;
            }
        }
        return l;
    }
    
};