class Solution {
    public int getCommon(int[] arr1, int[] arr2) {
         int n1=arr1.length, n2=arr2.length;
         int i=0,j=0;
         while(i<n1 && j<n2){
             if(arr1[i]==arr2[j]){
                    return arr1[i];
             }
             else if(arr1[i]<arr2[j]){
                 i++;
             }
             else{
                 j++;
             }
         }
         return -1;
    }
}