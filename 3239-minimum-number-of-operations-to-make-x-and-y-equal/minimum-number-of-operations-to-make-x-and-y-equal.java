class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
                if(y>=x)
            return y-x;
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        Set<Integer> st = new HashSet<>();
        int c=0;
        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0;i<n;i++){
                int u = q.poll();
                if(u==y)
                    return c;
                if(u%11==0 && !st.contains(u/11)){
                    q.add(u/11);
                    st.add(u/11);
                }
                if(u%5==0 && !st.contains(u/5)){
                    q.add(u/5);
                    st.add(u/5);
                }
                if(!st.contains(u-1)){
                    q.add(u-1);
                    st.add(u-1);
                }
                if(!st.contains(u+1)){
                    q.add(u+1);
                    st.add(u+1);
                }
            }
            c=c+1;
        }
        return -1;

    }
}