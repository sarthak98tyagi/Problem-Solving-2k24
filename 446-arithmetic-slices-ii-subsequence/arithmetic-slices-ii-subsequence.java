class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans=0,x=0,y=0;
        long cd;
        HashMap<Integer,Integer>[] hm= new HashMap[nums.length];
        for(int i=0;i<nums.length;i++){
            hm[i]=new HashMap<>();
        }
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                cd=(long)nums[j] - (long)nums[i];
                if(cd<=Integer.MIN_VALUE || cd>=Integer.MAX_VALUE)
                    continue;
                x=hm[j].getOrDefault((int)cd,0);
                y=hm[i].getOrDefault((int)cd,0);
                ans+=y;
                hm[j].put((int)cd,x+y+1);
            }
        }
        return ans;
    }
}