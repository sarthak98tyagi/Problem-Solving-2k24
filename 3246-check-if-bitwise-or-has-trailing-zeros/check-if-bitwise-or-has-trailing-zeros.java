class Solution {
    public boolean hasTrailingZeros(int[] arr) {
        int c=0;
        for(int el: arr){
            if((el&1)==0){
                c++;
            }
            if(c>=2)
                return true;
        }
        return false;
    }
}