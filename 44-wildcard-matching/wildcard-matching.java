//aa
//a
//base condition: s.length && p.length done 
//p.length but s left not done
//? matches single char 
//* -> match with current char and move ahead or, match with current char and be at same index
class Solution {
    public int check(int i, int j, String s, String p, int[][] dp){
        if(i>=s.length() && j==p.length())
            return 1;
        if(j>=p.length())
            return 0;
        if(i==s.length()){
            while(j<p.length()){
                if(p.charAt(j)!='*')
                    return 0;
                j++;
            }
            return 1;
                
        }
        if(i==s.length())
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int ans = 0;
        if(i<s.length() && s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
            ans = ans | check(i+1,j+1,s,p,dp);
        }
        if(p.charAt(j)=='*'){
            ans = ans | check(i,j+1,s,p,dp) | check(i+1,j,s,p,dp);
        }
        return dp[i][j]=ans;
    }
    public boolean isMatch(String s, String p) {
        int m = s.length(),n=p.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++)
            Arrays.fill(dp[i],-1);
        return check(0,0,s,p,dp)==1?true:false;
    }
}