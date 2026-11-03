class Solution {
    public int minMoves(int[] nums) {
       int n=nums.length;
       int max=nums[0];
       int sum=0;
       for(int i=0;i<n;i++){
        max=Math.max(max,nums[i]);
        sum+=nums[i];
       } 
       return max*n-sum;
    }
}