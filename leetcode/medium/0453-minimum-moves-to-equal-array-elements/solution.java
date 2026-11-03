class Solution {
    public int minMoves(int[] nums) {
        int n=nums.length;
        int m=nums[0];
        for(int i=1;i<n;i++){
            m=Math.min(m,nums[i]);
        }
        int moves=0;
        for(int i=0;i<n;i++){
            moves+=nums[i]-m;
        }
        return moves;
    }
}