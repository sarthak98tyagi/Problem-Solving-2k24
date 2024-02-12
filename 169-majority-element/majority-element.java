class Solution {
    public int majorityElement(int[] arr) {
        
        int n=arr.length,c=1,v=arr[0],f=0;
        for(int i=1;i<n;i++){
            if(arr[i]==v)
                c=c+1;
            else 
                c=c-1;
            if(c==0){
                v=arr[i];
                c=1;
            }
        }

        return v;
    }
}