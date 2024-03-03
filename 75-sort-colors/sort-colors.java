class Solution {
    public void sortColors(int[] arr) {
        
        int l=0,r=arr.length-1,i=0,tmp;
        while(i<=r){
            if(arr[i]==1)
                i++;
            else if(arr[i]==0){
                tmp=arr[i];
                arr[i]=arr[l];
                arr[l]=tmp;
                l++;
                i++;
            }
            else{
                tmp=arr[i];
                arr[i]=arr[r];
                arr[r]=tmp;
                r--;
            }
           
        }
    }
}