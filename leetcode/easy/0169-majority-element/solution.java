class Solution {
    public int majorityElement(int[] nums) {
        // int n=nums.length;
        // for(int i=0;i<n;i++){
        //     int c=0;
        //     for(int j=0;j<n;j++){
        //         if(nums[i]==nums[j]){
        //             c++;
        //         }
        //     }
        //         if(c> n/2){
        //             return nums[i];
        //         }
        // }
        // return -1;
        int n=nums.length;
        int c=0;
        int candidate=0;
        for(int num:nums){
            if(c==0){
            candidate=num;
        }
            if(candidate==num){
                c++;
            }
            else{
                c--;
            }
        }
        return candidate;
    }
}