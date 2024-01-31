class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int cg=0,rg=0,i=0;
        int start=-1;
        while(i<gas.length){
            if((gas[i]+cg)>=cost[i]){
                cg = gas[i]+cg-cost[i];
                if(start==-1)
                start=i;
            }
            else{
                rg+= cost[i]-gas[i]-cg;
                start=-1;
                cg=0;
            }
            i++;
        }
        return (cg>=rg)?start:-1
;    }
}