class Solution {
    public int missingInteger(int[] nums) {
        int si=0,ei=0,sm=nums[0],ans=sm,mxlen=1,mx=sm;
        boolean flag=true;
        Set<Integer> st = new HashSet<>();
        st.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            st.add(nums[i]);
            if(nums[i]==(nums[i-1]+1) && flag){
                sm+=nums[i];
            }
            else{
                flag=false;
            }
        }
        while(true){
            if(st.contains(sm)){
                sm++;
            }
            else
                return sm;
        }
    }
}