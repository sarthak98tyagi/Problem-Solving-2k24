class Solution {
    public boolean valid(int x, int y, char[][] arr, char k){
        for(int j=0;j<9;j++){
            if(arr[x][j]==k)
                return false;
        }
        for(int i=0;i<9;i++){
            if(arr[i][y]==k)
                return false;
        }
        int rc = ((x/3)*3), cc = ((y/3)*3);
        for(int i=rc;i<(rc+3);i++){
            for(int j=cc;j<(cc+3);j++){
                if(arr[i][j]==k)
                    return false;
            }
        }
        return true;
    }
    public boolean solve(char[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(arr[i][j]=='.'){
                    for(char k='1';k<='9';k++){
                        if(valid(i,j,arr,k)){
                            arr[i][j]=k;
                            if(solve(arr))
                                return true;
                            arr[i][j]='.';
                        }
                    } 
                    return false;
                }
                
            }
        }
        return true;
    }
    public void solveSudoku(char[][] arr) {
        solve(arr);
    }
}