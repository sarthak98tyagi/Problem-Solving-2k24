class Solution {
    public int singleNumber(int[] arr) {
        int el=0;
        for(int i=0;i<32;i++){
            int t = 0;
            for(int x: arr){
                if(((x>>i)&1)==1)
                    t++;
            }
            if(t%3!=0)
                t=1;
            else
                continue;
            el=el|(1<<i);
        }
        return el;
    }
}