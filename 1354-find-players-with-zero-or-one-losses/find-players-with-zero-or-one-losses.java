class Solution {
    public List<List<Integer>> findWinners(int[][] arr) {
        Map<Integer,Integer> ind = new TreeMap<>();
        for(int[] ar : arr){
            if(!ind.containsKey(ar[0]))
                ind.put(ar[0],0);
            ind.put(ar[1],ind.getOrDefault(ar[1],0)+1);
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for(Integer k : ind.keySet()){
            if(ind.get(k)==0){
                l1.add(k);
            }
            else if(ind.get(k)==1)
                l2.add(k);
        }
        ans.add(l1);
        ans.add(l2);
        return ans;

    }
}