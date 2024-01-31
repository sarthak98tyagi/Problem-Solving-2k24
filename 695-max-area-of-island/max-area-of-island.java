class Solution {
    int[][] dir = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
    public int dfs(int i, int j, int[][] arr){
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j]==0){
            return 0;
        }
        arr[i][j]=0;
        int ans=0;
        for(int[] d: dir){
            ans+=dfs(d[0]+i,d[1]+j,arr);
        }
        return ans+1;
    }
    public int maxAreaOfIsland(int[][] arr) {
        int mx=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==1){
                    mx=Math.max(mx,dfs(i,j,arr));
                }
            }
        }
        return mx;
    }
}