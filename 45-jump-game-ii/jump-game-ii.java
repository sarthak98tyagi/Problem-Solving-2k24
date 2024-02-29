class Solution {
    public int jump(int[] arr) {
        int i=0, j=0;
        int ans = 0,ds=0;
        while(i<arr.length-1){
            j=Math.max(j,i+arr[i]);
            if(i==ds){
                ds=j;
                ans++;
            }
            i++;
        }
        return ans;
    }
}