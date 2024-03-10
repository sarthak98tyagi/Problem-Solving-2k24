class Solution {
    public int maxPoints(int[][] arr) {
        Map<Double,Integer> mp = new HashMap<>();
        int mx=1;
        for(int i=0;i<arr.length;i++){
            int tmp=0;
            for(int j=i+1;j<arr.length;j++){
                double m=0;
                if((arr[j][0]-arr[i][0])==0)
                    m=Double.MAX_VALUE;
                else{
                    m=(double)(arr[j][1]-arr[i][1])/(arr[j][0]-arr[i][0]);
                    if(m==0)
                        m=Math.abs(m);
                }
                mp.put(m,mp.getOrDefault(m,1)+1);
                tmp=Math.max(tmp,mp.get(m));

            }
            mp.clear();
            mx=Math.max(mx,tmp);
        }
        return mx;
    }
}