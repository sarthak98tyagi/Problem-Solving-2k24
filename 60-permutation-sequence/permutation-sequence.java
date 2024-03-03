class Solution {
    public String getPermutation(int n, int k) {
        int f = 1;
        List<Integer> l = new ArrayList<>();
        k=k-1;
        for(int i=1;i<n;i++){
            f=f*i;
            l.add(i);
        }
        l.add(n);
        StringBuilder ans = new StringBuilder("");
        while(l.size()>0){
            int t = (k/f);
            ans.append(l.get(t)+"");
            l.remove(t);
            if(l.size()==0)
                break;
            k=k%f;
            f=f/l.size();
        }
        return ans.toString();
    }
}