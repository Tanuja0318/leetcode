class Solution {
    public int maxSum(int[][] grid) {
        int max=Integer.MIN_VALUE;
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(valid(i,j,m,n)){
                    int uSum=upperSum(i,j,grid);
                    int lSum=lowerSum(i,j,grid);
                    int sum=uSum+grid[i][j];
                    sum+=lSum;
                    max=Math.max(sum,max);
                }
            }
        }
        return max;
    }
    public boolean valid(int i,int j,int m,int n){
        if(i-1>=0&&i+1<m){
            if(j-1>=0&&j+1<n){
                return true;
            }
        }
        return false;
    }
    public int upperSum(int i,int j,int [][]grid){
        int sum=0;
        for(int x=j-1;x<=j+1;x++){
            sum+=grid[i-1][x];
        }
        return sum;
    }
     public int lowerSum(int i,int j,int [][]grid){
        int sum=0;
        for(int x=j-1;x<=j+1;x++){
            sum+=grid[i+1][x];
        }
        return sum;
    }
}