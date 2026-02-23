class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        backtrack(res,n,"",0,0);
        return res;
    }
    public void backtrack(List<String> res, int n, String curr, int op, int cl){
        if(curr.length()==2*n){
            res.add(curr);
            return;
        }
        if(op<n) backtrack(res, n, curr+"(", op+1, cl);
        if(cl<op) backtrack(res,n,curr+")", op, cl+1);
    }
}