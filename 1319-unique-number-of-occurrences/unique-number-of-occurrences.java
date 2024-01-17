class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> mp= new HashMap<>();
        for(int el: arr)
            mp.put(el,mp.getOrDefault(el,0)+1);
        Set<Integer> st = new HashSet<>();
        for(Integer val : mp.values()){
            if(st.contains(val))
                return false;
            st.add(val);
        }
        return true;
    }
}