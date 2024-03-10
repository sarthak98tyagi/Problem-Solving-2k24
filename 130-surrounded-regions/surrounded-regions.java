class Solution {
    public void solve(char[][] arr) {
        Queue<int[]> q = new LinkedList<>();
        int n = arr[0].length, m = arr.length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]=='O' && (i==0 || j==0 || i==(m-1) || j==(n-1)))
                    q.add(new int[]{i,j});
            }
        }
        int[][] dir = new int[][]{{-1,0},{0,-1},{0,1},{1,0}};
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            // System.out.println(tmp[0]+" "+tmp[1]);
            arr[tmp[0]][tmp[1]]='*';
            for(int[] d: dir){
                int x = tmp[0]+d[0], y = tmp[1]+d[1];
                if(x>=0 && y>=0 && x<m && y<n && arr[x][y]=='O')
                    q.add(new int[]{x,y});
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]=='*')
                    arr[i][j]='O';
                else
                    arr[i][j]='X';
            }
        }
    }
}