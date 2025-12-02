class Solution {
    public int[] productExceptSelf(int[] nums) {
        // n -> length nums
        int n=nums.length;
        //create 3 arrays left,right,result
        int[] left=new int[n];
        int[] right=new int[n];
        int[] result=new int[n];
        //update left array; 1 to n : left[i]=left[i-1]*nums[i-1]
        left[0]=1;
        for(int i=1;i<n;i++){
            left[i]=left[i-1]*nums[i-1];
        }
        //update right array; n-2 to 0 : right[i]=right[i+1]*nums[i+1]
        right[n-1]=1;
        for(int i=n-2;i>=0;i--){
            right[i]=right[i+1]*nums[i+1];
        }
        //update res:0-> n-1 : res[i]=left[i]*right[i]
        for(int i=0;i<n;i++){
            result[i]=left[i]*right[i];
        }
        //return result
        return result;
    }
}