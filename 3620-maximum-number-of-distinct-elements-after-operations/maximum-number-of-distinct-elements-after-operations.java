class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int occupied = Integer.MIN_VALUE;
        int ans = 0;
        for (int num : nums) {
            if (occupied < num + k) {
                occupied = Math.max(occupied + 1, num - k);
                ans++;
            }
        }
        return ans;
    }
}