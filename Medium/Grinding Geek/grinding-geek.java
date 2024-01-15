//{ Driver Code Starts
import java.util.*;
import java.io.*;

public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0)
        {
            int n = scanner.nextInt();
            int total = scanner.nextInt();
            int[] cost = new int[n];
            for (int i = 0; i < n; i++) {
                cost[i] = scanner.nextInt();
            }
            Solution solution = new Solution();
            int result = solution.max_courses(n, total, cost);
            System.out.println(result);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    public int fun(int i, int t, int[] arr,int[][] dp){
        if(t==0 || i==arr.length)
            return 0;
        if(dp[i][t]!=-1)
            return dp[i][t];
        int a=0,b=0;
        if(arr[i]<=t){
            a=fun(i+1,t-arr[i]+(int)Math.floor(0.9*arr[i]),arr,dp)+1;
        }
        b=fun(i+1,t,arr,dp);
        return dp[i][t]=Math.max(a,b);
    }
    public int max_courses(int n, int t, int[] arr) {
        // code here
        int[][] dp = new int[n][t+1];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);
        return fun(0,t,arr,dp);
    }
}

