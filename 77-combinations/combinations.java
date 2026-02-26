class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        backtrack(n, k, res, new ArrayList<>());
        return res;
    }
    public void backtrack(int n, int k, List<List<Integer>> res, List<Integer> curr){
        if(k==0){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(n==0){
            return;
        }
        curr.add(n);
        backtrack(n-1, k-1, res, curr);
        curr.remove(curr.size()-1);
        backtrack(n-1, k, res, curr);
    }
}