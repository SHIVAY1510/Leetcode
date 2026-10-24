class Solution {
    public int peakValleyDifference(int[] nums) {
        int n=nums.length;
        int pS=0;
        int vS=0;
        for(int i=0;i<n;i++){
            if(i>0 &&i<n-1){
                int l=nums[i-1];
                int r=nums[i+1];
                if(nums[i]>l&& nums[i]>r){
                    pS+=nums[i];
                }
                if(nums[i]<l&&nums[i]<r){
                    vS+=nums[i];
                }
            }
        }
        return pS-vS;
    }
}