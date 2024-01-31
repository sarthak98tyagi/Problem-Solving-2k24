class Solution {
    int[][] dir = new int[][]{{0,-1},{-1,0},{1,0},{0,1}};
    public boolean dfs(int i, int j, String s, int x, char[][] arr){
        if(x==s.length()){
            return true;
        }
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j]!=s.charAt(x))
            return false;
        char tmp = arr[i][j];
        arr[i][j]='*';
        for(int[] d: dir){
            int p = i+d[0], q = j+d[1];
            if(dfs(p,q,s,x+1,arr))
                return true;
        }
        arr[i][j]=tmp;
        return false;
    }
    public boolean exist(char[][] arr, String s) {
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(dfs(i,j,s,0,arr))
                    return true;
            }
        }
        return false;
    }
}