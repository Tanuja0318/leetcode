class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, res, new ArrayList<>());
        return res;
    }
    public void backtrack(int[] nums, int target, int start,
                          List<List<Integer>> res,
                          List<Integer> curr) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target) continue;
            curr.add(nums[i]);
            backtrack(nums, target - nums[i], i, res, curr);
            curr.remove(curr.size() - 1); 
        }
    }
}