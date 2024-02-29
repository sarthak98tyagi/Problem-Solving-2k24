class Solution {
    public boolean canJump(int[] arr) {
        int i=0,j=0,n=arr.length;
        while(i<n){
            if(i>j)
                return false;
            j=Math.max(j,i+arr[i]);
            i++;
        }
        return true;
    }
}