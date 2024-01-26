class Solution {
    public long fn(int m,int n,int mx,int x,int y,long[][][] arr){
        long md = 1000000007;
        
        if(x<0 || y<0 || x>=m || y>=n)
            return 1;
        if(mx==0)
            return 0;
        if(arr[x][y][mx]!=-1)
            return arr[x][y][mx];
        long ans = (fn(m,n,mx-1,x-1,y,arr)+fn(m,n,mx-1,x,y-1,arr)+fn(m,n,mx-1,x,y+1,arr)+fn(m,n,mx-1,x+1,y,arr))%md;
        return arr[x][y][mx]=ans;
        
        
    }
    public int findPaths(int m, int n, int mx, int x, int y) {
        if(mx==0)
            return 0;
        long[][][] arr = new long[m][n][mx+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<=mx;k++){
                    arr[i][j][k]=-1;
                }
            }
        }
        return (int)fn(m,n,mx,x,y,arr);
    }
}