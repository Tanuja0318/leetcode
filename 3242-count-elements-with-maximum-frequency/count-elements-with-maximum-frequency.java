class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] count = new int[101];  
        int maxFreq = 0;
        for (int x : nums) {
            count[x]++;
            if (count[x] > maxFreq) {
                maxFreq = count[x];
            }
        }
        int sum = 0;
        for (int c : count) {
            if (c == maxFreq) {
                sum += c;
            }
        }
        return sum;
    }
}