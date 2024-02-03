//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
    //Function to return the total number of possible unique BST.
    static int numTrees(int n)
    {
        // Your code goes here
        if(n==1)
            return 1;
        long[] dp = new long[n+1];
        dp[0]=1;
        dp[1]=1;
        long mod = 1000000007;
        for(int i=2;i<=n;i++){
            long s =0;
            for(int j=0;j<i;j++){
                s=(s+((dp[i-j-1]*dp[j])%mod))%mod;
            }
            dp[i]=s%mod;
        }
        return (int)(dp[n]%mod);
        
    }
}


//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])
    {
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //taking n
            int n =sc.nextInt();
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling method numTrees() of 
            //class Solution
            System.out.println(ob.numTrees(n));
        }
    }
}

// } Driver Code Ends