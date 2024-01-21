class Solution {
    public int rob(int[] arr) {
        int n = arr.length;
        if(n==1)
            return arr[0];
        else if(n==2)
            return Math.max(arr[0],arr[1]);
        int a = Math.max(arr[0],arr[1]), b= arr[0];
        int c;
        for(int i=2;i<n;i++){
            c = Math.max(arr[i]+b, a);
            b = a;
            a = c;
        }
        return a;
    }
}