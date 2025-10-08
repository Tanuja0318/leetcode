class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            long spell = spells[i];
            long minPotion = (long) Math.ceil((double) success / spell);
            int index = binarySearch(potions, minPotion);
            res[i] = m - index;
        }
        return res;
    }
    private int binarySearch(int[] potions, long target) {
        int l = 0, r = potions.length - 1, ans = potions.length;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (potions[mid] >= target) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;        
    }
}