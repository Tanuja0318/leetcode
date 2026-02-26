class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        backtrack(nums, res, new ArrayList<>());
        return res;
    }
    public void backtrack(int[] nums, List<List<Integer>> res, List<Integer> curr){
        if(curr.size()==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int num:nums){
            if(curr.contains(num)){
                continue;
            }
            curr.add(num);
            backtrack(nums, res, curr);
            curr.remove(curr.size()-1);
        }
    }
}