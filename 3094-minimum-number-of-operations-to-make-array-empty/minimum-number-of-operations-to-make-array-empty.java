class Solution {
    public int minOperations(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int el : nums){
            mp.put(el,mp.getOrDefault(el,0)+1);
        }
        int ans = 0;
        for(int k : mp.keySet()){
            int v=mp.get(k);
            int c=0;
            while(v%3!=0){
                v=v-2;
                c++;
            }
            if(v==1 || v<0)
                return -1;
            else
                c+=(v/3);
            ans+=c;
        }
        return ans;

    }
}