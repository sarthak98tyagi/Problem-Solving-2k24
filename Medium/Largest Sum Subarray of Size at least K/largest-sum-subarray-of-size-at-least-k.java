//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            long k = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            System.out.println(obj.maxSumWithK(a, n, k));
            
        }
	}
}


// } Driver Code Ends




//User function Template for Java


class Solution {
    
    public void kad(long[] arr, long[] ans){
        long mx=arr[0],cmx=arr[0];
        ans[0]=cmx;
        for(int i=1;i<arr.length;i++){
            mx = Math.max(arr[i],arr[i]+mx);
            cmx = Math.max(cmx,mx);
            ans[i]=mx;
        }
    }
    public long maxSumWithK(long arr[], long n, long k)
    {
        long sm=0 , mx=Long.MIN_VALUE;
        long[] ans = new long[arr.length];
        kad(arr,ans);
        int l = 0, r=0;
        while(r<n){
            if(r<k){
                sm+=arr[r];
                if(r==(k-1))
                    mx=Math.max(mx,sm);
                r++;
            }
            else{
                sm = sm - arr[l];
                l++;
                sm = sm + arr[r];
                r++;
                mx=Math.max(mx, Math.max(sm,sm+ans[l-1]));
            }
        }
        return mx;
    }
}