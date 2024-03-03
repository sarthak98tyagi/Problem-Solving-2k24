class Solution {
    public int[] plusOne(int[] arr) {
        int n = arr.length,c=1;
        for(int i=(n-1);i>=0;i--){
            int sm = arr[i]+c;
            arr[i]=sm%10;
            c=sm/10;
        }
        int x=0;
        int[] ans;
        if(c>0){
            ans = new int[n+1];
            ans[0]=c;
            x++;
        }
        else{
            ans = new int[n];
        }
        for(int i=0;i<n;i++){
            ans[x++]=arr[i];
        }
        return ans;
    }
}