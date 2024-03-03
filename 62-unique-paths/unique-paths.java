class Solution {
    int[][] dir = new int[][]{{0,1},{1,0}};
    public int paths(int x, int y, int m, int n, int[][] dp){
        if(x==(m-1) && y==(n-1))
            return 1;
        if(dp[x][y]!=-1)
            return dp[x][y];
        int ans = 0 ;
        for(int[] d: dir){
            int i = d[0]+x, j = d[1]+y;
            if(i>=0 && j>=0 && i<m && j<n){
                ans+=paths(i,j,m,n,dp);
            }
        }
        return dp[x][y]=ans;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++)
            Arrays.fill(dp[i],-1);
        return paths(0,0,m,n,dp);
    }
}