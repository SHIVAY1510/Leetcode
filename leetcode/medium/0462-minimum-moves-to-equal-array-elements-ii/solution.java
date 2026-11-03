class Solution {
    public int minMoves2(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int m=nums[n/2];
        int c=0;
        for(int i=0;i<n;i++){
            c+=Math.abs(nums[i]-m);
        }
        return c;
    }
}