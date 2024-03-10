//aab
class Solution {
    public int findMin(int x, String s,int[] dp){
        if(x==s.length())
            return 0;
        if(dp[x]!=-1)
            return dp[x];
        int mx = Integer.MAX_VALUE;
        for(int i=x;i<s.length();i++){
            String w = s.substring(x,i+1);
            if(isPal(w)){
                mx=Math.min(mx,findMin(i+1,s,dp));   
            }
        }
        return dp[x]=mx+1;
    }
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        // for(int i=0;i<n;i++){
            Arrays.fill(dp,-1);
        // }
        return findMin(0,s,dp)-1;
    }
    public boolean isPal(String s){
        int l=0,r=s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r))
                    return false;
            l++;
            r--;
        }
        return true;
    }
}