class Pair{
    int u;
    int t;

    public Pair(int u, int t){
        this.u=u;
        this.t=t;
    }

}
class Solution {
    public List<Integer> findAllPeople(int n, int[][] arr, int f) {
        boolean[] vis = new boolean[n];
        vis[0]=true;
        vis[f]=true;
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int[] m : arr){
            adj.get(m[0]).add(new int[]{m[1],m[2]});
            adj.get(m[1]).add(new int[]{m[0],m[2]});
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0));
        q.add(new Pair(f,0));
        int[] dis = new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[0]=0;
        dis[f]=0;
        while(!q.isEmpty()){
            Pair tmp = q.poll();
            int u = tmp.u, t=tmp.t;
            for(int[] m : adj.get(u)){
                if(dis[m[0]]>(m[1]) && m[1]>=t){
                    vis[m[0]]=true;
                    dis[m[0]]=m[1];
                    q.add(new Pair(m[0],m[1]));
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(vis[i])
                ans.add(i);
        }
        return ans;
    }
}