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
            
            int  k = Integer.parseInt(read.readLine());
            int  n = Integer.parseInt(read.readLine());
            int arr[][] = new int[n][n];
            String input_line1[] = read.readLine().trim().split("\\s+");
            int c = 0;
            for(int i=0;i<n;i++){
                for(int j = 0;j<n;j++){
                    arr[i][j] = Integer.parseInt(input_line1[c]);
                    c++;
                }
            }
            Solution obj = new Solution();
            System.out.println(obj.numberOfPath(n, k, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int[][] dir = new int[][]{{1,0},{0,1}};
    long ways(int i, int j, int[][] arr, int n, int k){
        if(i==(n-1) && j==(n-1) && k==arr[i][j])
            return 1;
        if(arr[i][j]>k)
            return 0;
        k=k-arr[i][j];
        long ans = 0;
        for(int[] d: dir){
            int x = i+d[0], y= j+d[1];
            if(x>=0 && y>=0 && x<n && y<n){
                ans = ans + ways(x,y,arr,n,k);
            }
        }
        return ans;
    }
    long numberOfPath(int n, int k, int [][]arr) {
        // code here
        return ways(0,0,arr,n,k);
        
    }
}