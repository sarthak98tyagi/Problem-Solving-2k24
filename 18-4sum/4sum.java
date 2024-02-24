class Solution {
    public List<List<Integer>> fourSum(int[] arr, int t) {
        Arrays.sort(arr);
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=(n-1);i>=3;i--){
            while(i>=3 && i<(n-1) && arr[i]==arr[i+1]){
                i--;
            }
            long el = t - arr[i];
            for(int j=(i-1);j>=2;j--){
                while(j>=2 && j<(i-1) && arr[j]==arr[j+1]){
                    j--;
                }
                int l = 0, r = j-1;
                long del = el- arr[j];
                while(l<r){
                    long sum = arr[l]+arr[r];
                    if(sum==del){
                        ans.add(List.of(arr[l],arr[r],arr[j],arr[i]));
                        l=l+1;
                        r=r-1;
                        while(l<r && arr[l]==arr[l-1])
                            l++;
                    }
                    else if(sum>del){
                        r=r-1;
                        while(r>l && arr[r]==arr[r+1])
                            r--;
                    } 
                    else{
                        l=l+1;
                        while(l<r && arr[l]==arr[l-1])
                            l++;
                    }
                }
            }
        }
        return ans;
    }
}