class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n=nums.length;
        int maxSum=0;
        double avg=Double.NEGATIVE_INFINITY;
        for(int i=0;i<=n-k;i++){
            int sum=0;
            for(int j=i;j<i+k;j++){
                sum+=nums[i];
            }
            maxSum=Math.max(maxSum,sum);
            avg=(double)maxSum/k;
        }
        return avg;
    }
}