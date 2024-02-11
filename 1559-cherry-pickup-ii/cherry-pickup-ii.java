class Solution {
    public int cherryPickup(int[][] arr) {
        int m=arr.length,n=arr[0].length;
        int[][][] dp = new int[m][n][n];
        for(int j1=0;j1<n;j1++){
            for(int j2=0;j2<n;j2++){
                if(j1==j2){
                    dp[m-1][j1][j2]=arr[m-1][j1];
                }
                else
                    dp[m-1][j1][j2]=arr[m-1][j1]+arr[m-1][j2];
            }
        }
        for(int i=(m-2);i>=0;i--){
            for(int j1=0;j1<n;j1++){
                for(int j2=0;j2<n;j2++){
                    int mx=Integer.MIN_VALUE;
                    for(int a=-1;a<2;a++){
                        for(int b=-1;b<2;b++){
                            if((j1+a)<0 || (j2+b)<0 || (j1+a)>=arr[0].length || (j2+b)>=arr[0].length)
                            continue;
                            mx=Math.max(mx,dp[i+1][j1+a][j2+b]);
                        }
                    }
                    dp[i][j1][j2]=mx+(j1==j2?arr[i][j1]:(arr[i][j1]+arr[i][j2]));
                }
            }
        }
        return dp[0][0][n-1];
    }
}