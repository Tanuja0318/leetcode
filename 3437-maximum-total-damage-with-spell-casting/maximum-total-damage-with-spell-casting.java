class Solution {
    private Long[] memo;           
    private int n;
    private int[] distinct;      
    private int[] count;           
    private int[] nxt;               
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : power) {
            freq.merge(x, 1, Integer::sum);
        }
        List<Integer> uniqList = new ArrayList<>(freq.keySet());
        Collections.sort(uniqList);
        n = uniqList.size();
        distinct = new int[n];
        count = new int[n];
        for (int i = 0; i < n; i++) {
            distinct[i] = uniqList.get(i);
            count[i] = freq.get(distinct[i]);
        }
        nxt = new int[n];
        for (int i = 0; i < n; i++) {
            long val = (long) distinct[i] + 2;
            int j = upperBound(distinct, i + 1, n, val);
            nxt[i] = j;
        }
        memo = new Long[n];
        return dfs(0);
    }
    private long dfs(int i) {
        if (i >= n) {
            return 0L;
        }
        if (memo[i] != null) {
            return memo[i];
        }
        long skip = dfs(i + 1);
        long take = (long) distinct[i] * count[i] + dfs(nxt[i]);
        long ans = Math.max(skip, take);
        memo[i] = ans;
        return ans;
    }
    private int upperBound(int[] arr, int lo, int hi, long value) {
        int l = lo, r = hi;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if ((long) arr[mid] > value) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;  
    }
}