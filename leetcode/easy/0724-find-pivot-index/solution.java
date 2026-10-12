class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            int l=0;
            int r=0;
          for(int j=0;j<i;j++){
            l+=nums[j];
          }
          for(int j=i+1;j<n;j++){
            r+=nums[j];
          }
            if(l==r){
                return i;
            }
        }
       return -1;
    }
}