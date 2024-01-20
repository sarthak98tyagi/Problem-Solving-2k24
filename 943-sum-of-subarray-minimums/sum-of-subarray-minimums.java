class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        int n = arr.length;
        int[] nx = new int[n];
        int[] pr = new int[n];
        for(int i=0;i<n;i++){
            nx[i]=n-1-i;
            pr[i]=i;
        }
        for(int i=0;i<n;i++){
            while(!s1.isEmpty() && arr[s1.peek()]>arr[i]){
                nx[s1.peek()]=(i-s1.peek()-1);
                s1.pop();
            }
            s1.push(i);
        }
        for(int i=(n-1);i>=0;i--){
            while(!s2.isEmpty() && arr[s2.peek()]>=arr[i]){
                pr[s2.peek()]=(s2.peek()-i-1);
                s2.pop();
            }
            s2.push(i);
        }
        long mod = 1000000007;
        long count = 0;
        for(int i=0;i<n;i++){
            count = (count + (arr[i]*((pr[i]+1)%mod*(nx[i]+1)%mod)%mod)%mod)%mod;
        }
        return (int)count;
    }
}