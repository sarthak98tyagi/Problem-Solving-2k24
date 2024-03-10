class Solution {
    public int candy(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        int[] l = new int[n];
        int[] r = new int[n];
        l[0]=1;
        r[n-1]=1;
        for(int i=1;i<n;i++){
            if(arr[i-1]<arr[i]){
                l[i]=l[i-1]+1;
            }
            else{
                l[i]=1;
            }
        }
        for(int i=(n-2);i>=0;i--){
            if(arr[i+1]<arr[i]){
                r[i]=r[i+1]+1;
            }
            else{
                r[i]=1;
            }
        }
        int sm = 0;
        for(int i=0;i<n;i++){
            sm+=Math.max(l[i],r[i]);
        }
        return sm;
    }
}