class Solution {
    public boolean searchMatrix(int[][] arr, int x) {
        int m = arr.length,n=arr[0].length,tr=0,br=m-1,l=0,r=n-1;
        int m1,m2;
        while(tr<=br){
            m1= tr + (br-tr)/2;
            if(arr[m1][0]<= x && arr[m1][n-1]>=x){
                while(l<=r){
                    m2=l+(r-l)/2;
                    if(arr[m1][m2]==x)
                        return true;
                    else if(arr[m1][m2]>x)
                        r=m2-1;
                    else
                        l=m2+1;
                }
                return false;
            }
            else if(arr[m1][0]>x)
                br=m1-1;
            else
                tr=m1+1;
        }
        return false;
    }
}