class Solution {
    public int threeSumClosest(int[] arr, int t) {
        Arrays.sort(arr);
        int mn = Integer.MAX_VALUE,ans=0;
        int n=arr.length;
        for(int r=n-1;r>=2;r--){
            int l=0;
            int h = r-1,s=0;
            while(l<h){
                s=arr[l]+arr[r]+arr[h];
                if(s==t)
                    return s;
                if(s>t)
                    h=h-1;
                else
                    l+=1;
                if(Math.abs(s-t)<mn)
                {
                    ans=s;
                    mn=Math.abs(s-t);
                }
            }

        }
        return ans;

    }
}