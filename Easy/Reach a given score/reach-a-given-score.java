//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        while(t > 0)
        {
            int n = in.nextInt();
            Geeks obj = new Geeks();
            System.out.println(obj.count(n));
            t--;
        }
    }
}
// } Driver Code Ends


// Complete this function!

class Geeks {
    public long fun(int n, long[] dp){
        if(n==0)
            return 1L;
        if(n<0)
            return 0L;
        if(dp[n]!=-1)
            return dp[n];
        return dp[n]=(fun(n-5,dp)+fun(n-10,dp)+fun(n-3,dp));
    }
    public long count(int n) {
        // Add your code here.
        long[] dp = new long[n+1];
        dp[0]=1;
            for(int j : List.of(3,5,10)){
                for(int i=3;i<=n;i++){
                    if((i-j)>=0){
                        dp[i]+=dp[i-j];
                    }
                }
                
            }
        return dp[n];
    }
}